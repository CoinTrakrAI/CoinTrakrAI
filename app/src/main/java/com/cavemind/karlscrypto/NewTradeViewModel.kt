package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavemind.karlscrypto.service.TradeExecutorService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TradeViewModel @Inject constructor(
    private val tradeExecutorService: TradeExecutorService
) : ViewModel() {

    private val _uiState = MutableStateFlow(TradeUiState())
    val uiState: StateFlow<TradeUiState> = _uiState

    fun executeTrade(action: String, asset: String) {
        viewModelScope.launch {
            val result = tradeExecutorService.executeTrade(action, asset)
            _uiState.value = _uiState.value.copy(resultMessage = result)
        }
    }
}

data class TradeUiState(
    val resultMessage: String = ""
)

