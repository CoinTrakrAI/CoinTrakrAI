package com.cavemind.karlscrypto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cavemind.karlscrypto.ui.splash.SplashScreen
import com.cavemind.karlscrypto.ui.screens.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = androidx.navigation.compose.rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        Composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        Composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // Add more routes as you build out each screen…
    }
}

