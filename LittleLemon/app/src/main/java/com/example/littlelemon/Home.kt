package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.karlaFont
import com.example.littlelemon.ui.theme.markaziFont
import com.example.littlelemon.ui.theme.primary1

@Composable
fun Home(navController: NavHostController) {
    val databaseMenuItems by DatabaseManager().getDB(LocalContext.current).getAll()
        .observeAsState(emptyList())

    Column {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(185.dp)
                    .height(40.dp)
                    .align(Alignment.Center)
            )
            IconButton(
                onClick = { navController.navigate(Profile.route) },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    Icons.Outlined.AccountCircle,
                    contentDescription = "Profile Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(100.dp)
                )
            }
        }
        Column()
        {
            HeroSection()
            ItemFilter()
        }
    }
}







