
import torch

def predict_with_uncertainty(model, x, n_iter=10):
    model.train()  # keep dropout active
    preds = [model(x).detach().numpy() for _ in range(n_iter)]
    mean = sum(preds) / len(preds)
    std = (sum((p - mean)**2 for p in preds) / len(preds))**0.5
    return float(mean), float(std)
