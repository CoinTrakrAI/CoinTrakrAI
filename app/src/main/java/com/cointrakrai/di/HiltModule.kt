
package com.cointrakrai.di

import com.cointrakrai.ui.TTSHelper
import com.cointrakrai.ui.TradeExplain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides @Singleton fun provideTTSHelper(appContext: android.content.Context) = TTSHelper(appContext)
    @Provides @Singleton fun provideTradeExplain() = TradeExplain()
}
