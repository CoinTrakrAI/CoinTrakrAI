def explain_decision(signals, decision, confidence):
    reasons = []
    if decision == "BUY":
        reasons.append(f"High buy signal score: {signals['buy_score']:.2f}")
    elif decision == "SELL":
        reasons.append(f"High sell signal score: {signals['sell_score']:.2f}")
    else:
        reasons.append("No strong signals")
    return reasons