package com.example.bycar.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.bycar.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(
    @DrawableRes val imageId: Int,
    val name: String,
    val type: String,
    val speed: Int,
    val price: Int,
    val running : Int,
) : Parcelable

val cars = listOf(
    Car(R.drawable.car3, "Coopes", "E-class Coopes", 2313431, 1000000, 0),
    Car(R.drawable.car, "Lada Sedan", "A-class LADA", 60000, 1000000, 890),
    Car(R.drawable.car, "BMW", "A-class BMW", 10000, 6000000, 0),
    Car(R.drawable.car3, "Tesla", "E-class TESLA", 2313431, 656548654, 0),
)
