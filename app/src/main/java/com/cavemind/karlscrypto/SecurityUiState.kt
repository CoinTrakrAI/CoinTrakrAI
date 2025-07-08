package com.cavemind.karlscrypto.viewmodel.security

data class SecurityUiState(
    val isBiometricsEnabled: Boolean = false,
    val encryptionStatus: String = "AES-256 Encrypted",
    val selfHealingStatus: String = "System secure. No anomalies detected."
)

