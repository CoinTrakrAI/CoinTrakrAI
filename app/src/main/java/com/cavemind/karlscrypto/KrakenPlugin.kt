KrakenPlugin.kt
package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class KrakenPlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Kraken"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call to Kraken’s public API
        Return when (asset.lowercase()) {
            "aapl" -> 145.00
            "msft" -> 295.00
            Else -> 55.00
        }
    }
}

