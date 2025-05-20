package Prueba;

import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public class Test {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();

            // Insertar elementos
            bst.insertar(50);
            bst.insertar(30);
            bst.insertar(70);
            bst.insertar(20);
            bst.insertar(40);
            bst.insertar(60);
            bst.insertar(80);

            // Mostrar recorrido In-Orden
            System.out.println("Recorrido In-Orden:");
            System.out.println(bst.recorridoInOrden()); 

            // Mostrar recorrido Pre-Orden
            System.out.println("Recorrido Pre-Orden:");
            System.out.println(bst.recorridoPreOrden());

            // Mostrar recorrido Post-Orden
            System.out.println("Recorrido Post-Orden:");
            System.out.println(bst.recorridoPostOrden());

            // Mostrar valor mínimo del árbol
            System.out.println("Mínimo del árbol:");
            System.out.println(bst.minimo());

            // Mostrar valor máximo del árbol
            System.out.println("Máximo del árbol:");
            System.out.println(bst.maximo());

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Item no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción general: " + e.getMessage());
        }
    }
}
