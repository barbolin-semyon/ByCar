package com.example.bycar.ui.home.detailCar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bycar.R
import com.example.bycar.data.Car
import com.example.bycar.ui.theme.Gray200
import com.example.bycar.ui.theme.Gray700
import com.example.bycar.ui.theme.Orange200

@Composable
fun DetailCarView(car: Car) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Gray200)
    ) {

        Text(
            text = car.name,
            color = Gray700,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Image(
            painter = painterResource(id = car.imageId),
            contentDescription = car.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )


        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                ItemCardInformation(title = car.price.toString(), description = "price")
                ItemCardInformation(title = car.speed.toString(), description = "speed")
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                ItemCardInformation(title = car.running.toString(), description = "running")
                ItemCardInformation(title = car.type.toString(), description = "model")
            }
        }
    }
}


@Composable
private fun ItemCardInformation(title: String, description: String) {
    Card(
        Modifier
            .width(200.dp)
            .height(150.dp)
            .padding(16.dp),
        backgroundColor = Gray700,
        elevation = 8.dp
    ) {
        Column {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )

            Text(
                text = description, fontSize = 18.sp, color = Orange200,
                modifier = Modifier.padding(top = 8.dp, start = 16.dp)
            )
        }
    }
}