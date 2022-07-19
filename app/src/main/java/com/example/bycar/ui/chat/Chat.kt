package com.example.bycar.ui.chat

import android.icu.util.LocaleData
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bycar.data.chat
import com.example.bycar.ui.theme.BlackTransparent
import java.time.format.DateTimeFormatter
import com.example.bycar.R
import com.example.bycar.data.Message
import com.example.bycar.ui.theme.Gray700
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Chat() {
    Column {
        Messages()
        WriteMessage()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Messages() {
    val groupes = chat.groupBy { it.date }
    LazyColumn(modifier = Modifier.fillMaxHeight(0.9f)) {
        groupes.forEach { (key, values) ->
            stickyHeader {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = key.format(
                            DateTimeFormatter.ofPattern(
                                "dd MMMM, yyyy",
                                Locale("ru")
                            )
                        ),
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(BlackTransparent)
                            .padding(horizontal = 8.dp)
                    )

                }
            }
            items(values) { message ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = if (message.isUser) Alignment.End else Alignment.Start
                ) {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .widthIn(150.dp, 300.dp),
                        elevation = 4.dp,
                        shape = RoundedCornerShape(32.dp)
                    ) {

                        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                            Text(text = message.text)

                            Row(horizontalArrangement = Arrangement.End) {
                                Text(
                                    text = message.time.format(DateTimeFormatter.ofPattern("hh:mm")),
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                )
                            }
                        }

                    }


                }
            }
        }
    }
}

@Composable
private fun WriteMessage() {

    val text = remember { mutableStateOf("") }

    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        trailingIcon = {
            if (text.value.isNotEmpty()) {
                TextButton(
                    onClick = {
                        chat.add(Message(LocalDate.now(), LocalTime.now(), true, text.value))
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                        contentDescription = "write",
                        tint = Gray700
                    )
                }
            }
        },
        label = { Text("Write Message") }
    )
}