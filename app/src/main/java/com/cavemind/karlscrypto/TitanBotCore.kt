package com.cavemind.karlscrypto.bot

import com.cavemind.karlscrypto.model.MarketData
import com.cavemind.karlscrypto.execution.TradeExecutor
import com.cavemind.karlscrypto.execution.ApiCredentials
import com.cavemind.karlscrypto.risk.RiskEngine
import com.cavemind.karlscrypto.trading.StrategySelector

Object TitanBotCore {

    fun run(
        marketData: MarketData,
        balance: Double,
        exchange: String,
        credentials: ApiCredentials
    ) {
        val strategy = StrategySelector.selectBestBasedOn(marketData)
        val signal = strategy.generateSignal(marketData)

        If (RiskEngine.shouldTrade(signal.confidence)) {
            val positionSize = RiskEngine.calculatePositionSize(balance, signal)
            val quantity = positionSize / marketData.prices.last()

            TradeExecutor.execute(
                Exchange = exchange,
                Symbol = marketData.symbol,
                Signal = signal,
                Quantity = quantity,
                Credentials = credentials
            )
        } else {
            Println("Signal confidence too low. No trade executed.")
        }
    }
}

