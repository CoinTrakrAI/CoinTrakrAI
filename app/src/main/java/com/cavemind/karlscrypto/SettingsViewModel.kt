// ===== Updated SettingsViewModel.kt =====
package com.cointrackr

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    private val _notificationsEnabled = MutableStateFlow(true)
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled

    private val _darkModeEnabled = MutableStateFlow(true)
    val darkModeEnabled: StateFlow<Boolean> = _darkModeEnabled

    Init {
        SettingsDataStore.getNotificationsEnabled(context).onEach {
            _notificationsEnabled.value = it
        }.launchIn(viewModelScope)

        SettingsDataStore.getDarkModeEnabled(context).onEach {
            _darkModeEnabled.value = it
        }.launchIn(viewModelScope)
    }

    fun toggleNotifications(enabled: Boolean) {
        viewModelScope.launch {
            SettingsDataStore.saveNotificationsEnabled(context, enabled)
        }
    }

    fun toggleDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            SettingsDataStore.saveDarkModeEnabled(context, enabled)
        }
    }
}

