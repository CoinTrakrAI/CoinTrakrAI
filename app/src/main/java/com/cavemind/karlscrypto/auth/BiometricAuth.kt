package com.cavemind.karlscrypto.auth

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

fun showBiometricPrompt(context: Context, activity: FragmentActivity, callback: () -> Unit) {
    val biometricManager = BiometricManager.from(context)
    if (biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS) {
        val executor = ContextCompat.getMainExecutor(context)
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Login")
            .setSubtitle("Authenticate with your fingerprint")
            .setNegativeButtonText("Cancel")
            .build()

        val biometricPrompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    callback()
                }
            })
        biometricPrompt.authenticate(promptInfo)
    }
}
