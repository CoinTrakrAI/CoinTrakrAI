
# Panic mode: Emergency stop and full liquidation
class PanicMode:
    def __init__(self, api):
        self.api = api

    def activate(self):
        holdings = self.api.get_portfolio()
        for asset in holdings:
            if holdings[asset] > 0:
                self.api.sell_all(asset)
        return "All assets liquidated and trading paused."
