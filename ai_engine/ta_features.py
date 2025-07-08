
import pandas as pd
import pandas_ta as ta

class TAFeatureExtractor:
    def __init__(self):
        pass

    def generate_features(self, df):
        df['rsi'] = ta.rsi(df['close'], length=14)
        df['atr'] = ta.atr(df['high'], df['low'], df['close'], length=14)
        df['bb_upper'], df['bb_middle'], df['bb_lower'] = ta.bbands(df['close'], length=20, std=2).values.T
        df['ema_20'] = ta.ema(df['close'], length=20)
        df['ema_50'] = ta.ema(df['close'], length=50)
        df['macd'], df['macd_signal'], df['macd_hist'] = ta.macd(df['close']).values.T
        df.dropna(inplace=True)
        return df
