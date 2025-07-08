// ===== MainActivity.kt (Navigation Compose Enabled) =====
package com.cointrackr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cointrackr.ui.theme.CoinTrackrTheme

class MainActivity : ComponentActivity() {
    Override fun onCreate(savedInstanceState: Bundle?) {
        Super.onCreate(savedInstanceState)
        setContent {
            CoinTrackrTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) {
                    NavigationGraph(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            Selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )
        NavigationBarItem(
            Selected = false,
            onClick = { navController.navigate("portfolio") },
            label = { Text("Portfolio") },
            icon = { Icon(Icons.Default.PieChart, contentDescription = "Portfolio") }
        )
        NavigationBarItem(
            Selected = false,
            onClick = { navController.navigate("settings") },
            label = { Text("Settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") }
        )
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        Composable("home") { HomeScreen() }
        Composable("portfolio") { PortfolioScreen() }
        Composable("settings") { SettingsScreen() }
    }
}

