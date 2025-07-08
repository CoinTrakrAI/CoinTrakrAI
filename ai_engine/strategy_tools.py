
class Backtester:
    def run(self, strategy, data):
        print("[Backtester] Running strategy on data...")
        return {"returns": 12.3, "sharpe": 1.5}

class SignalDashboard:
    def show_signals(self, signals):
        print("[SignalDashboard] Current signals:", signals)

class RiskProfiler:
    def analyze(self, portfolio):
        print("[RiskProfiler] Analyzing portfolio risk...")
        return {"max_drawdown": -5.2, "volatility": 2.3}
