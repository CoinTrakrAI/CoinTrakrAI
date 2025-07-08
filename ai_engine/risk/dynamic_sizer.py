
def calculate_position_size(confidence, base_size=1.0):
    if confidence >= 0.9:
        return base_size
    elif confidence >= 0.8:
        return base_size * 0.7
    elif confidence >= 0.7:
        return base_size * 0.4
    else:
        return base_size * 0.1
