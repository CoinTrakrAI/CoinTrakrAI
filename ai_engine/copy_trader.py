
import random

class CopyTrader:
    def __init__(self):
        # Simulate a leaderboard of top traders
        self.leaderboard = [
            {'name': 'TraderAlpha', 'sharpe': 2.1},
            {'name': 'TraderBravo', 'sharpe': 1.8},
            {'name': 'TraderCharlie', 'sharpe': 2.5}
        ]

    def select_top_trader(self):
        top = sorted(self.leaderboard, key=lambda x: x['sharpe'], reverse=True)
        return top[0]

    def execute_copy_trade(self, amount):
        trader = self.select_top_trader()
        decision = random.choice(['buy', 'sell'])
        print(f"[CopyTrader] Copying {trader['name']} decision: {decision} ${amount}")
        return {'trader': trader['name'], 'action': decision, 'amount': amount}
