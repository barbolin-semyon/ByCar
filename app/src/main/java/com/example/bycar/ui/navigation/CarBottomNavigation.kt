package com.example.bycar.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bycar.R
import com.example.bycar.ui.theme.Gray200

@Composable
fun CarBottomNavigation(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination

    val screens = listOf(MainScreens.Home, MainScreens.ScannerQR, MainScreens.Chat)


    if (currentDestination != null) {
        if (currentDestination.route != Screens.Splash.route) {
            BottomNavigation(backgroundColor = Color.White) {
                screens.forEach { currentScreen ->

                    val isSelected =
                        currentDestination.hierarchy.any { it.route == currentScreen.route }

                    BottomNavigationItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(currentScreen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = currentScreen.idImage),
                                contentDescription = currentScreen.description
                            )
                        },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Gray,
                        label = { Text("●") },
                        alwaysShowLabel = isSelected
                    )

                    if (currentScreen.route != MainScreens.Chat.route) {
                        Divider(modifier = Modifier
                            .fillMaxHeight()
                            .padding(top = 16.dp, bottom = 16.dp)
                            .width(1.dp), color = Gray200)
                    }
                }
            }
        }
    }

}