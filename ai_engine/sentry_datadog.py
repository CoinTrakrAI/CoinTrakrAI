
import sentry_sdk
from datadog import initialize, statsd

def setup_sentry(dsn):
    sentry_sdk.init(dsn)
    print("[Monitoring] Sentry initialized.")

def setup_datadog(api_key):
    options = {'api_key': api_key}
    initialize(**options)
    print("[Monitoring] Datadog initialized.")

def log_event_to_datadog(metric, value):
    statsd.gauge(metric, value)
