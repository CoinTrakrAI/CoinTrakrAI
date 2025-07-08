package com.cavemind.karlscrypto.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Brain3DScreen() {
    Column(
        Modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            Text = "Dual-AI Neural Sync",
            Style = MaterialTheme.typography.headlineSmall,
            Modifier = Modifier.padding(bottom = 16.dp)
        )

        Canvas(
            Modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val brainWidth = size.width * 0.7f
            val brainHeight = size.height * 0.8f

            val leftColor = Color.Cyan.copy(alpha = 0.6f)
            val rightColor = Color.Magenta.copy(alpha = 0.6f)

            drawRoundRect(
                color = leftColor,
                topLeft = Offset(centerX – brainWidth / 2, centerY – brainHeight / 2),
                size = androidx.compose.ui.geometry.Size(brainWidth / 2, brainHeight),
                cornerRadius = CornerRadius(60f, 60f)
            )
            drawRoundRect(
                color = rightColor,
                topLeft = Offset(centerX, centerY – brainHeight / 2),
                size = androidx.compose.ui.geometry.Size(brainWidth / 2, brainHeight),
                cornerRadius = CornerRadius(60f, 60f)
            )

            // Optional: Draw center spark
            drawIntoCanvas { canvas ->
                drawCircle(
                    color = Color.White,
                    radius = 10f,
                    center = Offset(centerX, centerY)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            Text = "The holographic brain shows TITAN and Jarvis syncing decisions in real-time.",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

