
import torch.onnx
from momentum_transformer import MomentumTransformer

def export_model_to_onnx():
    model = MomentumTransformer()
    dummy_input = torch.randn(1, 30, 1)
    torch.onnx.export(model, dummy_input, "momentum_transformer.onnx")
