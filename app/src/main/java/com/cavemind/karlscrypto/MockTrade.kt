package com.cavemind.karlscrypto.model

import java.time.LocalDate

data class MockTrade(
    val asset: MarketAsset,
    val amountInvested: Double,
    val tradeDate: LocalDate = LocalDate.now()
)

data class SimulatedResult(
    val date: LocalDate,
    val projectedValue: Double
)

