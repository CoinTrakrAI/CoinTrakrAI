
def classify_market(rsi, macd_hist, news_sentiment):
    if abs(macd_hist) < 0.1 and abs(rsi - 50) < 10:
        return "CHOP"
    elif news_sentiment < -0.5:
        return "SHOCK"
    elif macd_hist > 0.2:
        return "BULL"
    else:
        return "BEAR"
