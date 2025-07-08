package com.cavemind.karlscrypto.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.ai.memory.TitanMemory

@Composable
fun TitanDashboard() {
    val logs = remember { TitanMemory.summarize().split("\n") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("🧠 TITAN Decision Log", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(logs) { log ->
                Text(log, style = MaterialTheme.typography.bodyMedium)
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { TitanMemory.clear() }) {
            Text("Clear Memory")
        }
    }
}
