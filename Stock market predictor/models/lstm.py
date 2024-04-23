import numpy as np
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense
 
class LSTMModel:
    def __init__(self, scaler=None):
        self.model = None
        if scaler is None:
            self.scaler = MinMaxScaler()
        else:
            self.scaler = scaler
 
    def fit(self, X_train, y_train):
        # Flatten the input data
        X_train_flat = X_train.reshape(-1, X_train.shape[-1])
 
        # Fit the scaler with training data
        self.scaler.fit(X_train_flat)
 
        # Build and train the LSTM model
        self.model = Sequential()
        self.model.add(LSTM(units=50, return_sequences=True, input_shape=(X_train.shape[1], 4)))
        self.model.add(LSTM(units=50))
        self.model.add(Dense(units=1))
 
        self.model.compile(optimizer='adam', loss='mean_squared_error')
        history = self.model.fit(X_train, y_train, epochs=10, batch_size=1, verbose=2)
        return history
        #First, see how many epochs.
    def predict_next_movement(self, last_window):
        # Transform the input data using the fitted scaler
        scaled_X = self.scaler.transform(last_window.reshape(-1, last_window.shape[-1]))
 
        # Make predictions with the LSTM model
        predicted_movement = self.model.predict(scaled_X.reshape((1, 60, 4)))
        return round(predicted_movement[0][0])
