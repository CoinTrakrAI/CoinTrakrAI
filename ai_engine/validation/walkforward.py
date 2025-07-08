
import numpy as np

def walk_forward_validate(model, data, window=50, step=10):
    metrics = []
    for i in range(0, len(data) - window, step):
        train = data[i:i+window]
        test = data[i+window:i+window+step]
        pred = model(train)
        acc = np.random.rand()  # Placeholder for accuracy
        metrics.append(acc)
    return metrics

def monte_carlo_simulate(model, data, simulations=100):
    results = []
    for _ in range(simulations):
        noisy_data = data + np.random.normal(0, 0.01, size=len(data))
        acc = model(noisy_data)
        results.append(acc)
    return results
