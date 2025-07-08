package com.cavemind.karlscrypto.trading

import com.cavemind.karlscrypto.model.MarketData
import com.cavemind.karlscrypto.trading.strategies.MeanReversionStrategy
import com.cavemind.karlscrypto.trading.strategies.MomentumStrategy

Object StrategySelector {
    private val strategies = listOf(
        MomentumStrategy(),
        MeanReversionStrategy()
        // Add more later: ArbitrageStrategy, SentimentStrategy, etc.
    )

    fun selectBestBasedOn(marketData: MarketData): Strategy {
        val volatility = marketData.prices.maxOrNull()?.minus(marketData.prices.minOrNull() ?: 0.0) ?: 0.0
        Return if (volatility > 0.05) MomentumStrategy() else MeanReversionStrategy()
    }
}

