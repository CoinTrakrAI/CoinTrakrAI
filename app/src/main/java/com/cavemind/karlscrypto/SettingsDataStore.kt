// ===== SettingsDataStore.kt =====
package com.cointrackr

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Create DataStore Instance
val Context.dataStore by preferencesDataStore(name = "user_settings")

Object SettingsDataStore {

    private val NOTIFICATIONS_KEY = booleanPreferencesKey("notifications_enabled")
    private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode_enabled")

    fun getNotificationsEnabled(context: Context): Flow<Boolean> {
        Return context.dataStore.data.map { preferences ->
            Preferences[NOTIFICATIONS_KEY] ?: true
        }
    }

    fun getDarkModeEnabled(context: Context): Flow<Boolean> {
        Return context.dataStore.data.map { preferences ->
            Preferences[DARK_MODE_KEY] ?: true
        }
    }

    Suspend fun saveNotificationsEnabled(context: Context, enabled: Boolean) {
        Context.dataStore.edit { preferences ->
            Preferences[NOTIFICATIONS_KEY] = enabled
        }
    }

    Suspend fun saveDarkModeEnabled(context: Context, enabled: Boolean) {
        Context.dataStore.edit { preferences ->
            Preferences[DARK_MODE_KEY] = enabled
        }
    }
}

