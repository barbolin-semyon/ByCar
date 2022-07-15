package com.example.bycar.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.Glide
import com.example.bycar.R
import com.example.bycar.ui.home.cars.ModelsCars
import com.example.bycar.ui.home.cars.ServicesCar
import com.example.bycar.ui.theme.Gray700
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun Cars(navController: NavHostController) {
    val carNameSearch = remember { mutableStateOf("") }
    Column {
        Headline()
        SearchCar(carNameSearch = carNameSearch)
        ModelsCars(navController = navController, carNameSearch = carNameSearch.value)
        ServicesCar(navHostController = navController)
    }
}

@Composable
private fun Headline() {
    Row(
        modifier = Modifier.padding(top = 32.dp, start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            imageModel = "data:image/jpeg;base64,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",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "hi, al fariz".uppercase(),
            Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SearchCar(carNameSearch: MutableState<String>) {
    OutlinedTextField(
        value = carNameSearch.value,
        onValueChange = { carNameSearch.value = it },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "searchCar",
                modifier = Modifier.size(20.dp),
            )
        },

        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_sort),
                contentDescription = "sort",
                modifier = Modifier.size(20.dp),
            )
        },
        label = { Text("Поиск машины") },
        colors = TextFieldDefaults.textFieldColors(
            disabledLabelColor = Gray700,
            disabledPlaceholderColor = Gray700,
            disabledTrailingIconColor = Gray700,
            disabledLeadingIconColor = Gray700,
            leadingIconColor = Color.Gray,
            trailingIconColor = Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}