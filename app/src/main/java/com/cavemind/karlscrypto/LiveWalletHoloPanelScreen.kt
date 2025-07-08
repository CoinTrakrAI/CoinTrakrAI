package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavemind.karlscrypto.model.WalletAsset
import com.cavemind.karlscrypto.viewmodel.WalletViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LiveWalletHoloPanelScreen(
    viewModel: WalletViewModel = viewModel(),
    onBack: () -> Unit
) {
    val walletAssets by viewModel.walletAssets.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Live Wallet – Holo Panel") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                Text = "Your Real-Time Wallet Overview",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Items(walletAssets) { asset ->
                    WalletAssetCard(asset)
                }
            }
        }
    }
}

@Composable
fun WalletAssetCard(asset: WalletAsset) {
    Card(
        Modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        Elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = asset.name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Symbol: ${asset.symbol}")
            Text(text = "Balance: ${asset.balance}")
            Text(text = "Value: \$${"%.2f".format(asset.usdValue)}")
        }
    }
}

