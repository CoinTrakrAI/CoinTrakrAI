package com.cavemind.karlscrypto.api

import retrofit2.http.GET
import retrofit2.http.Query

Interface HistoricalCryptoApi {
    @GET("v1/bpi/historical/close.json")
    Suspend fun getBitcoinHistory(
        @Query("start") startDate: String, // format: yyyy-MM-dd
        @Query("end") endDate: String,
        @Query("currency") currency: String = "USD",
        @Query("api_key") apiKey: String = "f9c0f8a9add9858baa9ea4d70fcf9051ec4116f7ae3fdd5db22c92f66c247bb1"
    ): CoinDeskHistoricalResponse
}

