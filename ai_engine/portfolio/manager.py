
portfolio = {
    "BTC": 0.5,
    "ETH": 1.0,
    "USDT": 1000
}

def get_portfolio():
    return portfolio

def update_portfolio(asset, decision, amount):
    if decision == "BUY":
        portfolio[asset] = portfolio.get(asset, 0) + amount
    elif decision == "SELL":
        portfolio[asset] = max(portfolio.get(asset, 0) - amount, 0)
    return portfolio
