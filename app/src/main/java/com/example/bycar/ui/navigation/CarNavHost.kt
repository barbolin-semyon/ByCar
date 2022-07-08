package com.example.bycar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun CarNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {}
        main(navController = navController)
    }
}

private fun NavGraphBuilder.main(navController: NavHostController) {
    navigation(startDestination = MainScreens.Home.route, route = Screens.Main.route) {
        home(navController = navController)
        composable(route = MainScreens.ScannerQR.route) {}
        composable(route = MainScreens.Chat.route) {}
    }
}

private fun NavGraphBuilder.home(navController: NavHostController) {
    navigation(startDestination = HomeScreens.Cars.route, route = MainScreens.Home.route) {
        composable(HomeScreens.Cars.route) {}
        composable(HomeScreens.Dealers.route) {}
        composable(HomeScreens.DetailCar.route) {}
        composable(HomeScreens.TestDriver.route) {}
    }
}