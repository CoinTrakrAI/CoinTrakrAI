
def check_market_volatility(news_scores, reddit_scores, twitter_scores):
    avg_score = (news_scores + reddit_scores + twitter_scores) / 3
    if abs(avg_score) > 0.6:
        return "PAUSE"  # hedge or stop trades
    return "TRADE"
