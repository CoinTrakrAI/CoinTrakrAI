Perfect — with your **IEX Cloud API key** (`d0egc41r01qkbclb6vggd0egc41r01qkbclb6vh0`), you’re all set to pull stock data.


### ✅ Here’s how everything wires up:


##  1. **Stock API Interface** (IEX Cloud)

```kotlin
package com.cavemind.karlscrypto.network

import com.cavemind.karlscrypto.model.StockItem
import retrofit2.http.GET
import retrofit2.http.Query

Interface StockApi {
    @GET("stock/market/list/mostactive")
    Suspend fun getTopStocks(
        @Query("token") apiKey: String = "d0egc41r01qkbclb6vggd0egc41r01qkbclb6vh0"
    ): List<StockItem>
}
```


##  2. **Crypto API Interface** (CoinMarketCap)

```kotlin
package com.cavemind.karlscrypto.network

import com.cavemind.karlscrypto.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

Interface CryptoApi {
    @Headers("X-CMC_PRO_API_KEY: ab04fd00-fe56-4dee-a83d-6801a25f93f0")
    @GET("cryptocurrency/listings/latest")
    Suspend fun getTopCryptos(
        @Query("limit") limit: Int = 10,
        @Query("convert") currency: String = "USD"
    ): CryptoResponse
}
```


##  3. **Dashboard ViewModel**

```kotlin
package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavemind.karlscrypto.model.CryptoItem
import com.cavemind.karlscrypto.model.StockItem
import com.cavemind.karlscrypto.network.CryptoApi
import com.cavemind.karlscrypto.network.StockApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val cryptoApi: CryptoApi,
    private val stockApi: StockApi
) : ViewModel() {

    private val _topCryptos = MutableStateFlow<List<CryptoItem>>(emptyList())
    val topCryptos: StateFlow<List<CryptoItem>> = _topCryptos

    private val _topStocks = MutableStateFlow<List<StockItem>>(emptyList())
    val topStocks: StateFlow<List<StockItem>> = _topStocks

    Init {
        fetchAssets()
    }

    private fun fetchAssets() {
        viewModelScope.launch {
            try {
                val cryptoResponse = cryptoApi.getTopCryptos()
                _topCryptos.value = cryptoResponse.data

                val stocks = stockApi.getTopStocks()
                _topStocks.value = stocks
            } catch (e: Exception) {
                // Add error logging or recovery logic here
            }
        }
    }
}
```


##  4. **Minimal Data Models**

```kotlin
// Crypto
data class CryptoResponse(val data: List<CryptoItem>)
data class CryptoItem(val name: String, val symbol: String, val quote: Map<String, Quote>)
data class Quote(val price: Double)

// Stock
data class StockItem(val symbol: String, val companyName: String, val latestPrice: Double)
```


##  5. Retrofit Module with Hilt

```kotlin
@Module
@InstallIn(SingletonComponent::class)
Object NetworkModule {

    @Provides
    fun provideCryptoApi(): CryptoApi {
        Return Retrofit.Builder()
            .baseUrl()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    fun provideStockApi(): StockApi {
        Return Retrofit.Builder()
            .baseUrl()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StockApi::class.java)
    }
}
```


##  What You’ll Get on Your Dashboard

* ✅ **Top 10 Cryptocurrencies** with live pricing.
* ✅ **Top Stocks (Most Active)** from IEX Cloud.
*  Add sort, filter, and performance badges next.


Let me know when you’re ready to wire this into the Compose UI. Want me to generate the dashboard screen UI too?

