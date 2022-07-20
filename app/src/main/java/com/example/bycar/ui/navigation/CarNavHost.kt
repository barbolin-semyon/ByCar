package com.example.bycar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bycar.data.Car
import com.example.bycar.data.MyService
import com.example.bycar.ui.chat.Chat
import com.example.bycar.ui.home.Cars
import com.example.bycar.ui.home.detailCar.DetailCarView
import com.example.bycar.ui.home.services.ServiceView
import com.example.bycar.ui.qr.QRScanner
import com.example.bycar.ui.splash.SplashCar
import com.example.bycar.ui.theme.Gray700
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CarNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) { SplashCar(navController) }
        main(navController = navController)
    }
}

private fun NavGraphBuilder.main(navController: NavController) {
    navigation(startDestination = MainScreens.Home.route, route = Screens.Main.route) {
        home(navController = navController)
        composable(route = MainScreens.ScannerQR.route) { QRScanner() }
        composable(route = MainScreens.Chat.route) { Chat() }
    }
}

private fun NavGraphBuilder.home(navController: NavController) {
    navigation(startDestination = HomeScreens.Cars.route, route = MainScreens.Home.route) {
        composable(HomeScreens.Cars.route) { Cars(navController = navController) }
        composable(HomeScreens.DetailCar.route) {
            val car = navController.previousBackStackEntry?.savedStateHandle?.get<Car>("car")

            car?.let { DetailCarView(it) }
        }
        composable(HomeScreens.Service.route) {
            val service =
                navController.previousBackStackEntry?.savedStateHandle?.get<MyService>("service")

            service?.let { service ->

                rememberSystemUiController().setStatusBarColor(Gray700)

                ServiceView(
                    navController = navController, myService = service
                )
            }
        }
    }
}