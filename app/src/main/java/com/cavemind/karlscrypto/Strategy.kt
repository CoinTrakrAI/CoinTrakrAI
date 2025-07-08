package com.cavemind.karlscrypto.trading

import com.cavemind.karlscrypto.model.MarketData
import com.cavemind.karlscrypto.model.TradeSignal

Interface Strategy {
    val name: String
    fun generateSignal(marketData: MarketData): TradeSignal
}

