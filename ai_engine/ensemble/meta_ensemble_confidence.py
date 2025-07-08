
def weighted_vote(models):
    total_weight = sum(m["confidence"] for m in models)
    weighted_sum = sum(m["buy_score"] * m["confidence"] for m in models)
    buy_score = weighted_sum / total_weight
    return {"buy_score": round(buy_score, 3), "sell_score": round(1 - buy_score, 3)}
