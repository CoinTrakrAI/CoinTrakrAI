package com.cavemind.karlscrypto.portfolio

data class AssetHolding(val symbol: String, val quantity: Double, val currentPrice: Double)

Object PortfolioManager {

    fun calculateTotalValue(holdings: List<AssetHolding>): Double {
        Return holdings.sumOf { it.quantity * it.currentPrice }
    }

    fun rebalance(holdings: List<AssetHolding>, targetWeights: Map<String, Double>): List<AssetHolding> {
        val total = calculateTotalValue(holdings)
        Return targetWeights.mapNotNull { (symbol, targetWeight) ->
            Holdings.find { it.symbol == symbol }?.let {
                val targetValue = total * targetWeight
                val newQty = targetValue / it.currentPrice
                It.copy(quantity = newQty)
            }
        }
    }
}

