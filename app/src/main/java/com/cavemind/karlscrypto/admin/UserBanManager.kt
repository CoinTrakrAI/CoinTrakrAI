package com.cavemind.karlscrypto.admin

object UserBanManager {
    private val bannedUsers = mutableSetOf<String>()

    fun banUser(email: String) {
        bannedUsers.add(email)
    }

    fun unbanUser(email: String) {
        bannedUsers.remove(email)
    }

    fun isBanned(email: String): Boolean {
        return bannedUsers.contains(email)
    }
}
