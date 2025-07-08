
package com.cointrakrai.controller

class AEONCoreController {
    private var confidenceThreshold = 0.8

    fun evaluateTradeSignal(confidence: Double): Boolean {
        return confidence >= confidenceThreshold
    }

    fun explainTrade(signal: String): String {
        return when (signal) {
            "buy" -> "The AI recommends buying due to strong market trends and RSI indicators."
            "sell" -> "The AI suggests selling because the market is showing signs of overbought conditions."
            else -> "AI has no strong signals for this trade."
        }
    }
}
