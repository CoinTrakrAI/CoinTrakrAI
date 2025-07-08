package com.cavemind.karlscrypto.model

data class TopTrader(
    val name: String,
    val followers: Int,
    val bio: String,
    val rankBadge: Int, // Drawable resource ID like R.drawable.badge_gold
    val reputationScore: Double // Example: 4.9/5.0 reputation system
) {
    // Get formatted reputation score for display (optional)
    fun getFormattedReputation(): String {
        Return "${"%.1f".format(reputationScore)}/5.0"
    }

    // Return a string representation of the trader’s follower count
    fun getFormattedFollowers(): String {
        Return "$followers Followers"
    }
}

