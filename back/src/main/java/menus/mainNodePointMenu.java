package menus;

import java.util.Scanner;
import  mainPoints.*;
public class mainNodePointMenu {

    public static void main(String[] args) {
        mainNodePoint linkedList = new mainNodePoint();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar un punto");
            System.out.println("2. Buscar un punto");
            System.out.println("3. Eliminar un punto");
            System.out.println("4. Agregar un punto después de un punto dado");
            System.out.println("5. Imprimir la lista de puntos");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la latitud: ");
                    double latitud = scanner.nextDouble();
                    System.out.print("Ingrese la longitud: ");
                    double longitud = scanner.nextDouble();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.next();
                    linkedList.push(latitud, longitud, nombre);
                    break;
                case 2:
                    System.out.print("Ingrese la longitud: ");
                    double searchLongitud = scanner.nextDouble();
                    System.out.print("Ingrese la latitud: ");
                    double searchLatitud = scanner.nextDouble();
                    System.out.print("Ingrese el nombre: ");
                    String searchNombre = scanner.next();
                    nodePoint foundNode = linkedList.find(searchLongitud, searchLatitud, searchNombre);
                    if (foundNode != null) {
                        System.out.println("Punto encontrado: " + foundNode.getNombre() + " - Longitud: " + foundNode.getLongitud() + " - Latitud: " + foundNode.getLatitude());
                    } else {
                        System.out.println("Punto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la longitud: ");
                    double deleteLongitud = scanner.nextDouble();
                    System.out.print("Ingrese la latitud: ");
                    double deleteLatitud = scanner.nextDouble();
                    System.out.print("Ingrese el nombre: ");
                    String deleteNombre = scanner.next();
                    nodePoint deletedNode = linkedList.pop(deleteLongitud, deleteLatitud, deleteNombre);
                    if (deletedNode != null) {
                        System.out.println("Punto eliminado: " + deletedNode.getNombre() + " - Longitud: " + deletedNode.getLongitud() + " - Latitud: " + deletedNode.getLatitude());
                    } else {
                        System.out.println("Punto no encontrado para eliminar.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del punto después del cual desea agregar: ");
                    String targetNodeNombre = scanner.next();
                    nodePoint targetNode = linkedList.find(0, 0, targetNodeNombre);
                    if (targetNode != null) {
                        System.out.print("Ingrese la latitud del nuevo punto: ");
                        double newLatitud = scanner.nextDouble();
                        System.out.print("Ingrese la longitud del nuevo punto: ");
                        double newLongitud = scanner.nextDouble();
                        System.out.print("Ingrese el nombre del nuevo punto: ");
                        String newNombre = scanner.next();
                        linkedList.AddAfter(targetNode, newLatitud, newLongitud, newNombre);
                        System.out.println("Nuevo punto agregado después de " + targetNodeNombre);
                    } else {
                        System.out.println("El punto con el nombre especificado no se encontró en la lista.");
                    }
                    break;
                case 5:
                    linkedList.print();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

}

