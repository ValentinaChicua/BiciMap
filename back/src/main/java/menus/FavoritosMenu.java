package menus;
import favoritos.*;


import java.util.Scanner;

public class FavoritosMenu {

    public static void main(String[] args) {
        favoriteDynamicArray favoritos = new favoriteDynamicArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Favoritos:");
            System.out.println("1. Mostrar Favoritos");
            System.out.println("2. Agregar Favorito");
            System.out.println("3. Insertar Favorito");
            System.out.println("4. Eliminar Favorito");
            System.out.println("5. Buscar Favorito");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Favoritos: " + favoritos.toString());
                    break;
                case 2:
                    System.out.print("Ingrese el favorito a agregar: ");
                    String favoritoAgregar = scanner.nextLine();
                    favoritos.addFavorites(favoritoAgregar);
                    System.out.println("Favorito agregado.");
                    break;
                case 3:
                    System.out.print("Ingrese la posición de inserción: ");
                    int posicionInsercion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el favorito a insertar: ");
                    String favoritoInsertar = scanner.nextLine();
                    favoritos.insertFavorites(posicionInsercion, favoritoInsertar);
                    System.out.println("Favorito insertado.");
                    break;
                case 4:
                    System.out.print("Ingrese el favorito a eliminar: ");
                    String favoritoEliminar = scanner.nextLine();
                    favoritos.deleteFavorites(favoritoEliminar);
                    System.out.println("Favorito eliminado.");
                    break;
                case 5:
                    System.out.print("Ingrese el favorito a buscar: ");
                    String favoritoBuscar = scanner.nextLine();
                    int posicion = favoritos.searchFavorites(favoritoBuscar);
                    if (posicion != -1) {
                        System.out.println("Favorito encontrado en la posición " + posicion);
                    } else {
                        System.out.println("Favorito no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}

