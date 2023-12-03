package historial;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class historyDynamicStack<T> {
    private int size, top;
    private int capacity = 8;
    private Object[] history;

    public historyDynamicStack() {
        this.history = new Object[capacity];
        size = 0;
        top = 0;
    }

    public List<T> getHistory() {
        List<T> historial = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            historial.add(returnHistory());
        }
        restart();
        return historial;
    }

    public void pushHistory(T data) {
        if (size >= capacity) {
            growHistory();
        }
        history[size] = data;
        size++;
        top++;
    }

    public T searchHistory(T data) {
        for (int i = 0; i < size; i++) {
            if (history[i].equals(data)) {
                return (T) history[i];
            }
        }
        return null;  // O algún valor por defecto si no se encuentra
    }

    private void growHistory() {
        int newCapacity = (int) (capacity * 2);
        Object[] newHistory = new Object[newCapacity];

        System.arraycopy(history, 0, newHistory, 0, size);

        capacity = newCapacity;
        history = newHistory;
    }

    public boolean fullHistory() {
        return size >= history.length;
    }

    public boolean emptyHistory() {
        return size == 0;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            string.append(history[i]).append(", ");
        }
        if (string.length() > 0) {
            string = new StringBuilder("[" + string.substring(0, string.length() - 2) + "]");
        } else {
            string = new StringBuilder("[]");
        }
        return string.toString();
    }

    public T returnHistory() {
        try {
            top--;
            return (T) history[top];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("History is empty");
        }
    }

    public void restart() {
        top = size;
    }

    public void clearHistory() {
        top = 0;
        size = 0;
    }
}


