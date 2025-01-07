package com.project.symmaintenance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    homeScreen()
                }
            }
        }
    }

    private fun NavGraphBuilder.homeScreen(navController: NavController) {
        composable(Routes.Home) {
            HomeScreen(
                onTaskRequest = { taskId ->
                    navController.navigate("${Routes.Task}/$taskId")
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
            InitScreen()
        }
    }
    private fun NavGraphBuilder.settingsScreen() {
        composable(Routes.Settings) {
            SettingsScreen()
        }
    }
}
