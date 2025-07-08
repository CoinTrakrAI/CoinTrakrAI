
import numpy as np
from src.signals import generate_signals
from src.risk.position import calculate_position_size
from src.explain.explain import explain_decision
from src.rl.rl_policy import adapt_policy
from src.broker.router import route_order
from src.portfolio.manager import update_portfolio, get_portfolio

def make_decision(data):
    prices = np.array(data['prices'])
    asset = data.get('asset', 'BTC')
    wallet = data.get('wallet', 1000)
    signals = generate_signals(prices)
    signals = adapt_policy(signals, prices)

    position = calculate_position_size(wallet, signals)
    decision, confidence = 'HOLD', 50

    if signals['buy_score'] > 0.7:
        decision, confidence = 'BUY', int(signals['buy_score']*100)
    elif signals['sell_score'] > 0.7:
        decision, confidence = 'SELL', int(signals['sell_score']*100)

    explanation = explain_decision(signals, decision, confidence)

    # Route to broker if action taken
    execution = {}
    if decision in ["BUY", "SELL"]:
        execution = route_order(asset, decision, position)
        update_portfolio(asset, decision, position)

    return {
        "decision": decision,
        "confidence": confidence,
        "size": round(position, 3),
        "asset": asset,
        "execution": execution,
        "portfolio": get_portfolio(),
        "reasons": explanation
    }
