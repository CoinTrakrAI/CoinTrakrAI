package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import com.cavemind.karlscrypto.model.MockTrade
import com.cavemind.karlscrypto.model.SimulatedResult
import com.cavemind.karlscrypto.simulation.MockTradeSimulator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MockTradeViewModel : ViewModel() {

    private val _simulationResults = MutableStateFlow<List<SimulatedResult>>(emptyList())
    val simulationResults: StateFlow<List<SimulatedResult>> = _simulationResults

    fun simulateTrade(trade: MockTrade) {
        _simulationResults.value = MockTradeSimulator.simulateFutureReturns(trade)
    }
}

