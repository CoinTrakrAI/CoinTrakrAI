package com.karlscryptoapp.ai

import com.karlscryptoapp.models.PortfolioAdjustment
import com.karlscryptoapp.models.TradeExecution

Object PortfolioRebalancer {

    // Rebalance portfolio based on trade results and overall PnL
    fun rebalancePortfolio(trades: List<TradeExecution>, pnlData: List<Double>): PortfolioAdjustment {
        val totalPnL = pnlData.sum()
        val riskScore = if (totalPnL < -0.1) {
            "Reduce Risk"
        } else if (totalPnL > 0.2) {
            "Increase Risk"
        } else {
            "Hold"
        }

        Return PortfolioAdjustment(
            Action = riskScore,
            Recommendation = when (riskScore) {
                "Reduce Risk" -> "Shift capital to stablecoins or hedged tokens"
                "Increase Risk" -> "Allocate more to trending sectors"
                Else -> "Maintain allocation"
            }
        )
    }
}

