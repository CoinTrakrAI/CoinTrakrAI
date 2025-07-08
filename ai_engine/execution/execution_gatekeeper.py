
def should_execute(trade_signal, model_agreement, volatility, confidence_threshold=0.85):
    return (
        trade_signal['confidence'] >= confidence_threshold
        and model_agreement >= 3
        and volatility <= 0.04
    )
