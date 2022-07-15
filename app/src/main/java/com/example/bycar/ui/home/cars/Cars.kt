package com.example.bycar.ui.home

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bycar.R
import com.example.bycar.ui.theme.Gray700

@Preview
@Composable
fun Cars() {
    val carNameSearch = remember { mutableStateOf("") }
    SearchCar(carNameSearch = carNameSearch)
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
        label = {Text("Поиск машины")},
        colors = TextFieldDefaults.textFieldColors(
            disabledLabelColor = Gray700,
            disabledPlaceholderColor = Gray700,
            disabledTrailingIconColor = Gray700,
            disabledLeadingIconColor = Gray700,
            leadingIconColor = Color.Gray,
            trailingIconColor = Color.Gray
        ),
    )
}