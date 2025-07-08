package com.karlscryptoapp.ai

import kotlin.math.*
import com.karlscryptoapp.models.MarketData
import com.karlscryptoapp.models.TradeSignal

Object AiTradeSignalEngine {

    fun generateSignal(data: MarketData): TradeSignal? {
        val priceChange = (data.currentPrice – data.price1hAgo) / data.price1hAgo
        val volumeSpike = if (data.avgVolume1h > 0) data.currentVolume / data.avgVolume1h else 0.0
        val rsi = data.rsi
        val adx = data.adx
        val emaTrendUp = data.emaFast > data.emaSlow

        val isMomentum = priceChange > 0.03 && volumeSpike > 1.5
        val isTrend = emaTrendUp && adx > 25
        val isHealthyEntry = rsi < 70

        val confidence = when {
            isMomentum && isTrend && isHealthyEntry -> 0.90
            isMomentum && isTrend -> 0.75
            isMomentum -> 0.60
            else -> 0.0
        }

        Return if (confidence >= 0.6) {
            TradeSignal(
                Symbol = data.symbol,
                Action = "BUY",
                Confidence = confidence,
                stopLoss = data.currentPrice * 0.97,     // 3% stop
                takeProfit = data.currentPrice * 1.10    // 10% target
            )
        } else {
            Null
        }
    }
}

