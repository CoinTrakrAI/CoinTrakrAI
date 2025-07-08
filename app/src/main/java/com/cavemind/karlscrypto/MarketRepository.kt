class MarketRepository @Inject constructor(
    private val cryptoApi: CryptoApi,
    private val stockApi: StockApi,
    private val historicalApi: HistoricalCryptoApi
) {

    Suspend fun getBitcoinHistory(start: String, end: String): Map<String, Double> {
        Return historicalApi.getBitcoinHistory(start, end).bpi
    }

    Suspend fun getLiveCryptos(): List<MarketAsset> {
        val response = cryptoApi.getLatestCryptos("ab04fd00-fe56-4dee-a83d-6801a25f93f0")
        Return response.data.map {
            MarketAsset(name = it.name, symbol = it.symbol, price = it.quote["USD"]?.price ?: 0.0)
        }
    }

    Suspend fun getLiveStocks(): List<MarketAsset> {
        val stockList = listOf("AAPL", "MSFT", "GOOGL")
        Return stockList.mapNotNull { symbol ->
            Try {
                val stock = stockApi.getStock(symbol, "d0egc41r01qkbclb6vggd0egc41r01qkbclb6vh0")
                MarketAsset(stock.companyName, stock.symbol, stock.latestPrice)
            } catch (e: Exception) {
                Null
            }
        }
    }
}

