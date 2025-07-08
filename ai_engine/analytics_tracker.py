
import time
import traceback

class UserEngagementTracker:
    def __init__(self):
        self.sessions = []
        self.crashes = []

    def start_session(self, user_id):
        session = {'user_id': user_id, 'start_time': time.time()}
        self.sessions.append(session)
        print(f"[Analytics] Session started for user: {user_id}")

    def end_session(self, user_id):
        for s in self.sessions:
            if s['user_id'] == user_id and 'end_time' not in s:
                s['end_time'] = time.time()
                print(f"[Analytics] Session ended for user: {user_id}")

    def log_crash(self, error):
        crash = {'timestamp': time.time(), 'error': str(error), 'trace': traceback.format_exc()}
        self.crashes.append(crash)
        print(f"[Analytics] Crash logged: {error}")
