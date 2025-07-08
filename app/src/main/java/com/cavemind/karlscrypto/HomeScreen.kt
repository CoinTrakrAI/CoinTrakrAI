package com.cavemind.karlscrypto

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("CoinTrackrAI") }
            )
        }
    ) {
        Text("Welcome to TITAN Social AI", modifier = androidx.compose.ui.Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
