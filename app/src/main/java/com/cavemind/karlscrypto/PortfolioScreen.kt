// ===== PortfolioScreen.kt =====
package com.cointrackr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PortfolioScreen() {
    Surface(
        Modifier = Modifier.fillMaxSize(),
        Color = Color.Black
    ) {
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                Text = "Your Portfolio Overview",
                Color = Color.Magenta,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                Painter = painterResource(id = R.drawable.brain_3d),
                contentDescription = "AI 3D Brain",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                Text = "AI is analyzing your investments…",
                Color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

