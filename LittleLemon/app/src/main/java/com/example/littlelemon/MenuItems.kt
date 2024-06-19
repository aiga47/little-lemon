package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.littlelemon.data.Categories
import com.example.littlelemon.ui.theme.karlaFont

@Composable
fun MenuList(items: List<MenuItemRoom>, categoryCallback: (categoryClicked: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = "ORDER FOR DELIVERY!",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow {
            items(Categories) { category ->
                MenuCategory(category, categoryCallback)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp
        )
        LazyColumn(modifier = Modifier
            .height(250.dp)) {
            items.forEach {
                item { MenuItems(it) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuCategory(category: String, categoryCallback: (input: String) -> Unit) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.secondary),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(end = 5.dp),
        onClick = {
            selected = !selected
            categoryCallback.invoke(category)
        },
        label = {
            Text(
                text = category,
                fontSize = 16.sp,
                fontFamily = karlaFont,
                fontWeight = FontWeight.Bold
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun MenuItems(item: MenuItemRoom) {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 12.dp, bottom = 12.dp)
        ) {
            Column {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.description,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = item.price.toString(),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
            AsyncImage(
                model = item.image,
                contentDescription = "Food photo",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}

