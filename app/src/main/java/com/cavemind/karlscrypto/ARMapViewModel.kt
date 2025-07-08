package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ARMapViewModel : ViewModel() {
    private val _trackingEnabled = MutableStateFlow(false)
    val trackingEnabled: StateFlow<Boolean> = _trackingEnabled

    fun toggleTracking() {
        _trackingEnabled.value = !_trackingEnabled.value
    }
}

