package menus;

import  mainPoints.*;

import java.util.Scanner;

public class linkListedPointMenu  {

    private final linkListedPoint linkListedPoint;

    public linkListedPointMenu() {
        this.linkListedPoint = new linkListedPoint();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Puntos Enlazados");
            System.out.println("1. Agregar Punto");
            System.out.println("2. Buscar Punto");
            System.out.println("3. Eliminar Punto");
            System.out.println("4. Mostrar Todos los Puntos");
            System.out.println("5. Salir");

            System.out.print("Ingrese su elección: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la latitud del punto: ");
                    double latitud = scanner.nextDouble();
                    System.out.print("Ingrese la longitud del punto: ");
                    double longitud = scanner.nextDouble();
                    linkListedPoint.push(latitud, longitud);
                    System.out.println("Punto agregado.");
                    break;

                case 2:
                    System.out.print("Ingrese la longitud del punto a buscar: ");
                    double longi = scanner.nextDouble();
                    System.out.print("Ingrese la latitud del punto a buscar: ");
                    double lat = scanner.nextDouble();
                    nodePoint puntoEncontrado = linkListedPoint.find(longi, lat);
                    if (puntoEncontrado != null) {
                        System.out.println("Punto encontrado:");
                        System.out.println("Latitud: " + puntoEncontrado.getLatitude());
                        System.out.println("Longitud: " + puntoEncontrado.getLongitud());
                    } else {
                        System.out.println("Punto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la longitud del punto a eliminar: ");
                    double longiEliminar = scanner.nextDouble();
                    System.out.print("Ingrese la latitud del punto a eliminar: ");
                    double latEliminar = scanner.nextDouble();
                    nodePoint puntoEliminado = linkListedPoint.pop(longiEliminar, latEliminar);
                    if (puntoEliminado != null) {
                        System.out.println("Punto eliminado:");
                        System.out.println("Latitud: " + puntoEliminado.getLatitude());
                        System.out.println("Longitud: " + puntoEliminado.getLongitud());
                    } else {
                        System.out.println("Punto no encontrado o no se pudo eliminar.");
                    }
                    break;

                case 4:
                    System.out.println("Todos los Puntos:");
                    linkListedPoint.print();
                    break;

                case 5:
                    System.out.println("Saliendo del menú de Puntos Enlazados.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        linkListedPointMenu menu = new linkListedPointMenu();
        menu.displayMenu();
    }
}