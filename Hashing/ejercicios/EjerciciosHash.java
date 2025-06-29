package ejercicios;

import hash.Register;
import hash.HashC;
import hash.HashO;

public class EjerciciosHash {

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Insertar sin colisiones");
        System.out.println("Crea una tabla hash de tamaño 7 para almacenar números enteros.");
        System.out.println("Usa la función hash h(x) = x % 7.");
        System.out.println("Insertar los siguientes valores: 3, 10, 17, 24");
        System.out.println("-----------------------------------------------------");

        HashC tabla1 = new HashC(7);
        tabla1.insert(new Register(3, "valor"));
        tabla1.insert(new Register(10, "valor"));
        tabla1.insert(new Register(17, "valor"));
        tabla1.insert(new Register(24, "valor"));

        System.out.println("Tabla hash final:");
        tabla1.printTable();

        System.out.println("\n-----------------------------------------------------");
        System.out.println("2. Resolver colisiones con sondeo lineal");
        System.out.println("Implementa una tabla hash con tamaño 6 usando hash cerrado (sondeo lineal).");
        System.out.println("Usa h(x) = x % 6.");
        System.out.println("Insertar los siguientes valores: 12, 18, 24, 30");
        System.out.println("Muestra la tabla paso a paso.");
        System.out.println("Explica qué pasa cuando hay una colisión.");
        System.out.println("-----------------------------------------------------");

        HashC tabla2 = new HashC(6);
        tabla2.insert(new Register(12, "valor"));
        tabla2.insert(new Register(18, "valor"));
        tabla2.insert(new Register(24, "valor"));
        tabla2.insert(new Register(30, "valor"));

        System.out.println("Tabla hash final:");
        tabla2.printTable();


        System.out.println("-----------------------------------------------------");
        System.out.println("3. Buscar en hash abierto");
        System.out.println("Dada una tabla hash con encadenamiento (listas enlazadas) de tamaño 5, con los siguientes elementos:");
        System.out.println("Insertar(10, \"Juan\"), Insertar(15, \"Ana\"), Insertar(20, \"Luis\"), Insertar(25, \"Rosa\")");
        System.out.println("Función hash: h(k) = k % 5");
        System.out.println("Buscar la clave 20");
        System.out.println("¿Qué pasa si buscas la clave 30?");
        System.out.println("-----------------------------------------------------");

        HashO tabla3 = new HashO(5);
        tabla3.insert(new Register(10, "Juan"));
        tabla3.insert(new Register(15, "Ana"));
        tabla3.insert(new Register(20, "Luis"));
        tabla3.insert(new Register(25, "Rosa"));

        System.out.println("Buscando clave 20");
        Register r20 = tabla3.search(20);
        System.out.println(r20 != null ? "Encontrado: " + r20.getName() : "No encontrado");

        System.out.println("Buscando clave 30");
        Register r30 = tabla3.search(30);
        System.out.println(r30 != null ? "Encontrado: " + r30.getName() : "No encontrado");


        System.out.println("-----------------------------------------------------");
        System.out.println("4. Eliminar en hash cerrado");
        System.out.println("Usa una tabla hash de tamaño 7 con sondeo lineal.");
        System.out.println("Insertar las claves: 5, 12, 19");
        System.out.println("Eliminar la clave 12");
        System.out.println("Mostrar cómo se comporta la búsqueda de la clave 19 después de eliminar.");
        System.out.println("Explicar diferencia entre eliminación lógica y física.");
        System.out.println("-----------------------------------------------------");

        HashC tabla4 = new HashC(7);
        tabla4.insert(new Register(5, "valor"));
        tabla4.insert(new Register(12, "valor"));
        tabla4.insert(new Register(19, "valor"));

        System.out.println("Tabla antes de eliminar:");
        tabla4.printTable();

        System.out.println("\nEliminando clave 12");
        tabla4.delete(12);

        System.out.println("\nTabla después de eliminar:");
        tabla4.printTable();

        System.out.println("\nBuscando clave 19");
        Register r19 = tabla4.search(19);
        System.out.println(r19 != null ? "Encontrado: " + r19 : " No encontrado");

    }
}
