import numpy as np
 
class MarkovModel:
    def __init__(self, order=1):
        self.order = order
        self.transitions = None
        self.classes = None
 
    def fit(self, data):
        unique_classes, indices = np.unique(data, return_inverse=True)
        self.classes = unique_classes
        self.transitions = np.zeros((len(unique_classes), len(unique_classes)))
        for i in range(len(indices) - self.order):
            current_state = indices[i]
            next_state = indices[i + 1]
            self.transitions[current_state, next_state] += 1
        self.transitions = self.transitions / np.sum(self.transitions, axis=1, keepdims=True)
 
    def predict_next_movement(self, current_movement):
        if self.transitions is None:
            raise RuntimeError("Model has not been trained yet.")
        current_state = np.where(self.classes == current_movement)[0][0]
        next_state_probs = self.transitions[current_state]
        next_movement_index = np.argmax(next_state_probs)
        next_movement = self.classes[next_movement_index]
        return next_movement
