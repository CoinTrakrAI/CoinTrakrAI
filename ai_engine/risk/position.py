def calculate_position_size(wallet, signals):
    confidence = signals.get("buy_score", 0.5)
    base_size = wallet * 0.05
    if confidence > 0.8:
        return base_size * 2
    elif confidence < 0.6:
        return base_size * 0.5
    return base_size