package com.cavemind.karlscrypto.ui.postscheduler

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostSchedulerScreen() {
    var scheduledTime by remember { mutableStateOf("14:00") }
    var caption by remember { mutableStateOf("The market's heating up, stay tuned!") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("📅 AI Post Scheduler", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = scheduledTime,
            onValueChange = { scheduledTime = it },
            label = { Text("Engagement Time") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = caption,
            onValueChange = { caption = it },
            label = { Text("AI Caption Suggestion") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Trigger post scheduling
        }) {
            Text("Schedule Post")
        }
    }
}
