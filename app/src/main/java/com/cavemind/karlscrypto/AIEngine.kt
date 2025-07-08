// ===== AIEngine.kt =====
package com.cointrackr.ai

Object AIEngine {

    fun predictMarketTrend(symbol: String): String {
        Return when (symbol.uppercase()) {
            "BTC", "ETH", "SOL" -> "Bullish  (Positive Trend Expected)"
            "AAPL", "TSLA", "NVDA" -> "Neutral ↔ (Stable, Minor Fluctuations)"
            Else -> "Caution ️ (Uncertain Trend)"
        }
    }

    fun getConfidenceIndex(symbol: String): Int {
        Return when (symbol.uppercase()) {
            "BTC", "ETH" -> 85
            "SOL", "AAPL" -> 75
            "TSLA", "NVDA" -> 70
            Else -> 50
        }
    }
}

