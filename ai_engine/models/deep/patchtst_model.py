
import torch.nn as nn

class PatchTST(nn.Module):
    def __init__(self, input_dim=1, output_dim=1, patch_len=16):
        super().__init__()
        self.encoder = nn.Sequential(
            nn.Conv1d(input_dim, 64, kernel_size=patch_len, stride=patch_len),
            nn.ReLU(),
            nn.Flatten(),
            nn.Linear(64, output_dim)
        )

    def forward(self, x):
        return self.encoder(x)
