package com.example.bycar.data

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.MonthDay
import java.util.*

data class Message(
    val date: LocalDate,
    val time: LocalTime,
    val isUser: Boolean,
    val text: String
)

val chat = mutableListOf(
    Message(LocalDate.of(2022, 7, 3), time = LocalTime.of(4, 2), true, "Hello"),
    Message(LocalDate.of(2022, 8, 3), time = LocalTime.of(4, 2), false, "How are you?"),
    Message(LocalDate.of(2022, 8, 3), time = LocalTime.of(8, 2), true, "dsfsdfsd"),
    Message(LocalDate.of(2023, 9, 3), time = LocalTime.of(4, 2), false, "dfgrethdfh"),
    Message(LocalDate.of(2023, 10, 3), time = LocalTime.of(4, 2), true, "dfgfdsfsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffrethdfh"),
    Message(LocalDate.of(2023, 10, 3), time = LocalTime.of(4, 5), true, "dfgrethdfh"),

)