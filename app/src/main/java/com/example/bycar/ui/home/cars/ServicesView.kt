package com.example.bycar.ui.home.cars

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bycar.data.listServices
import com.example.bycar.ui.theme.Gray200
import com.example.bycar.ui.theme.Gray700

@OptIn(ExperimentalFoundationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun ServicesCar(navHostController: NavHostController) {
    LazyColumn {
        stickyHeader {
            Text(
                text = "SERVICES",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp, top = 32.dp)
            )
        }

        items(listServices) { service ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                elevation = 4.dp,
                onClick = {
                    navigateToDetailService(
                        navHostController = navHostController,
                        service.routeForNavigate
                    )
                }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = service.icon),
                        contentDescription = service.name,
                        tint = Gray700,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(40.dp)
                    )

                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = service.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )

                        Text(text = service.description)
                    }
                }
            }
        }
    }
}

private fun navigateToDetailService(navHostController: NavHostController, route: String) {
    navHostController.navigate(route = route) {
        popUpTo(navHostController.graph.startDestinationId) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}