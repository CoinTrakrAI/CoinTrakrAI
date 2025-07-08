
import datetime

def should_run_inference(last_run_time, frequency_minutes=60):
    return (datetime.datetime.now() - last_run_time).total_seconds() / 60 >= frequency_minutes
