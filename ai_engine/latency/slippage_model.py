
import random

def predict_slippage(volume, volatility):
    base_slip = 0.001 * volatility
    return round(base_slip + random.uniform(-0.0005, 0.0005), 5)
