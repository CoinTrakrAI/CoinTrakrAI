package com.cavemind.karlscrypto.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.viewmodel.TradeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradeScreen(assetName: String, viewModel: TradeViewModel) {
    val state = viewModel.uiState.collectAsState().value
    var customAmount by remember { mutableStateOf(TextFieldValue("")) }
    var isTradeDialogOpen by remember { mutableStateOf(false) }

    Column(
        Modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Trade: $assetName", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Display AI-driven trade suggestions
        AIRecommendationSection(state)

        // Real-time Asset Data (Price, Change24h)
        AssetInfoSection(state)

        Spacer(modifier = Modifier.height(16.dp))

        // Input field for custom investment amount
        TextField(
            Value = customAmount,
            onValueChange = { customAmount = it },
            label = { Text("Custom Amount") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Buy and Sell Buttons
        Button(onClick = { 
            If (customAmount.text.isNotEmpty()) {
                viewModel.executeTrade("buy", assetName, customAmount.text.toDouble())
                isTradeDialogOpen = true
            } else {
                showErrorToast("Please enter a valid amount.")
            }
        }) {
            Text("Buy")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { 
            If (customAmount.text.isNotEmpty()) {
                viewModel.executeTrade("sell", assetName, customAmount.text.toDouble())
                isTradeDialogOpen = true
            } else {
                showErrorToast("Please enter a valid amount.")
            }
        }) {
            Text("Sell")
        }

        // Confirmation dialog for trade
        If (isTradeDialogOpen) {
            TradeConfirmationDialog(
                onConfirm = {
                    // Confirm trade and close dialog
                    viewModel.confirmTrade()
                    isTradeDialogOpen = false
                },
                onDismiss = { isTradeDialogOpen = false }
            )
        }

        // Display trade result message
        If (state.resultMessage.isNotEmpty()) {
            Text(state.resultMessage, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun AIRecommendationSection(state: TradeState) {
    If (state.aiRecommendation.isNotEmpty()) {
        Column(
            Modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text("AI Recommendation", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(state.aiRecommendation, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AssetInfoSection(state: TradeState) {
    Column(
        Modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text("Price: ${state.assetPrice}", style = MaterialTheme.typography.bodyLarge)
        Text("24h Change: ${state.change24h}%", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun TradeConfirmationDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Confirm Trade") },
        text = { Text("Are you sure you want to execute this trade?") },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

private fun showErrorToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()
}

