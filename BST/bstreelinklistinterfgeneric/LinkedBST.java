package bstreelinklistinterfgeneric;

import java.util.LinkedList;
import java.util.Queue;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Clase interna para representar un nodo del árbol
    private class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;  // Raíz del árbol

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insertar(E data) throws ItemDuplicated {
        root = insertarRec(root, data);
    }

    // Inserta recursivamente respetando el orden del árbol binario
    private Node insertarRec(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertarRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertarRec(node.right, data);
        } else {
            throw new ItemDuplicated("Elemento '" + data + "' duplicado.");
        }

        return node;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        Node found = searchRec(root, data);
        if (found == null) {
            throw new ItemNoFound("Elemento '" + data + "' no encontrado.");
        }
        return found.data;
    }

    // Busca recursivamente el nodo con el dato
    private Node searchRec(Node node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0) return searchRec(node.left, data);
        else if (cmp > 0) return searchRec(node.right, data);
        else return node;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("No se puede eliminar de un árbol vacío.");
        root = deleteRec(root, data);
    }

    // Elimina el nodo correspondiente y reorganiza el árbol si es necesario
    private Node deleteRec(Node node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // Caso: nodo con un solo hijo o sin hijos
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Caso: nodo con dos hijos, se reemplaza por el menor del subárbol derecho
            Node minNode = findMin(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data);
        }

        return node;
    }

    // Encuentra el nodo con el valor mínimo (más a la izquierda)
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

   
    
    
    public String recorridoInOrden() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }
    
    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }
    
    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    public String recorridoPreOrden() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }
    
    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }
    
    public String recorridoPostOrden() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }
    
    private E findMinNode(Node node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("El subárbol está vacío");

        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        // Validamos que el nodo existe usando search()
        return search(current.data);
    }
    
    private E findMaxNode(Node node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("El subárbol está vacío");

        Node current = node;
        while (current.right != null) {
            current = current.right;
        }

        // Validamos que el nodo existe usando search()
        return search(current.data);
    }

    public E minimo() throws ItemNoFound {
        return findMinNode(root);
    }

    public E maximo() throws ItemNoFound {
        return findMaxNode(root);
    }

    // MÉTODO 1: Elimina todos los nodos (vacía el árbol)
    public void destroyNodes() {
        root = null;
    }

    // MÉTODO 2: Cuenta todos los nodos
    public int countAllNodes() {
        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    // MÉTODO 3: Cuenta los nodos a partir de un dato (subárbol con raíz ese dato)
    public int countNodes(E data) throws ItemNoFound {
        Node node = searchRec(root, data);
        if (node == null) throw new ItemNoFound("Nodo con dato " + data + " no encontrado.");
        return countAllNodes(node);
    }

 // Altura del árbol desde un nodo dado (versión iterativa por niveles)
    public int height(E data) throws ItemNoFound {
        Node node = searchRec(root, data); // Buscar el nodo con el dato dado
        if (node == null) throw new ItemNoFound("Nodo con dato " + data + " no encontrado.");

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = -1;

        // Recorrido por niveles 
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++; // Aumenta la altura por cada nivel completo procesado

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);   // Agrega hijo izquierdo
                if (current.right != null) queue.add(current.right); // Agrega hijo derecho
            }
        }
        return height;
    }


 // Devuelve la cantidad de nodos en un nivel dado
    public int amplitude(int level) {
        return amplitude(root, 0, level);
    }

    // Recorrido recursivo para contar nodos en el nivel objetivo
    private int amplitude(Node node, int currentLevel, int targetLevel) {
        if (node == null) return 0; // Si el nodo es nulo, no contribuye
        if (currentLevel == targetLevel) return 1; // Si estamos en el nivel objetivo, contar 1
        // Sumar resultados de los subárboles izquierdo y derecho
        return amplitude(node.left, currentLevel + 1, targetLevel)
             + amplitude(node.right, currentLevel + 1, targetLevel);
    }

    
    public int areaBST() {
        if (root == null) return 0; // Si el árbol está vacío, el área es 0

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int leafCount = 0; // Contador de hojas
        int height = -1;   // Altura del árbol (nivel más profundo)

        // Recorrido por niveles 
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++; // Aumenta por cada nivel del árbol

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Si es hoja, aumentar contador
                if (current.left == null && current.right == null) {
                    leafCount++;
                }

                // Agregar hijos al recorrido
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return leafCount * height; 
    }

    // 02.b) Método drawBST: representación simple del árbol
 // Método que devuelve una representación visual del árbol BST
    public String drawBST() {
        StringBuilder sb = new StringBuilder(); // Acumulador de la estructura visual
        drawBSTHelper(root, sb, "", true);      // Llama al helper desde la raíz
        return sb.toString();                   // Devuelve el árbol dibujado
    }

    // Helper recursivo para construir la estructura visual del árbol
    private void drawBSTHelper(Node node, StringBuilder sb, String prefix, boolean isTail) {
        if (node == null) return; // Caso base: nodo nulo

        // Añade el nodo actual con su prefijo (ramas └── o ├──)
        sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.data).append("\n");

        // Si el nodo tiene al menos un hijo, continúa con ellos
        if (node.left != null || node.right != null) {
            // Si tiene ambos hijos, el izquierdo no es "tail", el derecho sí
            if (node.left != null && node.right != null) {
                drawBSTHelper(node.left, sb, prefix + (isTail ? "    " : "│   "), false);
                drawBSTHelper(node.right, sb, prefix + (isTail ? "    " : "│   "), true);
            }
            // Si solo tiene hijo izquierdo, este es "tail"
            else if (node.left != null) {
                drawBSTHelper(node.left, sb, prefix + (isTail ? "    " : "│   "), true);
            }
            // Si solo tiene hijo derecho, este es "tail"
            else {
                drawBSTHelper(node.right, sb, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
    
 // Devuelve el árbol en forma de paréntesis anidados
    public String parenthesize() {
        StringBuilder sb = new StringBuilder();
        parenthesizeHelper(root, sb, 0);
        return sb.toString();
    }

    // Construye la representación recursivamente con indentación
    private void parenthesizeHelper(Node node, StringBuilder sb, int nivel) {
        if (node == null) return;

        indent(sb, nivel);
        sb.append("(").append(node.data);

        // Nodo hoja: cierra paréntesis y termina
        if (node.left == null && node.right == null) {
            sb.append(")\n");
            return;
        }

        sb.append("\n");

        // Procesa hijo izquierdo o muestra vacío
        if (node.left != null)
            parenthesizeHelper(node.left, sb, nivel + 1);
        else {
            indent(sb, nivel + 1);
            sb.append("()\n");
        }

        // Procesa hijo derecho o muestra vacío
        if (node.right != null)
            parenthesizeHelper(node.right, sb, nivel + 1);
        else {
            indent(sb, nivel + 1);
            sb.append("()\n");
        }

        indent(sb, nivel);
        sb.append(")\n");
    }

    // Añade espacios para la indentación según el nivel
    private void indent(StringBuilder sb, int nivel) {
        for (int i = 0; i < nivel * 2; i++) sb.append(" ");
    }


}

