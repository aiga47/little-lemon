package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Column (horizontalAlignment = Alignment.End){
        IconButton(onClick = { navController.navigate(Profile.route) }) {
            Icon(
                Icons.Outlined.AccountCircle,
                contentDescription = "Profile Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 10.dp)
           )
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(30.dp)
                .width(185.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
