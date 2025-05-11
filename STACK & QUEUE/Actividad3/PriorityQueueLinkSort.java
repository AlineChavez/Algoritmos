package Actividad3;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Node;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    // Nodo que almacena el dato y la prioridad
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    // Método para insertar un elemento en la cola de prioridad
    public void enqueue(E x, N pr) {
        EntryNode newNode = new EntryNode(x, pr);
        Node<EntryNode> newNodeRef = new Node<>(newNode);

        if (isEmpty() || this.first.getData().priority.compareTo(pr) < 0) {
            // Si está vacío o la prioridad es mayor que el primer nodo
            newNodeRef.setNext(first);
            first = newNodeRef;
            if (last == null) {
                last = first; // si la cola estaba vacía, el último nodo es también el primero
            }
        } else {
            Node<EntryNode> current = first;
            while (current.getNext() != null && current.getNext().getData().priority.compareTo(pr) >= 0) {
                current = current.getNext();
            }
            newNodeRef.setNext(current.getNext());
            current.setNext(newNodeRef);
            if (current.getNext() == null) {
                last = newNodeRef;
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cannot remove from an empty queue");

        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return aux;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cannot access the back from an empty queue");
        return this.last.getData().data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cannot access the front from an empty queue");
        return this.first.getData().data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    // Mostrar los elementos de la cola en el orden de prioridad
    public String toString() {
        StringBuilder sb = new StringBuilder("Priority Queue: ");
        Node<EntryNode> aux = first;
        while (aux != null) {
            sb.append(aux.getData().data).append(" ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}
