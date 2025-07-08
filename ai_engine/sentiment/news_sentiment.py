
def get_sentiment_score(news_headlines):
    # Simulate NLP output score
    if any("crash" in headline.lower() for headline in news_headlines):
        return -0.7
    elif any("rally" in headline.lower() for headline in news_headlines):
        return 0.7
    return 0.0
