
class MemoryBuffer:
    def __init__(self, max_len=1000):
        self.buffer = []
        self.max_len = max_len

    def store(self, signal, result):
        self.buffer.append((signal, result))
        if len(self.buffer) > self.max_len:
            self.buffer.pop(0)

    def get_success_rate(self):
        if not self.buffer:
            return 0.5
        return sum(1 for _, r in self.buffer if r) / len(self.buffer)
