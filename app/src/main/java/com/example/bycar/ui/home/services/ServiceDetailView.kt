package com.example.bycar.ui.home.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bycar.data.MyService
import com.example.bycar.ui.theme.Gray700
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.header.DefaultMonthHeader
import io.github.boguszpawlowski.composecalendar.rememberCalendarState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

@Composable
fun ServiceView(navController: NavController, myService: MyService) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Gray700),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Icon(
            painter = painterResource(id = myService.icon),
            contentDescription = myService.name,
            modifier = Modifier.size(150.dp),
            tint = Color.White
        )

        val calendarState = rememberSelectableCalendarState(
            initialSelectionMode = SelectionMode.Single,
        )

        Calendar(calendarState = calendarState)

        Button(
            onClick = { /*TODO*/ },
            enabled = calendarState.selectionState.selection.isNotEmpty(),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                "Оставить заявку", fontSize = 24.sp
            )
        }


    }
}