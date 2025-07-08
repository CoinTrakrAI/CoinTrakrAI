package com.cavemind.karlscrypto.analysis

data class MarketData(
    val symbol: String,
    val currentPrice: Double,
    val price1hAgo: Double,
    val currentVolume: Double,
    val avgVolume1h: Double,
    val emaFast: Double,
    val emaSlow: Double,
    val adx: Double,
    val rsi: Double
)

data class TradeSignal(
    val symbol: String,
    val action: String,
    val confidence: Double,
    val stopLoss: Double,
    val takeProfit: Double
)

fun generateSignal(data: MarketData): TradeSignal? {
    val priceChange = (data.currentPrice - data.price1hAgo) / data.price1hAgo
    val volumeSpike = data.currentVolume / data.avgVolume1h

    val isMomentum = priceChange > 0.03 && volumeSpike > 1.5
    val trendUp = data.emaFast > data.emaSlow && data.adx > 25
    val notOverbought = data.rsi < 70

    val confidence = when {
        isMomentum && trendUp && notOverbought -> 0.9
        isMomentum && trendUp -> 0.75
        isMomentum -> 0.6
        else -> 0.0
    }

    return if (confidence >= 0.6) {
        TradeSignal(
            symbol = data.symbol,
            action = "BUY",
            confidence = confidence,
            stopLoss = data.currentPrice * 0.97,
            takeProfit = data.currentPrice * 1.10
        )
    } else null
}