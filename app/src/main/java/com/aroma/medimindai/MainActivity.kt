package com.aroma.medimindai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aroma.medimindai.ui.home.HomeScreen
import com.aroma.medimindai.ui.theme.MediMindAITheme
import com.aroma.medimindai.ui.chat.ChatScreen
import com.aroma.medimindai.ui.history.HistoryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediMindAITheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onCheckSymptomsClick = { navController.navigate("chat") },
                onViewHistoryClick = { navController.navigate("history") }
            )
        }
        composable("chat") {  ChatScreen()
        }
        composable("history") { }
        composable("history") {
            HistoryScreen()
        }
    }
}