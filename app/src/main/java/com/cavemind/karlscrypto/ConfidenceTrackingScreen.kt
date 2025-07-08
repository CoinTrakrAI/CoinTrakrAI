
package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ConfidenceTrackingScreen() {
    var confidenceLevel by remember { mutableStateOf(86) } // Simulated AI confidence index

    Surface(
        Modifier = Modifier.fillMaxSize(),
        Color = Color.Black
    ) {
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("AI Confidence Index", style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            Text("$confidenceLevel%", style = MaterialTheme.typography.displayMedium, color = Color(0xFF00FF00))
            Spacer(modifier = Modifier.height(24.dp))

            LinearProgressIndicator(
                Progress = confidenceLevel / 100f,
                Modifier = Modifier.fillMaxWidth(0.8f),
                Color = Color(0xFF00FF00)
            )
        }
    }
}

