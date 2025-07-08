package com.cavemind.karlscrypto.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cavemind.karlscrypto.viewmodel.MockTradeViewModel

@Composable
fun MockTradeDashboard(mockTradeViewModel: MockTradeViewModel = viewModel()) {
    var symbol by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var days by remember { mutableIntStateOf(30) }
    val result by mockTradeViewModel.projectionResult.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Simulate a Mock Trade", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            Value = symbol,
            onValueChange = { symbol = it },
            label = { Text("Asset Symbol (e.g., BTC, AAPL)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            Value = amount,
            onValueChange = { amount = it },
            label = { Text("Investment Amount (USD)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            listOf(30, 90, 180, 365).forEach {
                Button(onClick = { days = it }) {
                    Text("$it days")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val investment = amount.toDoubleOrNull()
                if (!symbol.isNullOrBlank() && investment != null) {
                    mockTradeViewModel.simulateTrade(symbol.uppercase(), investment, days)
                }
            },
            Modifier = Modifier.fillMaxWidth()
        ) {
            Text("Run Simulation")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Result?.let {
            Text("Projected Value in $days days:", style = MaterialTheme.typography.titleMedium)
            Text("$${String.format("%.2f", it)}", style = MaterialTheme.typography.headlineSmall)
        }
    }
}

