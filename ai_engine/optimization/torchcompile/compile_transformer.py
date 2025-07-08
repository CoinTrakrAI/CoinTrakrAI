
import torch
from momentum_transformer import MomentumTransformer

def compile_model():
    model = MomentumTransformer()
    compiled = torch.compile(model)
    return compiled
