package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cavemind.karlscrypto.ui.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    Surface(
        Modifier = Modifier.fillMaxSize(),
        Color = Color.Black
    ) {
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                Text = "AI Dashboard",
                Style = MaterialTheme.typography.headlineMedium,
                Color = Color.White
            )

            Button(
                onClick = { navController.navigate(Screen.ConfidenceTracking.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FF00))
            ) {
                Text("View Confidence Index", color = Color.Black)
            }

            Button(
                onClick = { navController.navigate(Screen.LiveWalletHolo.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FF00))
            ) {
                Text("Live Wallet Holo Panel", color = Color.Black)
            }

            Button(
                onClick = { navController.navigate(Screen.HoloTracking.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FF00))
            ) {
                Text("HoloTrade Live Tracking", color = Color.Black)
            }
        }
    }
}

