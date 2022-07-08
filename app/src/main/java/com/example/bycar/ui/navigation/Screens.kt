package com.example.bycar.ui.navigation

import androidx.annotation.DrawableRes
import com.example.bycar.R

sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object Main : Screens("main")
}

sealed class MainScreens(
    val route: String,
    val description: String,
    @DrawableRes val idImage: Int
) {
    object Home : MainScreens("home", "Домашняя", R.drawable.ic_home)
    object Chat : MainScreens("chat", "Поддержка", R.drawable.ic_chat)
    object ScannerQR :
        MainScreens("scannerQR", "Сканировать qr-code", R.drawable.ic_qr_code_scanner)
}

sealed class HomeScreens(val route: String) {
    object TestDriver : HomeScreens("testDriver")
    object Dealers : HomeScreens("dealers")
    object DetailCar : HomeScreens("detailCar")
    object Cars : HomeScreens("cars")
}
