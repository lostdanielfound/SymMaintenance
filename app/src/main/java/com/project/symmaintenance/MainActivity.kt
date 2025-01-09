package com.project.symmaintenance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.presentation.features.homeScreen.HomeScreen
import com.project.presentation.features.initialScreen.InitialScreen
import com.project.presentation.features.settingsScreen.SettingScreen
import com.project.presentation.features.taskScreen.TaskScreen
import com.project.symmaintenance.ui.routes.Routes
import com.project.symmaintenance.ui.theme.SymMaintenanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SymMaintenanceTheme {
                //The process of establishing a connection to the server should be done here before

                val navController = rememberNavController()
                NavHost(navController, Routes.Home) {
                    homeScreen(navController)
                    taskScreen()
                    initScreen()
                    settingsScreen()
                }
            }
        }
    }

    private fun NavGraphBuilder.homeScreen(navController: NavController) {
        composable(Routes.Home) {
            HomeScreen(
                onTaskRequest = { taskId ->
                    navController.navigate("${Routes.Task}/$taskId")
                },
                onClickRequestTesting = { route ->
                    navController.navigate(route)
                }
            )
        }
    }
    private fun NavGraphBuilder.taskScreen() {
        composable(Routes.Task) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")
            TaskScreen(taskId = taskId)
        }
    }
    private fun NavGraphBuilder.initScreen() {
        composable(Routes.Init) {
            InitialScreen()
        }
    }
    private fun NavGraphBuilder.settingsScreen() {
        composable(Routes.Settings) {
            SettingScreen()
        }
    }
}
