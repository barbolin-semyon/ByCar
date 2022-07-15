package com.example.bycar.data

import androidx.annotation.DrawableRes
import com.example.bycar.R

data class Car(
    @DrawableRes val imageId: Int,
    val name: String,
    val type: String
)

val cars = listOf(
    Car(R.drawable.car3, "Coopes", "E-class Coopes"),
    Car(R.drawable.car, "Lada Sedan", "A-class LADA"),
    Car(R.drawable.car, "BMW", "A-class BMW"),
    Car(R.drawable.car3, "Tesla", "E-class TESLA"),
)
