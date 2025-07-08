@Provides
fun provideHistoricalCryptoApi(): HistoricalCryptoApi {
    Return Retrofit.Builder()
        .baseUrl()
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HistoricalCryptoApi::class.java)
}

