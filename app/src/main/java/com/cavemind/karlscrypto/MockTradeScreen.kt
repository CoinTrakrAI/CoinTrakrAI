package com.cavemind.karlscrypto.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.model.MarketAsset
import com.cavemind.karlscrypto.model.MockTrade
import com.cavemind.karlscrypto.viewmodel.MockTradeViewModel
import java.time.format.DateTimeFormatter

@Composable
fun MockTradeScreen(
    Asset: MarketAsset,
    viewModel: MockTradeViewModel
) {
    var investment by remember { mutableStateOf("1000") }

    val results by viewModel.simulationResults.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Mock Trade Simulator", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            Value = investment,
            onValueChange = { investment = it },
            label = { Text("Amount to Invest (USD)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val amount = investment.toDoubleOrNull() ?: return@Button
            viewModel.simulateTrade(MockTrade(asset, amount))
        }) {
            Text("Simulate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        If (results.isNotEmpty()) {
            Text("Projected Results:", style = MaterialTheme.typography.titleMedium)
            Results.forEach { result ->
                Text("${result.date.format(DateTimeFormatter.ISO_DATE)}: $${"%.2f".format(result.projectedValue)}")
            }
        }
    }
}

