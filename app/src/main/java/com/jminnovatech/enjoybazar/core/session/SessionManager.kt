package com.jminnovatech.enjoybazar.core.session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs =
        context.getSharedPreferences("enjoybazar_session", Context.MODE_PRIVATE)

    fun saveSession(
        userId: Int,
        token: String,
        role: String
    ) {
        prefs.edit()
            .putInt("user_id", userId)
            .putString("token", token)
            .putString("role", role)
            .apply()
    }

    fun getToken(): String? = prefs.getString("token", null)

    fun getRole(): String? = prefs.getString("role", null)

    fun getUserId(): Int = prefs.getInt("user_id", 0)

    fun isLoggedIn(): Boolean = getToken() != null

    fun clear() {
        prefs.edit().clear().apply()
    }
}

