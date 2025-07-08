
def is_in_alpha_zone(rsi, bollinger_band_width, volume_spike):
    if rsi < 30 or rsi > 70:
        if bollinger_band_width > 0.05 and volume_spike > 1.2:
            return True
    return False
