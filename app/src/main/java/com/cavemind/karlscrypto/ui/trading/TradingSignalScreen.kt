package com.cavemind.karlscrypto.ui.trading

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TradingSignalScreen() {
    val symbol = remember { mutableStateOf("BTC") }
    val confidence = remember { mutableStateOf(85) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("📈 AI Trading Signal", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text("Symbol: ${symbol.value}")
        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(progress = confidence.value / 100f)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Confidence Level: ${confidence.value}%", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { /* analyze trade */ }) {
            Text("Analyze Now")
        }
    }
}
