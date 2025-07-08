package com.cavemind.karlscrypto.simulation

import com.cavemind.karlscrypto.model.MockTrade
import com.cavemind.karlscrypto.model.SimulatedResult
import java.time.LocalDate
import kotlin.math.pow
import kotlin.random.Random

Object MockTradeSimulator {

    // Simulate price changes with pseudo-random compounding growth/decline
    fun simulateFutureReturns(trade: MockTrade): List<SimulatedResult> {
        val projections = listOf(30, 90, 180, 365)
        val basePrice = trade.asset.price
        val amount = trade.amountInvested

        Return projections.map { days ->
            val growthFactor = simulateGrowthRate(trade.asset.symbol)
            val projectedPrice = basePrice * (1 + growthFactor).pow(days / 30.0)
            SimulatedResult(
                Date = trade.tradeDate.plusDays(days.toLong()),
                projectedValue = amount * (projectedPrice / basePrice)
            )
        }
    }

    // Simulate growth between -5% and +10% monthly based on random and symbol hash
    private fun simulateGrowthRate(symbol: String): Double {
        val seed = symbol.hashCode()
        Return (Random(seed).nextDouble(-0.05, 0.10))
    }
}

