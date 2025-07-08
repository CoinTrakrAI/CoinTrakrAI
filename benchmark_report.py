import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from ai_engine.simulator import EnhancedDcaSimulator
from ai_engine.ppo_trainer import train_ppo_agent
from ai_engine.model_trainer import train_momentum_model
from ai_engine.validate_stats import StatValidator

# === Generate synthetic BTC-like price data ===
np.random.seed(42)
price_series = np.cumsum(np.random.normal(0, 20, 300)) + 20000

# === 1) Simulate DCA with panic mode ===
sim = EnhancedDcaSimulator(price_series)
sim.run_simulation(500, 7, panic_threshold=0.3)

# === 2) Run PPO agent on simple Gym env ===
train_ppo_agent('CartPole-v1', timesteps=2000)

# === 3) Train your momentum predictor ===
X_train = np.random.rand(200, 5)
y_train = np.random.rand(200)
model = train_momentum_model(X_train, y_train, epochs=10)

# === 4) Validate stats on generated returns ===
returns = pd.Series(np.diff(price_series) / price_series[:-1])
validator = StatValidator()
stationarity = validator.check_stationarity(returns)
rolling_sharpe = validator.rolling_sharpe(returns, window=20)

print("\n==== BENCHMARK REPORT ====")
print(f"ADF stationarity test: p-value = {stationarity['p-value']:.4f}")
print(f"Mean rolling Sharpe (20 periods): {rolling_sharpe.mean():.4f}")
print(f"Max drawdown: {(returns.cumsum() - returns.cumsum().cummax()).min():.4f}")

plt.plot(rolling_sharpe)
plt.title("Rolling Sharpe Ratio (window=20)")
plt.show()
