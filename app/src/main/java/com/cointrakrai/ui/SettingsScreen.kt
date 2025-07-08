
package com.cointrakrai.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import com.cointrakrai.plugins.PluginManager

@Composable
fun SettingsScreen(pluginManager: PluginManager) {
    var autoTrade by remember { mutableStateOf(false) }
    Column {
        Text("Settings")
        Switch(checked = autoTrade, onCheckedChange = {
            autoTrade = it
            pluginManager.binancePlugin.autoTradeEnabled = it
            pluginManager.coinbasePlugin.autoTradeEnabled = it
            pluginManager.krakenPlugin.autoTradeEnabled = it
        })
        Text("Auto Trading: $autoTrade")
    }
}
