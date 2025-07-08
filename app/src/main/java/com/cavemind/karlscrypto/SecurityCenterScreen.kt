package com.cavemind.karlscrypto.ui.security

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cavemind.karlscrypto.viewmodel.security.SecurityViewModel
import com.cavemind.karlscrypto.viewmodel.security.SecurityUiState

@Composable
fun SecurityCenterScreen(viewModel: SecurityViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    var recentScans by remember { mutableStateOf(listOf("Initial scan: All systems green.")) }

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Security Center") }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text("Encryption Status: ${uiState.encryptionStatus}")

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Enable Biometrics")
                Spacer(modifier = Modifier.width(12.dp))
                Switch(
                    Checked = uiState.isBiometricsEnabled,
                    onCheckedChange = { viewModel.toggleBiometrics(it) }
                )
            }

            Button(onClick = {
                viewModel.triggerSelfHealCheck()
                recentScans = listOf(uiState.selfHealingStatus) + recentScans.take(4)
            }) {
                Text("Run Self-Healing Check")
            }

            Text("Self-Healing Status: ${uiState.selfHealingStatus}")

            Divider()

            Text("Recent Security Logs", style = MaterialTheme.typography.titleMedium)
            LazyColumn(modifier = Modifier.fillMaxHeight(0.4f)) {
                Items(recentScans) { log ->
                    Text("• $log", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}


