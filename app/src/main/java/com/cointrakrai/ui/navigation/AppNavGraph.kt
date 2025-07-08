
package com.cointrakrai.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cointrakrai.ui.SettingsScreen
import com.cointrakrai.ui.LegalDisclaimerScreen
import com.cointrakrai.plugins.PluginManager

@Composable
fun AppNavGraph(pluginManager: PluginManager) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "disclaimer") {
        composable("disclaimer") { LegalDisclaimerScreen { navController.navigate("settings") } }
        composable("settings") { SettingsScreen(pluginManager) }
    }
}
