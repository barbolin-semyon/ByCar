package com.example.bycar.ui.home.services

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.boguszpawlowski.composecalendar.CalendarState
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.DayOfWeek
import java.time.Month
import java.time.format.TextStyle
import java.util.*

@Composable
fun Calendar(calendarState: CalendarState<DynamicSelectionState>) {


    SelectableCalendar(
        monthHeader = { MonthHeader(monthState = calendarState.monthState)},

        showAdjacentMonths = false,
        modifier = Modifier.padding(8.dp),
        calendarState = calendarState,
        weekHeader = {WeekHeader(it)}
    )

}

@Composable
private fun MonthHeader(monthState: MonthState) {

    val currentMonth = monthState.currentMonth

    val monthDisplay = "${currentMonth.month 
        .getDisplayName(TextStyle.FULL_STANDALONE, Locale("ru"))
        .uppercase()} ${currentMonth.year}"


    Text(
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        text = monthDisplay,
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Composable
private fun WeekHeader(weeks: List<DayOfWeek>) {
    Row() {
        weeks.forEach { dayOfWeek ->
            Text(
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("ru")),
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
                color = Color.White
            )
        }
    }
}