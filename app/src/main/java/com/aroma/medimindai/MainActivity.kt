package com.aroma.medimindai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aroma.medimindai.ui.home.HomeScreen
import com.aroma.medimindai.ui.theme.MediMindAITheme
import com.aroma.medimindai.ui.chat.ChatScreen
import com.aroma.medimindai.ui.history.HistoryScreen
import com.aroma.medimindai.ui.camera.CameraScreen

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
                onViewHistoryClick = { navController.navigate("history") },
                onCameraClick = { navController.navigate("camera") }
            )
        }

        composable("chat") { ChatScreen() }

        composable(
            "chat?imagePath={imagePath}",
            arguments = listOf(
                navArgument("imagePath") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val imagePath = backStackEntry.arguments?.getString("imagePath")
            ChatScreen(imagePathFromCamera = imagePath)
        }

        composable("history") { HistoryScreen() }

        composable("camera") {
            CameraScreen(
                onImageCaptured = { path ->
                    navController.navigate("chat?imagePath=$path") {
                        popUpTo("camera") { inclusive = true }
                    }
                }
            )
        }
    }
}