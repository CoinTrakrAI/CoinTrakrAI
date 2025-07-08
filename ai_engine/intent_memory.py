
class IntentMemory:
    def __init__(self):
        self.memory = {}

    def update(self, user_id, topic):
        if user_id not in self.memory:
            self.memory[user_id] = []
        self.memory[user_id].append(topic)
        print(f"[IntentMemory] Updated {user_id} interests: {self.memory[user_id]}")

    def get_interests(self, user_id):
        return self.memory.get(user_id, [])
