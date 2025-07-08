import numpy as np
def generate_synthetic_data(length=100):
    base = np.cumsum(np.random.randn(length))
    return base + np.random.normal(0, 1, size=length)