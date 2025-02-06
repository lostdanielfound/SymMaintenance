package com.project.symmaintenance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.project.symmaintenance.ui.navigation.MainNavigation
import com.project.symmaintenance.ui.theme.SymMaintenanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SymMaintenanceTheme {
                //The process of establishing a connection to the server should be done here before

                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }

}
