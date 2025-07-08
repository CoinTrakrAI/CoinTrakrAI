package com.cavemind.karlscrypto.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.cavemind.karlscrypto.model.PortfolioItem

class PortfolioViewModel : ViewModel() {

    private val _portfolio = MutableStateFlow<List<PortfolioItem>>(emptyList())
    val portfolio: StateFlow<List<PortfolioItem>> = _portfolio

    fun addItem(item: PortfolioItem) {
        _portfolio.value = _portfolio.value + item
    }

    fun removeItem(symbol: String) {
        _portfolio.value = _portfolio.value.filterNot { it.symbol == symbol }
    }

    fun clearPortfolio() {
        _portfolio.value = emptyList()
    }

    val totalValue: Double
        Get() = _portfolio.value.sumOf { it.totalValue }

    val totalPL: Double
        Get() = _portfolio.value.sumOf { it.profitLoss }
}

