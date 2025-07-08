package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class UpholdPlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Uphold"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call to Uphold’s API
        Return when (asset.lowercase()) {
            "btc" -> 65500.00
            "eth" -> 3550.00
            Else -> 110.00
        }
    }
}

