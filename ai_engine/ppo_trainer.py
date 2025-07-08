
import gym
from stable_baselines3 import PPO

def train_ppo_agent(env_name='CartPole-v1', timesteps=10000):
    env = gym.make(env_name)
    model = PPO('MlpPolicy', env, verbose=1)
    model.learn(total_timesteps=timesteps)
    model.save("ppo_trader_policy.zip")
    print("[PPO] Policy saved as ppo_trader_policy.zip")
