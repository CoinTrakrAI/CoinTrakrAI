package com.cavemind.karlscrypto.service

import com.cavemind.karlscrypto.plugin.MarketPlugin
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TradeExecutorService @Inject constructor(
    private val marketPlugins: Set<@JvmSuppressWildcards MarketPlugin>
) {
    fun executeTrade(action: String, asset: String): String {
        // This is a stub—hook in live plugin logic or AI logic here
        val plugin = marketPlugins.firstOrNull() ?: return "No market plugin available"
        val currentPrice = plugin.fetchCurrentPrice(asset)
        Return "$action executed on $asset at $currentPrice using ${plugin.name()}"
    }
}

