package com.project.symmaintenance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.sign_in.InitialScreen
import com.project.change_config.SettingScreen
import com.project.view_tasks.HomeScreen
import com.project.view_task.TaskScreen
import com.project.framework.routes.Routes

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController, Routes.Home) {
        homeScreen(navController)
        taskScreen()
        initScreen()
        settingsScreen()
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
