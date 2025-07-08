
class RiskPositionSizer:
    def __init__(self, max_risk_pct=0.02):
        self.max_risk_pct = max_risk_pct

    def size_position(self, account_balance, stop_distance):
        risk_amount = account_balance * self.max_risk_pct
        position_size = risk_amount / stop_distance
        print(f"[RiskPositionSizer] New position size: {position_size}")
        return position_size
