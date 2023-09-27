package favoritos;

public class favoriteDynamicArray {

    int size;
    int capacity = 4;
    Object[] favorite;

    public favoriteDynamicArray() {
        // Constructor para crear el arreglo favorite con un tamanho por defecto de 4
        this.favorite = new Object[capacity];
    }

    public favoriteDynamicArray(int capacity) {
        // Constructor para crear el arreglo favorite con un tamanho dado por el usuario
        this.capacity = capacity;
        this.favorite = new Object[capacity];
    }

    public Object getFavorites(int index) {
        // Metodo para obtener un elemento en concreto de favoritos a travez de su indice
        return favorite[index];
    }

    public void addFavorites(Object data) {
        // Metodo para anhadir rutas a favoritas cuando el usuario lo requiera
        if (size >= capacity) {
            growFavorites();
        }
        favorite[size] = data;
        size++;
    }

    public void insertFavorites(int index, Object data) {
        // Metodo para inserta una ruta en una posicion espeficica de favoritos dada por el usuario
        if (size >= capacity) {
            growFavorites();
        }
        // Con este for movemos las rutas una casilla a la derecha
        // Liberamos el espacio para la que queramos insertar en esa posicion
        for (int i = size; i > index; i--) {
            favorite[i] = favorite[i - 1];
        }
        favorite[index] = data;
        size++;
    }

    public void deleteFavorites(Object data) {
        // Metodo para eliminar una ruta de favoritos suministrada por el usuario
        for (int i = 0; i < size; i++) {
            if (favorite[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    favorite[i + j] = favorite[i + j + 1];
                }
                favorite[size - 1] = null;
                size--;
                // Si el usuario creo una arreglo demasiado grande y esta ocupando menos de 1/3 de este
                // Reduciremos el tamanho del arreglo a la mitad para no gastar memoria de forma inutil
                // Para esto llamamos al metodo shrinkFavorites();
                if (size <= (int) (capacity / 3)) {
                    shrinkFavorites();
                }
                break;
            }
        }
    }

    public int searchFavorites(Object data) {
        // Metodo para buscar una ruta de favoritos suministrada por el usuario
        for (int i = 0; i < size; i++) {
            if (favorite[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private void growFavorites() {
        // Metodo para aumentar la capacidad del arreglo de forma amortizada una vez se llene
        int newCapacity = (int) (capacity * 2);
        Object[] newFavorite = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newFavorite[i] = favorite[i];
        }
        capacity = newCapacity;
        favorite = newFavorite;
    }

    private void shrinkFavorites() {
        // Metodo para reducir la capcidad del arreglo si se esta usando menos de un 1/3 del espacio de este
        int newCapacity = (int) (capacity / 2);
        Object[] newFavorite = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newFavorite[i] = favorite[i];
        }
        capacity = newCapacity;
        favorite = newFavorite;
    }

    public boolean isEmptyFavorites() {
        return size == 0;
    }

    public String toString() {
        // Este metodo imprime todos los elementos de favoritos separado por comas ", "
        String string = "";

        for (int i = 0; i < capacity; i++) {
            string += favorite[i] + ", ";
        }
        if (string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        } else {
            string = "[]";
        }
        return string;
    }
}