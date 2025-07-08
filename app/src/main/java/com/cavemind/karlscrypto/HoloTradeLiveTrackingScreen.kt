package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cavemind.karlscrypto.viewmodel.TradeViewModel
import com.cavemind.karlscrypto.model.MarketAsset

@Composable
fun HoloTradeLiveTrackingScreen(
    viewModel: TradeViewModel = viewModel(),
    onBack: () -> Unit
) {
    val liveTrades by viewModel.liveTrades.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("HoloTrade Live Tracking") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(liveTrades) { trade ->
                TradeItem(asset = trade)
            }
        }
    }
}

@Composable
fun TradeItem(asset: MarketAsset) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = asset.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Price: \$${asset.price}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Change: ${asset.changePercent}%", style = MaterialTheme.typography.bodySmall)
        }
    }
}