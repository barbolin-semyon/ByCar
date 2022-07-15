package com.example.bycar.data

import androidx.annotation.DrawableRes
import com.example.bycar.R
import com.example.bycar.ui.navigation.HomeScreens

data class Service(
    @DrawableRes val icon: Int,
    val name: String,
    val description: String,
    val routeForNavigate: String
)

val listServices = listOf(
    Service(
        R.drawable.ic_baseline_shop_24,
        "BY CAR",
        "Book a car fpr buy",
        HomeScreens.ByCar.route
    ),

    Service(
        R.drawable.ic_test_drive,
        "TEST DRIVER",
        "Book for a Test Driver",
        HomeScreens.TestDriver.route
    )
)