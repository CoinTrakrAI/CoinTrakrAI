
import time

def should_execute_signal(last_signal_time, min_interval=60):
    return time.time() - last_signal_time > min_interval
