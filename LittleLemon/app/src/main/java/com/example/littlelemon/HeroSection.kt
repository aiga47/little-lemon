package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.karlaFont
import com.example.littlelemon.ui.theme.markaziFont
import com.example.littlelemon.ui.theme.primary1

@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = primary1)
            .padding(12.dp)
    ) {
        Text(
            text = "Little Lemon",
            color = Color(0xFFF4CE14),
            fontWeight = FontWeight.Bold,
            fontSize = 64.sp,
            fontFamily = markaziFont,
        )
        Row {
            Column(
                modifier = Modifier
                    .padding(end = 12.dp)
            ) {
                Text(
                    text = "Chicago",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontFamily = markaziFont
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                    color = Color.White,
                    fontFamily = karlaFont,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth(.65f)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Little Lemon hero",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
            )
        }
    }
}
