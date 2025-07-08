
package com.cointrakrai.notifications

import android.util.Log

class NotificationCenter {
    fun logAITradeDecision(tradeDecision: String) {
        Log.d("NotificationCenter", "AI decision logged: $tradeDecision")
    }
}
