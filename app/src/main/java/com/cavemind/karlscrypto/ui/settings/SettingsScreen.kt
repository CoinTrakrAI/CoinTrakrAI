package com.cavemind.karlscrypto.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var isAIMode by remember { mutableStateOf(true) }
    var overrideLevel by remember { mutableStateOf(70f) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("⚙️ AI Control Settings", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text("AI Mode:")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = isAIMode, onCheckedChange = { isAIMode = it })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Override Threshold: ${overrideLevel.toInt()}%", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = overrideLevel,
            onValueChange = { overrideLevel = it },
            valueRange = 0f..100f
        )
    }
}
