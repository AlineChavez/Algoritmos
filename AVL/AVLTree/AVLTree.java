package AVLTree;

import BinarySearchTree.LinkedBST;
import Exceptions.ItemDuplicated;
import Nodes.NodeAVL;
import Nodes.NodeTree;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    private boolean height;

    public void insert(E x) throws ItemDuplicated {
        height = false;
        this.root = insert(x, (NodeAVL<E>) this.root);
    }

    protected NodeTree<E> insert(E x, NodeAVL<E> node) throws ItemDuplicated {
        NodeAVL<E> fat = node;

        if (node == null) {
            height = true;
            return new NodeAVL<>(x);
        }

        int resC = x.compareTo(node.data);

        if (resC == 0) {
            throw new ItemDuplicated(x + " ya se encuentra en el arbol");
        }

        if (resC < 0) {
            fat.left = insert(x, (NodeAVL<E>) node.left);

            if (height) {
                switch (fat.bf) {
                    case 1:
                        fat.bf = 0;
                        height = false;
                        break;
                    case 0:
                        fat.bf = -1;
                        height = true;
                        break;
                    case -1:
                        fat = balanceIzquierda(fat);
                        height = false;
                        break;
                }
            }
        } else {
            fat.right = insert(x, (NodeAVL<E>) node.right);

            if (height) {
                switch (fat.bf) {
                    case -1:
                        fat.bf = 0;
                        height = false;
                        break;
                    case 0:
                        fat.bf = 1;
                        height = true;
                        break;
                    case 1:
                        fat = balanceDerecha(fat);
                        height = false;
                        break;
                }
            }
        }

        return fat;
    }

    private NodeAVL<E> balanceIzquierda(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.left;

        if (hijo.bf == -1) {
            node.bf = 0;
            hijo.bf = 0;
            System.out.println("Rotación Simple Derecha (balanceIzquierda) en nodo: " + node.data);
            node = rotacionDerecha(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.right;

            switch (nieto.bf) {
                case -1:
                    node.bf = 1;
                    hijo.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case 1:
                    node.bf = 0;
                    hijo.bf = -1;
                    break;
            }

            if (nieto != null) nieto.bf = 0;
            System.out.println("Rotación Doble Izquierda-Derecha (balanceIzquierda) en nodo: " + node.data);
            node.left = rotacionIzquierda(hijo);
            node = rotacionDerecha(node);
        }

        return node;
    }

    private NodeAVL<E> balanceDerecha(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.right;

        if (hijo.bf == 1) {
            node.bf = 0;
            hijo.bf = 0;
            System.out.println("Rotación Simple Izquierda (balanceDerecha) en nodo: " + node.data);
            node = rotacionIzquierda(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.left;

            switch (nieto.bf) {
                case 1:
                    node.bf = -1;
                    hijo.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case -1:
                    node.bf = 0;
                    hijo.bf = 1;
                    break;
            }

            if (nieto != null) nieto.bf = 0;
            System.out.println("Rotación Doble Derecha-Izquierda (balanceDerecha) en nodo: " + node.data);
            node.right = rotacionDerecha(hijo);
            node = rotacionIzquierda(node);
        }

        return node;
    }

    private NodeAVL<E> rotacionIzquierda(NodeAVL<E> node) {
        NodeAVL<E> p = (NodeAVL<E>) node.right;
        node.right = p.left;
        p.left = node;
        System.out.println("Rotación Izquierda en nodo: " + node.data + " -> Nuevo nodo raíz: " + p.data);
        return p;
    }

    private NodeAVL<E> rotacionDerecha(NodeAVL<E> node) {
        NodeAVL<E> p = (NodeAVL<E>) node.left;
        node.left = p.right;
        p.right = node;
        System.out.println("Rotación Derecha en nodo: " + node.data + " -> Nuevo nodo raíz: " + p.data);
        return p;
    }
}