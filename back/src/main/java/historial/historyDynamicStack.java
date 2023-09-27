package historial;

public class historyDynamicStack {
    int size, top;
    int capacity = 8;
    Object[] history;

    public historyDynamicStack() {
        this.history = new Object[capacity];
        size = 0;
        top = 0;
    }

    public Object getHistory(int index) {
        // Metodo para obtener un elemento del historial en concreto a traves de su indice
        return history[index];
    }

    public void pushHistory(Object data) {
        // Metodo para agregar elementos al historial
        // Cada vez que se hace una busqueda de ruta se llama y se guarda
        if (size >= capacity) { //Si nuestro Stack ya esta lleno aumentamos la capacidad
            growHistory();
        }
        history[size] = data;
        size++;
        top++;
    }

    public int searchHistory(Object data) {
        // Para buscar una ruta en el Historial
        for (int i = 0; i < size; i++) {
            if (history[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private void growHistory() {
        // Aumentar la capacidad de la pila de forma amortizada
        int newCapacity = (int) (capacity * 2);
        Object[] newHistory = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newHistory[i] = history[i];
        }
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

        String string = "";
        // Este metodo imprime todos los elementos del historial separado por comas ", "
        for (int i = 0; i < capacity; i++) {
            string += history[i] + ", ";
        }
        if (string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        } else {
            string = "[]";
        }
        return string;
    }

    public String returnHistory() {
        // Devuelve el elemento mas reciente del historial
        // Similar al pop sin embargo aqui no damos la oportunidad de eliminar algo del historial
        // Se puede ejcutar cuantas veces quiera el usuario para ir retornando 1 a 1 los elementos del historial
        try {
            top--;
            return (String) history[top];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("History is empty");
        }
    }

    public void restart() {
        // Reinicia el top despues hacer returnHistory cuantas veces lo requiera el usuario
        top = size;
    }
}

