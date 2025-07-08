package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.cavemind.karlscrypto.model.MirrorTraderProfile

class MirrorTradingViewModel : ViewModel() {
    private val _topTraders = MutableStateFlow(
        listOf(
            MirrorTraderProfile("AlphaWolf", 128.7, 4120, "Momentum Burst Strategy"),
            MirrorTraderProfile("CoinSeeker", 94.3, 3020, "Dip + Swing Strategy"),
            MirrorTraderProfile("QuantumWhale", 82.0, 2590, "Scalp + Machine Learning Blend")
        )
    )
    val topTraders: StateFlow<List<MirrorTraderProfile>> = _topTraders
}

