package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavemind.karlscrypto.ui.components.SystemRow
import com.cavemind.karlscrypto.viewmodel.SentinelViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SentinelDefenseHQScreen(
    viewModel: SentinelViewModel = viewModel(),
    onBack: () -> Unit
) {
    val systemStatus by viewModel.systemStatus.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Sentinel Defense HQ") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.Shield, contentDescription = "Back")
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
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                Text = "Real-Time Defense Systems",
                fontSize = 22.sp,
                color = Color.Red
            )

            systemStatus.forEach { status ->
                SystemRow(systemName = status.name, isOnline = status.isOnline, description = status.description)
            }
        }
    }
}

