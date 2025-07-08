
# Simulated strategy output based on historical patterns
class WhatIfSimulator:
    def simulate(self, strategy, starting_capital=1000, volatility_profile=None):
        result = []
        capital = starting_capital
        for week in range(12):  # simulate 12 weeks
            change = strategy.estimate_weekly_return(volatility_profile)
            capital *= (1 + change)
            result.append(round(capital, 2))
        return result
