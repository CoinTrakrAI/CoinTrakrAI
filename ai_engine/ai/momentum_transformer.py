
import torch
import torch.nn as nn

class MomentumTransformer(nn.Module):
    def __init__(self, input_dim=1, seq_len=30, d_model=64, nhead=4, num_layers=2):
        super(MomentumTransformer, self).__init__()
        self.embedding = nn.Linear(input_dim, d_model)
        encoder_layer = nn.TransformerEncoderLayer(d_model=d_model, nhead=nhead)
        self.transformer = nn.TransformerEncoder(encoder_layer, num_layers=num_layers)
        self.decoder = nn.Linear(d_model, 1)

    def forward(self, x):
        x = self.embedding(x)
        x = self.transformer(x)
        return torch.sigmoid(self.decoder(x.mean(dim=1)))
