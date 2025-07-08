
import random

def route_order(asset, decision, amount):
    """
    Simulates routing to an exchange.
    Replace this logic with real Binance/Coinbase API integrations.
    """
    brokers = ['Binance', 'Coinbase', 'Kraken', 'MockDex']
    selected = random.choice(brokers)
    return {
        "broker": selected,
        "asset": asset,
        "decision": decision,
        "executed": True,
        "amount": amount
    }
