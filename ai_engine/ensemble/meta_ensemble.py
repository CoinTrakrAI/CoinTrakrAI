
def combine_signals(transformer, qadqn, gboost, sentiment):
    weights = [0.35, 0.25, 0.2, 0.2]
    combined_buy = (
        weights[0] * transformer['buy_score'] +
        weights[1] * qadqn['buy_score'] +
        weights[2] * gboost['buy_score'] +
        weights[3] * sentiment
    )
    combined_sell = 1 - combined_buy
    return {"buy_score": round(combined_buy, 3), "sell_score": round(combined_sell, 3)}
