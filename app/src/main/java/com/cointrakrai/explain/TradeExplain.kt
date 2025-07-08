
package com.cointrakrai.explain

class TradeExplain {
    fun getExplanation(tradeSignal: String): String {
        return when(tradeSignal) {
            "buy" -> "The AI recommends buying due to strong market trends and RSI indicators."
            "sell" -> "The AI suggests selling because the market is showing signs of overbought conditions."
            else -> "AI has no strong signals for this trade."
        }
    }
}
