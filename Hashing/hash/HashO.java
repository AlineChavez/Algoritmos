package hash;

import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;

    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int pos = hash(reg.getKey());
        table[pos].add(reg);
        System.out.println("Insertado " + reg + " en la posición " + pos);
    }

    public Register search(int key) {
        int pos = hash(key);
        for (Register reg : table[pos]) {
            if (reg.getKey() == key) {
                return reg;
            }
        }
        return null;
    }

    public void delete(int key) {
        int pos = hash(key);
        for (Register reg : table[pos]) {
            if (reg.getKey() == key) {
                table[pos].remove(reg);
                System.out.println("Registro con clave " + key + " eliminado.");
                return;
            }
        }
        System.out.println("Clave " + key + " no encontrada para eliminar.");
    }

    public void printTable() {
        System.out.println("\nContenido de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("vacío");
            } else {
                for (Register reg : table[i]) {
                    System.out.print(reg + " ");
                }
                System.out.println();
            }
        }
    }
}
