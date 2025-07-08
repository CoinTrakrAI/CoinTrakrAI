Great! Now that you have your **CoinMarketCap API key** (`ab04fd00-fe56-4dee-a83d-6801a25f93f0`), let’s integrate it into the code I provided earlier.

### **Steps for Integration**:

**Update Retrofit API Interface for CoinMarketCap**:
   We’ll add the CoinMarketCap API key directly into the request headers to authenticate the API requests.

**Add Your CoinMarketCap API Key**:
   Replace the placeholder `YOUR_API_KEY` with your actual CoinMarketCap API key (`ab04fd00-fe56-4dee-a83d-6801a25f93f0`) in the code.

### **1. Updated CryptoApi Interface (CoinMarketCap)**

Here’s how to integrate the CoinMarketCap API with your provided API key:

```kotlin
package com.cavemind.karlscrypto.network

import com.cavemind.karlscrypto.model.MarketAsset
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Headers

Interface CryptoApi {

    // Replace with your CoinMarketCap API Key in the header
    @Headers("X-CMC_PRO_API_KEY: ab04fd00-fe56-4dee-a83d-6801a25f93f0")
    @GET("cryptocurrency/listings/latest")
    Suspend fun getTopCryptos(
        @Query("limit") limit: Int = 10,  // Adjust this to get more than 10 if needed
        @Query("convert") currency: String = "USD",
        @Query("start") start: Int = 1
    ): List<MarketAsset>
}
```

### **2. StockApi Interface (IEX Cloud)**

For the stock data, we need to make sure you also have your **IEX Cloud API key**. You’ll replace `YOUR_API_KEY` with your actual key here as well.

```kotlin
package com.cavemind.karlscrypto.network

import com.cavemind.karlscrypto.model.MarketAsset
import retrofit2.http.GET
import retrofit2.http.Query

Interface StockApi {

    @GET("stock/market/list/mostactive")
    Suspend fun getTopStocks(
        @Query("token") apiKey: String,  // Your IEX Cloud API Key
    ): List<MarketAsset>
}
```

### **3. DashboardViewModel Update**

Now, we can use this to fetch the data from both **CoinMarketCap** and **IEX Cloud** (stocks) and update the dashboard:

```kotlin
package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavemind.karlscrypto.model.MarketAsset
import com.cavemind.karlscrypto.network.CryptoApi
import com.cavemind.karlscrypto.network.StockApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardViewModel(
    private val cryptoApi: CryptoApi,
    private val stockApi: StockApi
) : ViewModel() {

    private val _topCryptos = MutableStateFlow<List<MarketAsset>>(emptyList())
    val topCryptos: StateFlow<List<MarketAsset>> = _topCryptos

    private val _topStocks = MutableStateFlow<List<MarketAsset>>(emptyList())
    val topStocks: StateFlow<List<MarketAsset>> = _topStocks

    Init {
        fetchTopAssets()
    }

    private fun fetchTopAssets() {
        viewModelScope.launch {
            // Fetch top 10 cryptos from CoinMarketCap
            val cryptos = withContext(Dispatchers.IO) {
                cryptoApi.getTopCryptos(limit = 10)
            }
            _topCryptos.value = cryptos

            // Fetch top 10 stocks from IEX Cloud
            val stocks = withContext(Dispatchers.IO) {
                stockApi.getTopStocks(apiKey = "YOUR_IEX_API_KEY") // Replace with your IEX API key
            }
            _topStocks.value = stocks
        }
    }
}
```

### **4. Displaying Data in Compose UI**

In your UI, you can display the top cryptocurrencies and stocks fetched from the APIs. Here’s how to bind it to your `TradingDashboard` composable:

```kotlin
package com.cavemind.karlscrypto.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cavemind.karlscrypto.viewmodel.DashboardViewModel

@Composable
fun TradingDashboard(viewModel: DashboardViewModel) {
    val topCryptos = viewModel.topCryptos.collectAsState().value
    val topStocks = viewModel.topStocks.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Trading Dashboard") })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            // Top 10 Cryptos
            Text("Top 10 Cryptos", style = MaterialTheme.typography.titleLarge)
            LazyColumn {
                Items(topCryptos) { crypto ->
                    MarketItem(crypto)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Top 10 Stocks
            Text("Top 10 Stocks", style = MaterialTheme.typography.titleLarge)
            LazyColumn {
                Items(topStocks) { stock ->
                    MarketItem(stock)
                }
            }
        }
    }
}

@Composable
fun MarketItem(asset: MarketAsset) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(asset.name, style = MaterialTheme.typography.bodyMedium)
        Text("\$${asset.price}", style = MaterialTheme.typography.bodySmall)
    }
}
```

### **Important Notes:**

**CoinMarketCap API**: You’re using the `X-CMC_PRO_API_KEY` header to authenticate. Make sure not to expose your API key in a production app. Consider using environment variables or a secure way to store keys.

**IEX Cloud API**: You’ll need to insert your **IEX Cloud API key** in place of `YOUR_IEX_API_KEY` in the ViewModel.


**API Request Limits**: Be aware of the request limits in both CoinMarketCap and IEX Cloud. Free tiers have usage limits, so make sure to stay within those limits to avoid exceeding them.


### **Next Steps**

1. Replace the API keys in the code with your **CoinMarketCap API key** (`ab04fd00-fe56-4dee-a83d-6801a25f93f0`) and your **IEX Cloud API key**.
2. Implement the `DashboardViewModel` into your app and bind it to your UI.
3. Use **LazyColumn** in Jetpack Compose to show the top 10 cryptocurrencies and stocks.

This setup will allow you to display top cryptocurrencies and top stocks data on your trading dashboard.

