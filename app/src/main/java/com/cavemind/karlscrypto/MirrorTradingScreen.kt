package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.model.MirrorTraderProfile
import com.cavemind.karlscrypto.viewmodel.MirrorTradingViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MirrorTradingScreen(
    onSelect: (MirrorTraderProfile) -> Unit,
    viewModel: MirrorTradingViewModel = viewModel()
) {
    val traders by viewModel.topTraders.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Mirror Trading") }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Items(traders) { trader ->
                Card(
                    Modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onSelect(trader) }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(text = trader.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = "ROI: ${trader.roi}%", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Followers: ${trader.followers}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

