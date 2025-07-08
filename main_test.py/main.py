# main_test.py
import numpy as np
from ai_engine.simulator import EnhancedDcaSimulator
from ai_engine.ppo_trainer import train_ppo_agent
from ai_engine.model_trainer import train_momentum_model

# === Test your simulator ===
prices = np.linspace(10000, 30000, 200)
sim = EnhancedDcaSimulator(prices)
sim.run_simulation(500, 7, panic_threshold=0.3)

# === Test your PPO agent on dummy Gym env ===
train_ppo_agent('CartPole-v1', timesteps=1000)

# === Test your momentum trainer ===
X_train = np.random.rand(100, 5)
y_train = np.random.rand(100)
train_momentum_model(X_train, y_train, epochs=5)
