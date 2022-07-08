package com.example.bycar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.bycar.ui.navigation.CarBottomNavigation
import com.example.bycar.ui.navigation.CarNavHost
import com.example.bycar.ui.theme.ByCarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ByCarTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { CarBottomNavigation(navController = navController) }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
                        CarNavHost(navController = navController)
                    }
                }
            }
        }
    }
}
