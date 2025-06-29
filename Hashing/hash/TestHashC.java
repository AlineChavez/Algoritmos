package hash;

import java.util.Scanner;

public class TestHashC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashC tabla = new HashC(10);

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar registro");
            System.out.println("2. Buscar registro por clave");
            System.out.println("3. Eliminar registro por clave");
            System.out.println("4. Mostrar tabla hash");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Clave (int): ");
                    int clave = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    tabla.insert(new Register(clave, nombre));
                    break;
                case 2:
                    System.out.print("Clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    Register encontrado = tabla.search(claveBuscar);
                    if (encontrado != null) {
                        System.out.println("Registro encontrado: " + encontrado);
                    } else {
                        System.out.println("Clave no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    tabla.delete(claveEliminar);
                    break;
                case 4:
                    System.out.println("Estado actual de la tabla hash:");
                    tabla.printTable();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
