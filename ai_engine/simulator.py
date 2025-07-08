
import matplotlib.pyplot as plt

class EnhancedDcaSimulator:
    def __init__(self, historical_prices):
        self.prices = historical_prices

    def run_simulation(self, investment_per_period, frequency_days, panic_threshold=0.2):
        balances = []
        btc_accumulated = 0
        for i in range(0, len(self.prices), frequency_days):
            price = self.prices[i]
            btc_bought = investment_per_period / price
            btc_accumulated += btc_bought
            balance = btc_accumulated * price
            balances.append(balance)
            if len(balances) > 5 and (balance < panic_threshold * max(balances)):
                print("[Simulator] Panic Mode Triggered! Portfolio dropped below threshold.")
                break
        plt.plot(balances)
        plt.title("Enhanced DCA ROI Simulation with Panic Mode")
        plt.xlabel("Periods")
        plt.ylabel("Portfolio Value ($)")
        plt.show()
