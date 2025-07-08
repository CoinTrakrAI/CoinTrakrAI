package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class RobinhoodPlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Robinhood"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call to Robinhood’s public API
        Return when (asset.lowercase()) {
            "aapl" -> 150.00
            "msft" -> 300.00
            Else -> 50.00
        }
    }
}

