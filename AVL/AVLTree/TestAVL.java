package AVLTree;

import Exceptions.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            System.out.println("Prueba 1: RSR");
            avl.insert(30);
            avl.insert(20);
            avl.insert(10);

            System.out.println("\nPrueba 2: RSL");
            avl.insert(40);
            avl.insert(50);

            System.out.println("\nPrueba 3: RDR");
            avl.insert(5);
            avl.insert(7);

            System.out.println("\nPrueba 4: RDL");
            avl.insert(60);
            avl.insert(55);

            System.out.println("\nPrueba 5: RSR adicional");
            avl.insert(4);

            System.out.println("\nPrueba 6: RSL adicional");
            avl.insert(70);
            avl.insert(80);

            System.out.println("\nPrueba 7: RDR adicional");
            avl.insert(3);
            avl.insert(2);

            System.out.println("\nPrueba 8: RDL adicional");
            avl.insert(75);
            avl.insert(73);

        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
    }
}
