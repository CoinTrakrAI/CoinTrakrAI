package com.cavemind.karlscrypto.di

import com.cavemind.karlscrypto.plugin.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
Object MarketPluginModule {

    @Provides
    @Singleton
    fun provideMarketPlugins(
        coinbasePlugin: CoinbasePlugin,
        cryptoComPlugin: CryptoComPlugin,
        upholdPlugin: UpholdPlugin,
        robinhoodPlugin: RobinhoodPlugin,
        krakenPlugin: KrakenPlugin
    ): Set<MarketPlugin> {
        Return setOf(coinbasePlugin, cryptoComPlugin, upholdPlugin, robinhoodPlugin, krakenPlugin)
    }
}

