package com.example.bycar.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyService(
    val icon: Int = 3,
    val name: String = "",
    val description: String = "",
) : Parcelable


