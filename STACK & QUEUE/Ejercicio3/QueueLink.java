package Ejercicio3;

import Actividad1.ExceptionIsEmpty;

public class QueueLink<t> {
    private static class Node<t> {
        t data;
        Node<t> next;

        Node(t data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<t> front;
    private Node<t> rear;
    private int size;

    public QueueLink() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(t item) {
        Node<t> newNode = new Node<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public t dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        t item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public t front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return front.data;
    }

    public t back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        front = rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<t> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
