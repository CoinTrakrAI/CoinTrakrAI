package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class BinancePlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Binance"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call
        Return when (asset.lowercase()) {
            "btc" -> 64350.12
            "eth" -> 3420.50
            Else -> 123.45
        }
    }
}

