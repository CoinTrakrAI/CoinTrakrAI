package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cavemind.karlscrypto.viewmodel.AutoTuneViewModel

@Composable
fun AutoTuneControlPanelScreen(
    viewModel: AutoTuneViewModel = viewModel(),
    onBack: () -> Unit
) {
    val settings by viewModel.tuneSettings.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Auto-Tune Control Panel") },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Adjust AI Tuning Parameters", fontSize = 20.sp)

            SliderSetting(
                Label = "Risk Level",
                Value = settings.riskLevel,
                onValueChange = { viewModel.updateRisk(it) }
            )

            SliderSetting(
                Label = "Trade Frequency",
                Value = settings.tradeFrequency,
                onValueChange = { viewModel.updateFrequency(it) }
            )

            SliderSetting(
                Label = "AI Sensitivity",
                Value = settings.sensitivity,
                onValueChange = { viewModel.updateSensitivity(it) }
            )
        }
    }
}

@Composable
fun SliderSetting(
    Label: String,
    Value: Float,
    onValueChange: (Float) -> Unit
) {
    Column {
        Text(text = "$label: ${String.format("%.1f", value)}", fontSize = 16.sp)
        Slider(
            Value = value,
            onValueChange = onValueChange,
            valueRange = 0f..10f
        )
    }
}

