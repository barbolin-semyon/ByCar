package com.example.bycar.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bycar.R
import com.example.bycar.ui.navigation.Screens
import com.example.bycar.ui.theme.Gray700
import com.example.bycar.ui.theme.Orange200
import java.util.*

@Composable
fun SplashCar(navController: NavController) {

    Column(
        Modifier
            .background(color = Gray700)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            buildAnnotatedString {

                withStyle(
                    style = SpanStyle(
                        color = Orange200,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 54.sp,
                    )
                ) { append("Carry\n") }

                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 100.sp,
                        letterSpacing = 5.sp
                    )
                ) { append("BEST\n") }

                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 70.sp,
                        letterSpacing = 0.05.sp
                    )
                ) { append("TO BUY") }

            },
            lineHeight = 5.em,
        )

        Image(
            painter = painterResource(id = R.drawable.car2),
            contentDescription = "car",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Button(
            onClick = {
                navController.navigate(Screens.Main.route) {
                    popUpTo(navController.currentDestination!!.id) {
                        inclusive = true
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange200
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text(text = "GET STARTED", fontSize = 18.sp, modifier = Modifier.padding(vertical = 8.dp))
        }

    }

}