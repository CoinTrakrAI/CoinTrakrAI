package com.cavemind.karlscrypto.plugin

Interface MarketPlugin {
    fun name(): String
    fun fetchCurrentPrice(asset: String): Double
}

