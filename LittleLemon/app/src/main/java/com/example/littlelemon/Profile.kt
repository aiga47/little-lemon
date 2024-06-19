package com.example.littlelemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.karlaFont


@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val getPref = PreferencesManager(context = context)
    val getName = getPref.getData(name, "")
    val getSurname = getPref.getData(surname, "")
    val getEmail = getPref.getData(email, "")

    Column(
        verticalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            IconButton(onClick = { navController.navigate(Home.route) }) {
                Icon(
                    Icons.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterStart)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(185.dp)
                    .height(40.dp)
                    .align(Alignment.Center)
            )
        }
        Column(modifier = Modifier
            .padding(40.dp)
        ) {
            Text(text = "Profile information",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                fontSize = 20.sp
                )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "First name: $getName",
                fontFamily = karlaFont,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 15.dp))
            Text(text = "Last name: $getSurname",
                fontFamily = karlaFont,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 15.dp))
            Text(text = "Email address: $getEmail",
                fontFamily = karlaFont,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 15.dp))
        }
        Column(modifier = Modifier
            .weight(1f, false)) {
            Button(
                onClick = { navController.navigate(Onboarding.route)
                    val deletePref = PreferencesManager(context = context)
                    deletePref.deleteData(name)
                    deletePref.deleteData(surname)
                    deletePref.deleteData(email)},
                border = BorderStroke(1.dp, Color(0xFFEE9972)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Log out")
            }
        }
    }
}


