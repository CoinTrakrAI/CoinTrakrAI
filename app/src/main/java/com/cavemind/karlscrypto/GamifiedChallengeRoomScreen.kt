package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavemind.karlscrypto.model.Challenge
import com.cavemind.karlscrypto.viewmodel.GamifiedViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GamifiedChallengeRoomScreen(
    viewModel: GamifiedViewModel = viewModel(),
    onBack: () -> Unit
) {
    val challenges by viewModel.challengeList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                Title = { Text("Challenge Room") },
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
                Text = "Gamified Trading Missions",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Items(challenges) { challenge ->
                    ChallengeCard(challenge)
                }
            }
        }
    }
}

@Composable
fun ChallengeCard(challenge: Challenge) {
    Card(
        Modifier = Modifier.fillMaxWidth(),
        Elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = challenge.title, fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = challenge.description)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Points: ${challenge.points}")
        }
    }
}

