package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.karlaFont
import com.example.littlelemon.ui.theme.primary1

@Composable
fun Onboarding(navController: NavHostController) {
    val context = LocalContext.current
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var emailAddress by rememberSaveable { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(25.dp)
                    .width(185.dp)
                    .height(40.dp)
            )
            Text(
                text = "Let's get to know you",
                color = Color.White,
                fontFamily = karlaFont,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = primary1)
                    .padding(45.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Personal information",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = karlaFont,
            modifier = Modifier
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = {
                Text(
                    "First name",
                    fontFamily = karlaFont
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = {
                Text(
                    "Last name",
                    fontFamily = karlaFont
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        )
        OutlinedTextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            label = {
                Text(
                    "Email",
                    fontFamily = karlaFont
                )
            },
            supportingText = {
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red, fontSize = 14.sp
                    )
                }
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        )

        Spacer(modifier = Modifier.height(125.dp))
        Button(
            onClick = {
                if (firstName.isBlank() || lastName.isBlank() || emailAddress.isBlank()) {
                    Toast.makeText(
                        context,
                        "Registration unsuccessful. Please enter all data.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val savePref = PreferencesManager(context = context)
                    savePref.saveData(name, firstName)
                    savePref.saveData(surname, lastName)
                    savePref.saveData(email, emailAddress)
                    navController.navigate(Home.route)
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                }
            },
            border = BorderStroke(1.dp, Color(0xFFEE9972)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.Black
            )
        )
        {
            Text(
                "Register",
                fontFamily = karlaFont,
                fontSize = 16.sp
            )
        }
    }
}




