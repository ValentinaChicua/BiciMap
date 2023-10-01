package rutasFrecuentes;

public class frequentDynamicArray {
    public int size;

    int capacity = 4;
    Object[] frequent;

    public frequentDynamicArray() {
        //Constructor para crear el arreglo frequent con un tamanho por defecto de 4
        this.frequent = new Object[capacity];
    }

    public Object getFrequent(int index) {
        // Metodo para obtener un elemento en concreto de favoritos a travez de su indice
        return frequent[index];
    }

    public void addFrequent(Object data) {
        // Metodo para anhadir las rutas mas frecuentes del usuario
        if(size >= capacity) {
            growFrequent();
        }
        frequent[size] = data;
        size++;
    }

/*    public void insertFrequent(int index, Object data) {
        // Metodo para inserta una ruta en una posicion espeficica
        if(size >= capacity) {
            growFrequent();
        }
        // Con este for movemos las rutas una casilla a la derecha
        // Liberamos el espacio para la que queramos insertar en esa posicion
        for(int i = size; i > index; i--) {
            frequent[i] = frequent[i - 1];
        }
        frequent[index] = data;
        size++;
    }*/

    public void deleteFrequent(Object data) {
        // Metodo para eliminar una ruta de frecuentes suministrada por el usuario
        for(int i = 0; i < size; i++) {
            if(frequent[i] == data) {
                for(int j = 0; j < (size - i - 1); j++){
                    frequent[i + j] = frequent[i + j + 1];
                }
                frequent[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public int searchFrequent(Object data) {
        // Metodo para buscar una ruta de frecuentes suministrada por el usuario
        for(int i = 0; i < size; i++) {
            if(frequent[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private void growFrequent() {
        // Metodo para aumentar la capacidad del arreglo de forma amortizada una vez se llene
        int newCapacity = (int)(capacity * 2);
        Object[] newFrequent = new Object[newCapacity];

        for(int i = 0; i < size; i++) {
            newFrequent[i] = frequent[i];
        }
        capacity = newCapacity;
        frequent = newFrequent;
    }

    public boolean isEmptyFrequent() {
        return size == 0;
    }

    public String toString() {
        // Este metodo imprime todos los elementos de frecuentes separado por comas ", "
        String string = "";

        for(int i = 0; i < capacity; i++) {
            string += frequent[i] + ", ";
        }
        if(string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        }
        else {
            string = "[]";
        }
        return string;
    }
}