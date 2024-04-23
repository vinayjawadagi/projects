# Created by Ivan Apaza.
import os
import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
import csv
import numpy as np
import tf as tf
from sklearn.preprocessing import MinMaxScaler
from statsmodels.tsa.seasonal import seasonal_decompose
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense
from keras.models import load_model

from models.lstm import LSTMModel
from models.markov import MarkovModel
'''
###################################################
# Data Exploration
###################################################


aapl = pd.read_csv('AAPL.csv',delimiter=',',usecols=['Date','Open','High','Low','Price'])
ivv = pd.read_csv('IVV.csv',delimiter=',',usecols=['Date','Open','High','Low','Price'])
msft = pd.read_csv('MSFT.csv',delimiter=',',usecols=['Date','Open','High','Low','Price'])

print('Loaded data from the csv files')

aapl['Date'] = pd.to_datetime(aapl['Date'], format='%m/%d/%y')
ivv['Date'] = pd.to_datetime(ivv['Date'], format='%m/%d/%y')
msft['Date'] = pd.to_datetime(msft['Date'], format='%m/%d/%y')

aapl=aapl.set_index("Date") #Setting date as index
ivv=ivv.set_index("Date") #Setting date as index
msft=msft.set_index("Date") #Setting date as index


# Double check the result
print("APPL Stats")
print(aapl.describe())

print("IVV Stats")
print(ivv.describe())

print("MSFT Stats")
print(msft.describe())


plt.figure(figsize=(15, 8))

# Plot AAPL data
plt.plot(aapl.index, aapl['Open'], label='AAPL Open', marker='o')
plt.plot(aapl.index, aapl['High'], label='AAPL High', marker='o')
plt.plot(aapl.index, aapl['Low'], label='AAPL Low', marker='o')

# Plot IVV data
plt.plot(ivv.index, ivv['Open'], label='IVV Open', marker='o')
plt.plot(ivv.index, ivv['High'], label='IVV High', marker='o')
plt.plot(ivv.index, ivv['Low'], label='IVV Low', marker='o')

# Plot MSFT data
plt.plot(msft.index, msft['Open'], label='MSFT Open', marker='o')
plt.plot(msft.index, msft['High'], label='MSFT High', marker='o')
plt.plot(msft.index, msft['Low'], label='MSFT Low', marker='o')

plt.xlabel('Date')
plt.ylabel('Price')
plt.title('Stock Prices Over Time')
plt.legend()
plt.grid(True)
plt.show()



###################################################
# Trends
###################################################
# Example data for Apple stock (replace with your actual data)
appl_monthly = aapl['Price'].sort_index()  # Assuming 'Price' represents close prices by week

# Create a list of data points
data_points = np.linspace(0, len(appl_monthly), num=len(appl_monthly))

# Find the coefficients of the linear trendline
line_coef = np.polyfit(data_points, appl_monthly, 1)

# Create a polynomial function based on the coefficients
polynomial = np.poly1d(line_coef)

# Plot the data points and the trendline
fig, ax = plt.subplots(figsize=(12, 8))

# Plot rolling mean
rolling_mean = appl_monthly.rolling(window=5, center=True).mean()
ax.plot(data_points, rolling_mean, label='Rolled Mean')

ax.set_title('Prices per Month')
ax.set_ylabel('Close Price')
ax.set_xlabel('Month')
ax.legend()
plt.show()

'''
###################################################
# Training Model
###################################################

def preprocess_data(data):
    scaler = MinMaxScaler()
    scaled_data = scaler.fit_transform(data.values)
    return scaled_data


symbol_for_training = 'MSFT'
data = pd.read_csv(symbol_for_training + '.csv',delimiter=',',usecols=['Date','Open','High','Low','Price'])
data['Date'] = pd.to_datetime(data['Date'], format='%m/%d/%y')
data=data.set_index("Date") #Setting date as index
data=data.sort_index()
data_points = np.linspace(0, len(data), num=len(data))
'''
# Testing
fig, ax = plt.subplots(figsize=(12, 8))

# Plot rolling mean
rolling_mean_data = data.rolling(window=5, center=True).mean()
ax.plot(data.index, rolling_mean_data)

ax.set_title('Prices (rolling) per Month, [Open, High, Low, Price]')
ax.set_ylabel('Close Price')
ax.set_xlabel('Month')
ax.legend()
plt.show()
'''


