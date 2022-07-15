package com.example.bycar.ui.home.cars

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bycar.R
import com.example.bycar.data.Car
import com.example.bycar.data.cars
import com.example.bycar.ui.theme.Gray200
import com.example.bycar.ui.theme.Gray700
import com.example.bycar.ui.theme.Orange200
import java.util.*

@Composable
fun ModelsCars(navController: NavController, carNameSearch: String) {

    Column {
        Text(
            text = "ALL MODELS",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, top = 32.dp)
        )
        ListCars(carNameSearch = carNameSearch) {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ListCars(carNameSearch: String, onClick: (car: Car) -> Unit) {
    LazyRow(Modifier.padding(start = 8.dp)) {

        var isEven = true
        items(cars.filter { it.name.lowercase().contains(carNameSearch.lowercase()) }) { car ->
            isEven = isEven.not()
            Button(
                modifier = Modifier
                    .size(250.dp)
                    .padding(horizontal = 8.dp),
                onClick = { onClick(car) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isEven) Gray200 else Gray700
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = car.name, fontSize = (24.sp))
                    Text(text = car.type, color = if (isEven.not()) Color.White else Gray700)

                    Image(
                        painter = painterResource(id = car.imageId),
                        contentDescription = "imageCar",
                        modifier = Modifier.size(500.dp),
                    )
                }
            }
        }
    }
}
