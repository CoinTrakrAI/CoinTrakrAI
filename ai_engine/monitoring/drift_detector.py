
import numpy as np

def detect_drift(old_mean, new_data, threshold=0.1):
    new_mean = np.mean(new_data)
    return abs(new_mean - old_mean) > threshold
