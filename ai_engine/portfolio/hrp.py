
import numpy as np
import pandas as pd
from scipy.cluster.hierarchy import linkage, dendrogram

def allocate_hrp(returns: pd.DataFrame):
    corr = returns.corr()
    dist = ((1 - corr) / 2) ** 0.5
    link = linkage(dist, 'single')
    weights = pd.Series(1. / returns.shape[1], index=returns.columns)
    return weights.to_dict()
