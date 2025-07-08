
package com.cointrakrai.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast

@Composable
fun LegalDisclaimerScreen(onAccepted: () -> Unit) {
    var accepted by remember { mutableStateOf(false) }
    Column {
        Text("Terms of Use & Legal Disclaimer")
        Button(onClick = {
            accepted = true
            Toast.makeText(LocalContext.current, "Accepted at " + System.currentTimeMillis(), Toast.LENGTH_LONG).show()
            onAccepted()
        }) {
            Text("Accept")
        }
    }
}
