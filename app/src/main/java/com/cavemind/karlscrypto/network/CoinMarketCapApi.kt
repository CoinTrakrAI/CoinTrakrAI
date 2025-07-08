package com.cavemind.karlscrypto.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinMarketCapApi {
    @Headers("X-CMC_PRO_API_KEY: YOUR_API_KEY")
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getTopCryptos(): retrofit2.Response<String>
}

object RetrofitService {
    val api: CoinMarketCapApi = Retrofit.Builder()
        .baseUrl("https://pro-api.coinmarketcap.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinMarketCapApi::class.java)
}