scaled_training_data = preprocess_data(data[['Open', 'High', 'Low', 'Price']]) # TO A 0-1 SCALE

'''
fig, ax = plt.subplots(figsize=(12, 8))
ax.plot(data.index, scaled_training_data)
ax.set_title('Scaled data per Month, [Open, High, Low, Price]')
ax.set_ylabel('Scaled Price')
ax.set_xlabel('Month')
ax.legend()
plt.show()
'''




X_train = scaled_training_data[:-1]  # Use all but the last data point for training

y_train = scaled_training_data[:-1, 3] # Up until last month, Price row!

'''
# Plot both X_train and y_train
fig, ax = plt.subplots(figsize=(12, 8))

# Plot X_train features
for i in range(X_train.shape[1]):
    ax.plot(data.index[:-1], X_train[:, i], label=f'Feature {i+1}')

# Plot y_train (next day's closing price)
ax.plot(data.index[1:], y_train, label='Next Day Closing Price', color='black', linestyle='--')

ax.set_title('Training Data')
ax.set_ylabel('Scaled Value')
ax.set_xlabel('Date')
ax.legend()
plt.show()
'''

'''
# 286 data points, 4 inputs.
print("Original shape of X_train:", X_train.shape)
print("Number of samples:", X_train.shape[0])
print("Number of features:", X_train.shape[1])
X_train = np.reshape(X_train, (X_train.shape[0], 1, X_train.shape[1]))  # Reshape data for LSTM input


lstm_model = LSTMModel()
#lstm_model.fit(X_train, y_train)

# Train the LSTM model capturing the training history
history = lstm_model.fit(X_train, y_train)

# Plot the training loss over epochs
plt.plot(history.history['loss'])
plt.title('Model Training Loss')
plt.xlabel('Epoch')
plt.ylabel('Loss')
plt.show()

keras_model = lstm_model.model

# Save the underlying Keras model to disk
keras_model.save(symbol_for_training + "lstm_model.h5")
'''
###################################################
# Retraining and comparing
###################################################

# Data loaded above

actual_outputs = []
predicted_movements = []

# Loop to create and train models for each of the last 12 months
for i in range(12):
    # Prepare data for training (exclude the last 12 months)
    X_train = data[:-13+i]  # Exclude the last 12 months one by one
    y_train = data[1:-12+i]['Price'].values  # Predict the next day's closing price
    X_train = np.reshape(X_train, (X_train.shape[0], 1, X_train.shape[1]))  # Reshape data for LSTM input

    # Create and train the model
    lstm_model = LSTMModel()

    lstm_model.fit(X_train, y_train)

    # Save the trained model
    model_filename = symbol_for_training + f"lstm_model_{i}.h5"
    lstm_model.model.save(model_filename)

    # Load the trained model
    loaded_model = load_model(model_filename)

    # Predict the output for the next month
    X_test = data[13:-12+i]  # Data for the next month
    X_test_scaled = lstm_model.scaler.transform(X_test[['Open', 'High', 'Low', 'Price']].values)
    X_test_reshaped = X_test_scaled.reshape((X_test_scaled.shape[0], 1, X_test_scaled.shape[1]))
    predicted_movement = loaded_model.predict(X_test_reshaped)

    # Compare the predicted output with the actual output for the next month
    actual_output = data.iloc[13+i]['Price']  # Actual output for the next month
    difference = abs(actual_output - predicted_movement[0][0])

    actual_outputs.append(actual_output)
    predicted_movements.append(predicted_movement[0][0])
    print(f"Month {i+1}: Actual Output = {actual_output}, Predicted Output = {predicted_movement[0][0]}, Difference = {difference}")




# Open a CSV file in write mode
with open('predictions.csv', mode='w', newline='') as file:
    # Create a CSV writer object
    writer = csv.writer(file)

    # Write the header row
    writer.writerow(['Month', 'Actual Output', 'Predicted Output'])

    # Loop through each prediction and write it to the CSV file
    for i in range(len(actual_outputs)):
        writer.writerow([i+1, actual_outputs[i], predicted_movements[i]])
