import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from alpha_vantage.timeseries import TimeSeries

from models.lstm import LSTMModel
from models.markov import MarkovModel
 
def determine_action(predicted_movement):
    if predicted_movement == -1:
        return "Sell"
    elif predicted_movement == 1:
        return "Buy"
    else:
        return "Hold"
 
def fetch_stock_data(symbol):
    api_key = 'BFVHLBYFF0ZKTB84'  # Replace with your Alpha Vantage API key
    ts = TimeSeries(key=api_key, output_format='pandas')
    data, meta_data = ts.get_daily(symbol=symbol, outputsize='compact')
    return data
 
def preprocess_data(data):
    scaler = MinMaxScaler()
    scaled_data = scaler.fit_transform(data.values)
    return scaled_data
 
def on_predict():
    try:
        symbol = symbol_entry.get()
        selected_model = model_var.get()
 
        # Fetch stock price data
        price_data = fetch_stock_data(symbol)
 
        # Preprocess data
        scaled_data = preprocess_data(price_data[['1. open', '2. high', '3. low', '4. close']].iloc[::-1])
 
        # Get last 60 days' data
        last_window = scaled_data[-60:]
 
        if selected_model == "LSTM":
            # Predict next movement with LSTM model
            lstm_predicted_movement = lstm_model.predict_next_movement(last_window)
            lstm_action = determine_action(lstm_predicted_movement)
            label_lstm_predicted_movement.config(text=f"LSTM Predicted Movement: {lstm_predicted_movement}")
            label_lstm_action.config(text=f"LSTM Action to take: {lstm_action}")
        elif selected_model == "Markov":
            # Predict next movement with Markov model
            price_movements = np.sign(price_data['4. close'].diff().dropna().values)
            markov_model = MarkovModel()
            markov_model.fit(price_movements)
            current_movement = price_movements[-1]
            markov_predicted_movement = markov_model.predict_next_movement(current_movement)
            markov_action = determine_action(markov_predicted_movement)
            label_markov_predicted_movement.config(text=f"Markov Predicted Movement: {markov_predicted_movement}")
            label_markov_action.config(text=f"Markov Action to take: {markov_action}")
 
        # Display open, high, low, and close prices
        open_price = price_data['1. open'].iloc[-1]
        high_price = price_data['2. high'].iloc[-1]
        low_price = price_data['3. low'].iloc[-1]
        close_price = price_data['4. close'].iloc[-1]
 
        label_prices.config(text=f"Open: {open_price}, High: {high_price}, Low: {low_price}, Close: {close_price}")
 
    except Exception as e:
        messagebox.showerror("Error", str(e))
 
# Create LSTM model instance
lstm_model = LSTMModel()
 
# Create GUI
root = tk.Tk()
root.title("Stock Prediction")
root.geometry("600x300")
 
 
label_symbol = tk.Label(root, text="Select Stock Symbol:")
label_symbol.pack()
 
symbol_var = tk.StringVar()
symbol_dropdown = ttk.Combobox(root, textvariable=symbol_var, values=['AAPL', 'MSFT', 'GOOGL', 'AMZN', 'TSLA'])
symbol_dropdown.pack()
 
 
label_model = tk.Label(root, text="Select Model:")
label_model.pack()
model_var = tk.StringVar()
model_dropdown = ttk.Combobox(root, textvariable=model_var, values=["LSTM", "Markov"])
model_dropdown.pack()
 
button_predict = tk.Button(root, text="Predict", command=on_predict)
button_predict.pack()
 
label_prices = tk.Label(root, text="")
label_prices.pack()
 
label_lstm_predicted_movement = tk.Label(root, text="")
label_lstm_predicted_movement.pack()
 
label_lstm_action = tk.Label(root, text="")
label_lstm_action.pack()
 
label_markov_predicted_movement = tk.Label(root, text="")
label_markov_predicted_movement.pack()
 
label_markov_action = tk.Label(root, text="")
label_markov_action.pack()
 
root.mainloop()
