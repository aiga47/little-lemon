package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.karlaFont
import com.example.littlelemon.ui.theme.primary1

@Composable
fun ItemFilter() {

    val databaseMenuItems by DatabaseManager().getDB(LocalContext.current).getAll()
        .observeAsState(emptyList())
    var searchPhrase by rememberSaveable { mutableStateOf("") }
    val orderMenuItems by remember { mutableStateOf(false) }
    var categoriesSelected by rememberSaveable { mutableStateOf(setOf("")) }
    val menuItems =
        if (orderMenuItems) {
            databaseMenuItems.sortedBy { it.title }
        } else {
            databaseMenuItems
        }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = primary1)
            .padding(12.dp)
    ) {
        TextField(
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            value = searchPhrase,
            onValueChange = { searchPhrase = it },
            label = {
                Text(
                    text = "Enter search phrase",
                    fontFamily = karlaFont
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        )
    }
    var filteredMenuItems = if (searchPhrase.isNotEmpty()) {
        menuItems.filter { item ->
            item.title.contains(
                searchPhrase,
                ignoreCase = true
            )
        }
    } else {
        menuItems
    }
    filteredMenuItems = if (categoriesSelected.isNotEmpty()) {
        categoriesSelected.forEach { selectedCategory ->
            filteredMenuItems = filteredMenuItems.filter { items ->
                items.category.contains(
                    selectedCategory,
                    ignoreCase = true
                )
            }
        }
        filteredMenuItems

    } else {
        filteredMenuItems
    }

    MenuList(items = filteredMenuItems) { categoryClicked ->
        val newSet = categoriesSelected.toMutableSet()
        if (newSet.contains(categoryClicked)) {
            newSet.remove(categoryClicked)
        } else {
            newSet.add(categoryClicked)
        }
        categoriesSelected = newSet
    }
}