
package com.cointrakrai.plugins

import android.util.Log

class BinancePlugin {
    var autoTradeEnabled = false
    fun init() { Log.d("BinancePlugin", "Initialized with API key.") }
    fun executeTrade() { if (autoTradeEnabled) Log.d("BinancePlugin", "Executing auto trade...") }
}
