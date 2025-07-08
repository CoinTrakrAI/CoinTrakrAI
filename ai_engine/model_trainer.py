
import torch
import torch.nn as nn
import torch.optim as optim

class MomentumModel(nn.Module):
    def __init__(self, input_dim, hidden_dim=32):
        super(MomentumModel, self).__init__()
        self.l1 = nn.Linear(input_dim, hidden_dim)
        self.relu = nn.ReLU()
        self.l2 = nn.Linear(hidden_dim, 1)
    
    def forward(self, x):
        x = self.l1(x)
        x = self.relu(x)
        x = self.l2(x)
        return x

def train_momentum_model(X_train, y_train, epochs=100):
    model = MomentumModel(X_train.shape[1])
    criterion = nn.MSELoss()
    optimizer = optim.Adam(model.parameters(), lr=0.001)
    for epoch in range(epochs):
        outputs = model(torch.tensor(X_train, dtype=torch.float32))
        loss = criterion(outputs, torch.tensor(y_train, dtype=torch.float32).unsqueeze(1))
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
        if epoch % 10 == 0:
            print(f"[Trainer] Epoch {epoch}, Loss: {loss.item()}")
    torch.save(model.state_dict(), "momentum_model.pt")
    return model


# partial_fit extension

def partial_fit_momentum(model, X_new, y_new, epochs=10):
    import torch
    import torch.optim as optim
    import torch.nn as nn
    criterion = nn.MSELoss()
    optimizer = optim.Adam(model.parameters(), lr=0.001)
    for epoch in range(epochs):
        outputs = model(torch.tensor(X_new, dtype=torch.float32))
        loss = criterion(outputs, torch.tensor(y_new, dtype=torch.float32).unsqueeze(1))
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
        if epoch % 5 == 0:
            print(f"[PartialFit] Epoch {epoch}, Loss: {loss.item()}")
    torch.save(model.state_dict(), "momentum_model.pt")
    return model
