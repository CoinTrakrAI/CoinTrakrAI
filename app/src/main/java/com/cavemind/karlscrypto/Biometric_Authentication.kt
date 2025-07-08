package com.cavemind.karlscrypto.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.cavemind.karlscrypto.R

class SecurityActivity : ComponentActivity() {

    Override fun onCreate(savedInstanceState: Bundle?) {
        Super.onCreate(savedInstanceState)

        val biometricPrompt = BiometricPrompt(
            This,
            ContextCompat.getMainExecutor(this),
            Object : BiometricPrompt.AuthenticationCallback() {
                Override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    Super.onAuthenticationSucceeded(result)
                    // User authenticated successfully, proceed to next screen
                }

                Override fun onAuthenticationFailed() {
                    Super.onAuthenticationFailed()
                    // Handle authentication failure
                }
            }
        )

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authentication Required")
            .setDescription("Use your fingerprint to log in")
            .setDeviceCredentialAllowed(true)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}

