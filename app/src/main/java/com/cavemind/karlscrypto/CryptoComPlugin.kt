package com.cavemind.karlscrypto.plugin

import javax.inject.Inject

class CryptoComPlugin @Inject constructor() : MarketPlugin {
    Override fun name(): String = "Crypto.com"

    Override fun fetchCurrentPrice(asset: String): Double {
        // Simulated price — replace with API call to Crypto.com’s API
        Return when (asset.lowercase()) {
            "btc" -> 64000.00
            "eth" -> 3400.00
            Else -> 120.00
        }
    }
}

