package com.cavemind.karlscrypto.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.model.PortfolioItem
import com.cavemind.karlscrypto.viewmodel.PortfolioViewModel

@Composable
fun PortfolioScreen(viewModel: PortfolioViewModel) {
    val portfolio by viewModel.portfolio.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Your Portfolio", style = MaterialTheme.typography.titleLarge)
        Text("Total Value: \$${"%.2f".format(viewModel.totalValue)}")
        Text("Total P/L: \$${"%.2f".format(viewModel.totalPL)}")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(portfolio.size) { index ->
                val item = portfolio[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${item.name} (${item.symbol})", style = MaterialTheme.typography.titleMedium)
                        Text("Qty: ${item.quantity}")
                        Text("Current Price: \$${"%.2f".format(item.currentPrice)}")
                        Text("Avg Buy: \$${"%.2f".format(item.averageBuyPrice)}")
                        Text("Value: \$${"%.2f".format(item.totalValue)}")
                        Text("P/L: \$${"%.2f".format(item.profitLoss)} (${item.percentChange}%)")
                    }
                }
            }
        }
    }
}