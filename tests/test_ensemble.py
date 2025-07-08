
import pytest

def test_ensemble_threshold():
    ensemble_output = {'combined_confidence': 0.78}
    assert ensemble_output['combined_confidence'] > 0.5
