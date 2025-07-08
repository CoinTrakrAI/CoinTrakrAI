
# In-app trade journaling system
import json
from datetime import datetime

class TradeJournal:
    def __init__(self, file_path='journal.json'):
        self.file_path = file_path
        try:
            with open(self.file_path, 'r') as f:
                self.entries = json.load(f)
        except:
            self.entries = []

    def log(self, trade, result, notes=""):
        self.entries.append({
            "timestamp": datetime.utcnow().isoformat(),
            "trade": trade,
            "result": result,
            "notes": notes
        })
        with open(self.file_path, 'w') as f:
            json.dump(self.entries, f, indent=2)
