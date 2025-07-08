package com.cavemind.karlscrypto.admin

import android.util.Log

object GodView {
    private val adminEmail = "kcave001@gmail.com"

    fun accessDashboard(userEmail: String): Boolean {
        if (userEmail == adminEmail) {
            Log.d("GodView", "Access granted to admin dashboard.")
            return true
        }
        Log.d("GodView", "Access denied. User: $userEmail")
        return false
    }

    fun getAllUserData(): String {
        return "Mocked: List of all users, logins, trades, behavior logs, geolocation"
    }
}
