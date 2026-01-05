package com.jminnovatech.enjoybazar.core.session

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore("user_session")

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences("session", Context.MODE_PRIVATE)

    fun saveSession(token: String, role: String) {
        prefs.edit()
            .putString("token", token)
            .putString("role", role)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getString("token", null) != null
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }

    fun getRole(): String? = prefs.getString("role", null)
}

