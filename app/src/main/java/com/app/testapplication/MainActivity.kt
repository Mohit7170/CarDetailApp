package com.app.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.testapplication.screens.AuthScreen
import com.app.testapplication.screens.ItemDetailScreen
import com.app.testapplication.screens.MainScreen
import com.app.testapplication.ui.theme.BgColor
import com.app.testapplication.ui.theme.TestApplicationTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestApplicationTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BgColor)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = MainRoutes.AuthScreen,
                        modifier = Modifier.padding(it)
                    ) {
                        composable<MainRoutes.MainScreen> {
                            MainScreen(navController)
                        }

                        composable<MainRoutes.ItemScreen> {
                            ItemDetailScreen(navController)
                        }

                        composable<MainRoutes.AuthScreen> {
                            AuthScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

@Serializable
sealed class MainRoutes {
    @Serializable
    data object MainScreen : MainRoutes()

    @Serializable
    data object ItemScreen : MainRoutes()

    @Serializable
    data object AuthScreen : MainRoutes()
}