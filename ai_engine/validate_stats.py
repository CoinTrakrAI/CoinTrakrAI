
import numpy as np
import pandas as pd
from statsmodels.tsa.stattools import adfuller

class StatValidator:
    def __init__(self):
        pass

    def check_stationarity(self, series):
        adf_result = adfuller(series.dropna())
        return {'ADF Statistic': adf_result[0], 'p-value': adf_result[1]}

    def rolling_sharpe(self, returns, window=30):
        mean = returns.rolling(window).mean()
        std = returns.rolling(window).std()
        sharpe = mean / std
        return sharpe
