
def apply_meta_labeling(signal_output, volatility, threshold=0.05):
    meta = {}
    if signal_output['buy_score'] > 0.7 and volatility < threshold:
        meta['buy_score'] = signal_output['buy_score']
        meta['sell_score'] = 1 - signal_output['buy_score']
    else:
        meta['buy_score'] = 0.5
        meta['sell_score'] = 0.5
    return meta
