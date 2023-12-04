package favoritos;

import java.util.ArrayList;
import java.util.List;

public class favoriteDynamicArray<T> {

    private int size;
    private int capacity = 4;
    private T[] favorite;

    public favoriteDynamicArray() {
        this.favorite = (T[]) new Object[capacity];
    }

    public List<T> getFavorites() {
        List<T> favoritesList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            favoritesList.add(favorite[i]);
        }
        return favoritesList;
    }

    public void clearFavorites() {
        // Reiniciar el arreglo y el tamaño
        favorite = (T[]) new Object[capacity];
        size = 0;
    }

    public favoriteDynamicArray(int capacity) {
        this.capacity = capacity;
        this.favorite = (T[]) new Object[capacity];
    }

    public T getFavorites(int index) {
        return favorite[index];
    }



    public void addFavorites(T data) {
        if (size >= capacity) {
            growFavorites();
        }
        favorite[size] = data;
        size++;
    }

    public void insertFavorites(int index, T data) {
        if (size >= capacity) {
            growFavorites();
        }
        for (int i = size; i > index; i--) {
            favorite[i] = favorite[i - 1];
        }
        favorite[index] = data;
        size++;
    }

    public void deleteFavorites(T data) {
        int indexToRemove = -1; // Inicializamos con un valor que indica que no se encontró el elemento
        for (int i = 0; i < size; i++) {
            if (favorite[i].equals(data)) {
                indexToRemove = i; // Almacenamos el índice encontrado
                break;
            }
        }

        if (indexToRemove != -1) { // Verificamos si se encontró el elemento
            for (int j = indexToRemove; j < size - 1; j++) {
                favorite[j] = favorite[j + 1];
            }
            size--;
            if (size <= (int) (capacity / 3)) {
                shrinkFavorites();
            }
        }
    }

    public T searchFavorites(T data) {
        for (int i = 0; i < size; i++) {
            if (favorite[i].equals(data)) {
                return (T) favorite[i];
            }
        }
        return null;  // O algún valor por defecto si no se encuentra
    }

    private void growFavorites() {
        int newCapacity = (int) (capacity * 2);
        T[] newFavorite = (T[]) new Object[newCapacity];

        System.arraycopy(favorite, 0, newFavorite, 0, size);
        capacity = newCapacity;
        favorite = newFavorite;
    }

    private void shrinkFavorites() {
        int newCapacity = (int) (capacity / 2);
        T[] newFavorite = (T[]) new Object[newCapacity];

        System.arraycopy(favorite, 0, newFavorite, 0, size);
        capacity = newCapacity;
        favorite = newFavorite;
    }

    public boolean isEmptyFavorites() {
        return size == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(favorite[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }

        return "[" + stringBuilder.toString() + "]";
    }
}