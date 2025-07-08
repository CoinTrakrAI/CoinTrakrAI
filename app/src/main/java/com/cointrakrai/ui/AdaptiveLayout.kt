
package com.cointrakrai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AdaptiveLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header, content) = createGuidelines()

        Column(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top)
        }) {
            Text("Adaptive Layout for Tablets/Foldables", style = MaterialTheme.typography.h6)
        }

        Box(modifier = Modifier.constrainAs(content) {
            top.linkTo(header.bottom, margin = 16.dp)
        }) {
            Text("Content goes here...")
        }
    }
}

@Preview
@Composable
fun PreviewAdaptiveLayout() {
    AdaptiveLayout()
}
