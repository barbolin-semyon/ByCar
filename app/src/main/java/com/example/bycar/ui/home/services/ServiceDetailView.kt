package com.example.bycar.ui.home.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
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

@Composable
fun ServiceView(navController: NavController, myService: MyService) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Gray700),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = myService.icon),
            contentDescription = myService.name,
            modifier = Modifier.size(300.dp),
            tint = Color.White
        )

        Text(
            textAlign = TextAlign.Center,
            text = myService.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Text(
            textAlign = TextAlign.Center,
            text = myService.description,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )


    }
}