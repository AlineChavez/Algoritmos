package Nodes;

public class NodeTree<E> {
    public E data;
    public NodeTree<E> left;
    public NodeTree<E> right;

    public NodeTree(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
