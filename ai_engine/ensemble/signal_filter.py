
def filter_signal(signal, threshold=0.15):
    if abs(signal['buy_score'] - signal['sell_score']) < threshold:
        return "HOLD"
    return "BUY" if signal['buy_score'] > signal['sell_score'] else "SELL"
