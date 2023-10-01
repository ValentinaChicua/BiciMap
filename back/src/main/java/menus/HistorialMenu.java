package menus;
import  historial.*;

import java.util.Scanner;

public class HistorialMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        historyDynamicStack historial = new historyDynamicStack();

        while (true) {
            System.out.println("Menú de Historial");
            System.out.println("1. Agregar elemento al historial");
            System.out.println("2. Buscar elemento en el historial");
            System.out.println("3. Mostrar historial completo");
            System.out.println("4. Mostrar elemento más reciente");
            System.out.println("5. Salir");

            System.out.print("Ingrese su elección: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar al historial: ");
                    String elemento = scanner.next();
                    historial.pushHistory(elemento);
                    System.out.println("Elemento agregado al historial.");
                    break;

                case 2:
                    System.out.print("Ingrese el elemento a buscar en el historial: ");
                    String elementoBuscar = scanner.next();
                    int index = historial.searchHistory(elementoBuscar);
                    if (index != -1) {
                        System.out.println("Elemento encontrado en el índice " + index + " del historial.");
                    } else {
                        System.out.println("Elemento no encontrado en el historial.");
                    }
                    break;

                case 3:
                    System.out.println("Historial completo: " + historial.toString());
                    break;

                case 4:
                    try {
                        String elementoReciente = historial.returnHistory();
                        System.out.println("Elemento más reciente: " + elementoReciente);
                    } catch (RuntimeException e) {
                        System.out.println("El historial está vacío.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del menú de historial.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}
