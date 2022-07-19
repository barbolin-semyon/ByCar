package com.example.bycar.data

import java.util.*

data class Message(
    val date: Calendar,
    val isUser: Boolean,
    val text: String
)

val chat = listOf(
    Message(Calendar.getInstance().apply{set(2022, 8, 3, 1, 17)}, true, "Hello"),
    Message(Calendar.getInstance().apply{set(2022, 8, 3, 1, 25)}, true, "How are you?"),
    Message(Calendar.getInstance().apply{set(2022, 8, 3, 1, 34)}, true, "dsfsdfsd"),
    Message(Calendar.getInstance().apply{set(2022, 8, 3, 1, 50)}, true, "dfgrethdfh"),
    Message(Calendar.getInstance().apply{set(2022, 8, 5, 2, 34)}, true, "dsgdfcbvcb"),
    Message(Calendar.getInstance().apply{set(2022, 8, 5, 3, 34)}, true, "rdfgdfhhfgdhfghgfhgfhfgh"),
    Message(Calendar.getInstance().apply{set(2022, 8, 5, 4, 34)}, true, "dfgvnfghrthtrfggfhfghfgh"),
    Message(Calendar.getInstance().apply{set(2022, 8, 5, 5, 34)}, true, "reiogreihmterihmtrhtm!"),
    Message(Calendar.getInstance().apply{set(2022, 8, 5, 6, 34)}, true, "dfgmkfdgkmdflkg"),
    Message(Calendar.getInstance().apply{set(2022, 9, 3, 4, 34)}, true, "ssdfsgierjtmgodfh"),
    Message(Calendar.getInstance().apply{set(2022, 9, 3, 5, 34)}, true, "sdfgjndfgj"),
    Message(Calendar.getInstance().apply{set(2022, 9, 3, 10, 34)}, true, "Hdsfffffffffffffffffwergfgffdgfg"),
    Message(Calendar.getInstance().apply{set(2022, 9, 3, 11, 34)}, true, "sdfgdfhvgryhtrhgfhfdghhhhhhhhhhhhhhhhhhhhhhhfdgfdgfdg"),
    Message(Calendar.getInstance().apply{set(2022, 11, 3, 12, 34)}, true, "Hello"),
    Message(Calendar.getInstance().apply{set(2022, 11, 3, 13, 34)}, true, "Hello"),
    Message(Calendar.getInstance().apply{set(2022, 11, 3, 17, 34)}, true, "Hello"),
    Message(Calendar.getInstance().apply{set(2023, 3, 3, 17, 34)}, true, "Hello"),

)