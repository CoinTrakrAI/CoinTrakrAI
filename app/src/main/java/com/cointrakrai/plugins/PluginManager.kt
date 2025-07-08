
package com.cointrakrai.plugins

import javax.inject.Inject

class PluginManager @Inject constructor(
    val binancePlugin: BinancePlugin,
    val coinbasePlugin: CoinbasePlugin,
    val krakenPlugin: KrakenPlugin
) {
    fun initializeAll() {
        binancePlugin.init()
        coinbasePlugin.init()
        krakenPlugin.init()
    }
    fun listExchanges() = listOf("Binance", "Coinbase", "Kraken")
}
