package com.cavemind.karlscrypto.model

Sealed class TradeSignal(val confidence: Double) {
    class Buy(confidence: Double) : TradeSignal(confidence)
    class Sell(confidence: Double) : TradeSignal(confidence)
    class Hold(confidence: Double) : TradeSignal(confidence)
}

