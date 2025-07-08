
class SignalScorer:
    def __init__(self):
        self.history = {}

    def update(self, model_name, success):
        if model_name not in self.history:
            self.history[model_name] = []
        self.history[model_name].append(success)
        if len(self.history[model_name]) > 50:
            self.history[model_name].pop(0)

    def score(self, model_name):
        if model_name not in self.history or not self.history[model_name]:
            return 0.5
        return sum(self.history[model_name]) / len(self.history[model_name])
