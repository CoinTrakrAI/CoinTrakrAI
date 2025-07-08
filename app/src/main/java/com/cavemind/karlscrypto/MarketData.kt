package com.cavemind.karlscrypto.model

data class MarketData(
    val symbol: String,                  // e.g., BTCUSDT or AAPL
    val prices: List<Double>,            // Historical price data
    val volumes: List<Double>,           // Corresponding volume data
    val timestamps: List<Long> = emptyList() // Optional timestamps
)

