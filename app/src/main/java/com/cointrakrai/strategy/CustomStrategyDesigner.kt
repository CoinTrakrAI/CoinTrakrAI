
package com.cointrakrai.strategy

class CustomStrategyDesigner {
    fun designStrategy(rsiThreshold: Double, whaleAlert: Boolean): String {
        return if (rsiThreshold > 70 && whaleAlert) {
            "Buy signal: RSI > 70 and Whale Alert triggered."
        } else {
            "No significant signals detected."
        }
    }
}
