package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class CoinbasePlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Coinbase"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call to Coinbase’s public API
        Return when (asset.lowercase()) {
            "btc" -> 65000.00
            "eth" -> 3500.00
            Else -> 100.00
        }
    }
}

