package com.cavemind.karlscrypto.trading.strategies

import com.cavemind.karlscrypto.trading.Strategy
import com.cavemind.karlscrypto.model.MarketData
import com.cavemind.karlscrypto.model.TradeSignal

class MomentumStrategy : Strategy {
    Override val name: String = "Momentum"

    Override fun generateSignal(marketData: MarketData): TradeSignal {
        val priceHistory = marketData.prices.takeLast(5)
        val volumeHistory = marketData.volumes.takeLast(5)

        val priceSlope = priceHistory.last() – priceHistory.first()
        val volumeDelta = volumeHistory.last() – volumeHistory.first()

        val momentumScore = priceSlope * volumeDelta

        Return when {
            momentumScore > 0.5 -> TradeSignal.Buy(confidence = 0.75)
            momentumScore < -0.5 -> TradeSignal.Sell(confidence = 0.75)
            else -> TradeSignal.Hold(confidence = 0.5)
        }
    }
}

