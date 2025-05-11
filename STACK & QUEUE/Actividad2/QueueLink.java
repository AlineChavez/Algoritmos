package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;    //APUNTA AL PRIMER NODO
        this.last = null;     //APUNTA AL ULTIMO NODO 
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);   //CREA UN NUEVO NODO 
        if (this.isEmpty()) {          //SI ESTA VACIA EL NUEVO NODO ES EL PRIMERO 
            this.first = aux;
        } else {
            this.last.setNext(aux);    //EL NODO ACTUAL AL FINAL APUNTA AL NUEVO 
        }
        this.last = aux;              //EL NUEVO NODO AHORA ES EL ULTIMO
    }

    public E dequeue() throws ExceptionIsEmpty {             //ELIMINA EL QUE ESTA AL FRENTE
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E dato = this.first.getData();
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return dato;
    }

    public E front() throws ExceptionIsEmpty {                //VER EL PRIMERO
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.first.getData();
    }

    public E back() throws ExceptionIsEmpty {                 //VER EL ULTIMO
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.last.getData();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Cola: ");
        Node<E> aux = first;
        while (aux != null) {
            sb.append(aux.getData()).append(" ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}

