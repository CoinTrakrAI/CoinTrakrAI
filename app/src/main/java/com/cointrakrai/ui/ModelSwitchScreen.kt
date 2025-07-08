
package com.cointrakrai.ui

import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun ModelSwitchScreen() {
    var selectedModel by remember { mutableStateOf("Balanced") }

    Column {
        Text("Select Trading Model")
        DropdownMenu(
            expanded = true,
            onDismissRequest = {},
        ) {
            listOf("Conservative", "Balanced", "Aggressive").forEach { model ->
                DropdownMenuItem(onClick = { selectedModel = model }) {
                    Text(model)
                }
            }
        }
        Text("Selected Model: $selectedModel")
    }
}
