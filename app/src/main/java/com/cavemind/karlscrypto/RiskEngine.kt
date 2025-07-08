package com.cavemind.karlscrypto.risk

import com.cavemind.karlscrypto.model.TradeSignal

Object RiskEngine {

    fun calculatePositionSize(
        Balance: Double,
        Signal: TradeSignal,
        maxRiskPerTrade: Double = 0.02 // 2% risk
    ): Double {
        val riskFactor = signal.confidence.coerceIn(0.5, 1.0)
        Return balance * maxRiskPerTrade * riskFactor
    }

    fun shouldTrade(confidence: Double): Boolean {
        Return confidence >= 0.6
    }
}

