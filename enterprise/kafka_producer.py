
from kafka import KafkaProducer
import json

class KafkaTradeProducer:
    def __init__(self, bootstrap_servers='localhost:9092'):
        self.producer = KafkaProducer(bootstrap_servers=bootstrap_servers,
                                      value_serializer=lambda v: json.dumps(v).encode('utf-8'))

    def send_trade(self, topic, trade_data):
        self.producer.send(topic, trade_data)
        self.producer.flush()
