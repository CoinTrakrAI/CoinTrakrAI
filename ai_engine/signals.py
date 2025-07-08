import numpy as np
from sklearn.ensemble import GradientBoostingClassifier
from sklearn.preprocessing import StandardScaler
from keras.models import Sequential
from keras.layers import LSTM, Dense

def generate_signals(prices):
    features = np.diff(prices)[-10:]
    X = np.expand_dims(features, axis=0)
    lstm_pred = lstm_model().predict(X)[0][0]
    xgb_score = 0.6  # placeholder for actual score
    buy_score = (lstm_pred + xgb_score) / 2
    return {
        "buy_score": buy_score,
        "sell_score": 1 - buy_score
    }

def lstm_model():
    model = Sequential()
    model.add(LSTM(32, input_shape=(10, 1)))
    model.add(Dense(1, activation='sigmoid'))
    model.compile(optimizer='adam', loss='binary_crossentropy')
    return model

# --- Enhancement: Additional Model Support using r1044_v5_0 ---
import os
import json
import pandas as pd
import pickle

FEATURES_PATH = os.path.join(os.path.dirname(__file__), '../learning_pool/models/r1044_v5_0/r1044_v5_0_features.json')
MODEL_PATH = os.path.join(os.path.dirname(__file__), '../learning_pool/models/r1044_v5_0/r1044_v5_0_meta_model.parquet')

def load_r1044_model():
    model_df = pd.read_parquet(MODEL_PATH)
    return pickle.loads(model_df.iloc[0]['model'])

def extract_r1044_features(live_data_df):
    with open(FEATURES_PATH, 'r') as f:
        features_config = json.load(f)
    selected_features = features_config['feature_sets']['small']
    return live_data_df[selected_features]

def generate_signals_r1044_v5_0(live_data_df):
    model = load_r1044_model()
    X = extract_r1044_features(live_data_df)
    X_scaled = StandardScaler().fit_transform(X)
    pred_prob = model.predict_proba(X_scaled)[0][1]
    return {
        "buy_score": pred_prob,
        "sell_score": 1 - pred_prob,
        "model_version": "r1044_v5_0"
    }

# --- Runtime Toggle Dispatcher ---
import yaml

def get_signals_auto(data):
    config_path = os.path.join(os.path.dirname(__file__), '../config/enhancement.yaml')
    try:
        with open(config_path, 'r') as f:
            cfg = yaml.safe_load(f)
        use_enhanced = cfg.get('use_enhanced_signals', False)
    except Exception:
        use_enhanced = False

    if use_enhanced:
        return generate_signals_r1044_v5_0(data)
    else:
        return generate_signals(data)