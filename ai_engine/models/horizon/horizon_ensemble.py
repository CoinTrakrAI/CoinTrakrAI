
def aggregate_horizons(short, medium, long):
    if short == medium == long:
        return short
    return "HEDGE"  # Conflicting signals
