package com.example.littlelemon

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
    val context = LocalContext.current
    val sharedPreferencesManager = PreferencesManager(context)
    val navController = rememberNavController()

    val hasClientData = sharedPreferencesManager.contains(email)
    var startDestination = Onboarding.route
    if (hasClientData) {
//        Log.e("lemon", "a")
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
//        Log.e("lemon", "c")
        composable(Onboarding.route) {
//            Log.e("lemon", "d")
            Onboarding(navController)
        }
        composable(Home.route) {
//            Log.e("lemon", "e")
            Home(navController)
        }
        composable(Profile.route) {
//            Log.e("lemon", "f")
            Profile(navController)
        }
    }
}