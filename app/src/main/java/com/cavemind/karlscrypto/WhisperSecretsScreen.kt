package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.model.WhisperIntel

@Composable
fun WhisperSecretsScreen(
    Secrets: List<WhisperIntel>,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Whisper Secrets") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.Lock, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Items(secrets) { secret ->
                Card(
                    Modifier = Modifier.fillMaxWidth(),
                    Elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("️‍️ ${secret.title}", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(secret.details, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("️ ${secret.timestamp}", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}

