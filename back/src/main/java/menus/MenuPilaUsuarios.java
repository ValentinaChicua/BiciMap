package menus;

import usuarios.PilaUsuarios;

import java.util.Scanner;
import com.example.BiciMap.modelo.Usuarios;

public class MenuPilaUsuarios {

    public static void main(String[] args) {
        PilaUsuarios pilaUsuarios = new PilaUsuarios();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("===== Menú de Usuarios =====");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Leer Usuario en la Cima");
            System.out.println("3. Eliminar Usuario en la Cima");
            System.out.println("4. Obtener Tamaño de la Pila");
            System.out.println("5. Buscar Usuario por Correo Electrónico");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del usuario:");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Correo Electrónico: ");
                    String correoElectronico = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseña = scanner.nextLine();
                    System.out.print("Ubicación Actual: ");
                    String ubicacionActual = scanner.nextLine();
                    System.out.print("Localidad: ");
                    String localidad = scanner.nextLine();

                    Usuarios nuevoUsuario = new Usuarios(nombre, apellido, correoElectronico, contraseña, ubicacionActual, localidad);
                    pilaUsuarios.agregarUsuario(nuevoUsuario);
                    System.out.println("Usuario agregado con éxito.");
                    break;

                case 2:
                    Usuarios usuarioEnCima = pilaUsuarios.leerUsuarioEnCima();
                    if (usuarioEnCima != null) {
                        System.out.println("Usuario en la cima de la pila:");
                        System.out.println(usuarioEnCima);
                    } else {
                        System.out.println("La pila de usuarios está vacía.");
                    }
                    break;

                case 3:
                    Usuarios usuarioEliminado = pilaUsuarios.eliminarUsuarioEnCima();
                    if (usuarioEliminado != null) {
                        System.out.println("Usuario eliminado de la cima de la pila:");
                        System.out.println(usuarioEliminado);
                    } else {
                        System.out.println("La pila de usuarios está vacía.");
                    }
                    break;

                case 4:
                    int tamañoPila = pilaUsuarios.obtenerTamañoPila();
                    System.out.println("Tamaño de la pila de usuarios: " + tamañoPila);
                    break;

                case 5:
                    System.out.print("Ingrese el correo electrónico a buscar: ");
                    String correoBuscar = scanner.nextLine();
                    Usuarios usuarioEncontrado = pilaUsuarios.buscarUsuarioPorCorreo(correoBuscar);
                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado:");
                        System.out.println(usuarioEncontrado);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
