package com.cavemind.karlscrypto.trading.strategies

import com.cavemind.karlscrypto.trading.Strategy
import com.cavemind.karlscrypto.model.MarketData
import com.cavemind.karlscrypto.model.TradeSignal

class MeanReversionStrategy : Strategy {
    Override val name: String = "Mean Reversion"

    Override fun generateSignal(marketData: MarketData): TradeSignal {
        val priceHistory = marketData.prices
        val currentPrice = priceHistory.last()
        val avgPrice = priceHistory.average()

        val deviation = (currentPrice – avgPrice) / avgPrice

        Return when {
            Deviation < -0.03 -> TradeSignal.Buy(confidence = 0.7)
            Deviation > 0.03 -> TradeSignal.Sell(confidence = 0.7)
            Else -> TradeSignal.Hold(confidence = 0.5)
        }
    }
}

