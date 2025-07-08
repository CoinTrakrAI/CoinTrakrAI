package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cavemind.karlscrypto.viewmodel.TradingMapViewModel

@Composable
fun ARLiveTradingMapScreen(
    viewModel: TradingMapViewModel = viewModel(),
    onBack: () -> Unit
) {
    val state by viewModel.mapState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("AR Live Trading Map") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            Modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(" Current AR Map Status:", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    Text = state.statusMessage,
                    Color = if (state.isTracking) Color.Green else Color.Red,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.toggleTracking() }) {
                    Text(if (state.isTracking) "Stop Tracking" else "Start Tracking")
                }
            }
        }
    }
}

