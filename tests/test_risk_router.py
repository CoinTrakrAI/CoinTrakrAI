
import pytest

def test_risk_routing_decision():
    risk_signal = {'adjust_position': True, 'new_size': 0.6}
    assert isinstance(risk_signal['adjust_position'], bool)
    assert 0 <= risk_signal['new_size'] <= 1
