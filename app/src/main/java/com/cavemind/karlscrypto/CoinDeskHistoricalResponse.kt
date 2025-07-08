package com.cavemind.karlscrypto.model

data class CoinDeskHistoricalResponse(
    val bpi: Map<String, Double>, // "YYYY-MM-DD" to price
    val disclaimer: String,
    val time: TimeMetadata
)

data class TimeMetadata(
    val updated: String,
    val updatedISO: String
)