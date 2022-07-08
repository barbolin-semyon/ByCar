package com.example.bycar.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bycar.R

@Composable
fun CarBottomNavigation(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination

    val screens = listOf(MainScreens.Home, MainScreens.ScannerQR, MainScreens.Chat)


    if (currentDestination != null) {
        if (currentDestination.route != Screens.Splash.route) {
            BottomNavigation(backgroundColor = Color.White) {
                screens.forEach { currentScreen ->
                    BottomNavigationItem(
                        selected = currentDestination.hierarchy.any { it.route == currentScreen.route },
                        onClick = { navController.navigate(currentScreen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        } },
                        icon = { Icon(
                            painter = painterResource(id = currentScreen.idImage),
                            contentDescription = currentScreen.description
                        ) },
                        selectedContentColor = Color.Cyan,
                        unselectedContentColor = Color.Gray,
                    )
                }
            }
        }
    }

}