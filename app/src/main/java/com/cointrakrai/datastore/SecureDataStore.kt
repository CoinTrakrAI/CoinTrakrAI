
package com.cointrakrai.datastore

import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class SecureDataStore(context: Context) {
    private val dataStore = context.dataStore

    // Save user data securely
    fun saveSetting(key: String, value: String) = runBlocking {
        dataStore.edit { settings ->
            settings[stringPreferencesKey(key)] = value
        }
    }

    // Read user data securely
    fun getSetting(key: String): String? = runBlocking {
        val preferences = dataStore.data.first()
        preferences[stringPreferencesKey(key)]
    }
}
