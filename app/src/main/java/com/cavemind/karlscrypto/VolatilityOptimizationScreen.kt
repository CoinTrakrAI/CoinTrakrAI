package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cavemind.karlscrypto.viewmodel.VolatilityViewModel

@Composable
fun VolatilityOptimizationScreen(
    viewModel: VolatilityViewModel = hiltViewModel()
) {
    val currentStrategy by viewModel.optimizationStrategy.collectAsState()
    val options = listOf("Mean Reversion", "Momentum", "AI Sentiment", "News Impact")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Volatility Optimization", style = MaterialTheme.typography.titleLarge)

        options.forEach { strategy ->
            Button(
                onClick = { viewModel.setStrategy(strategy) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (currentStrategy == strategy) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(strategy)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Selected Strategy: $currentStrategy", style = MaterialTheme.typography.bodyLarge)
    }
}