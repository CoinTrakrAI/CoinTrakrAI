
import pytest

def test_agent_signal_structure():
    sample_signal = {'type': 'buy', 'confidence': 0.85}
    assert 'type' in sample_signal
    assert 'confidence' in sample_signal
    assert sample_signal['type'] in ['buy', 'sell']
    assert 0 <= sample_signal['confidence'] <= 1
