package com.example.bycar.ui.splash

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bycar.ui.navigation.Screens

@Composable
fun SplashCar(navController: NavController) {
    Button(onClick = {
        navController.navigate(Screens.Main.route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }) {

    }
}