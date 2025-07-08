
package com.cointrakrai.ui

class TradeExplain {
    fun getExplanation(tradeSignal: String): String {
        return when(tradeSignal) {
            "buy" -> "This buy signal was generated based on a strong uptrend in the market and RSI indicators."
            "sell" -> "This sell signal was triggered due to a market reversal and RSI indicators showing overbought conditions."
            else -> "AI detected no significant signals for this trade."
        }
    }
}
