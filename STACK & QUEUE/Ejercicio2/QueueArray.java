package Ejercicio2;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] queue;  
    private int first;  
    private int last;  
    private int size;   
    private int capacity;  

    // Constructor que recibe la capacidad máxima de la cola
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.queue = (E[]) new Object[capacity];  
        this.first = 0;   
        this.last = -1;   
        this.size = 0;   
    }

    // Inserta un elemento al final de la cola
    public void enqueue(E x) {
        if (size == capacity) {
            throw new IllegalStateException("La cola está llena");
        }
        last = (last + 1) % capacity;  // Usamos aritmética modular para manejar el índice
        queue[last] = x;  // Insertamos el elemento
        size++;  // Aumentamos el tamaño
    }

    // Elimina y devuelve el primer elemento de la cola
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = queue[first];  // Guardamos el primer elemento
        first = (first + 1) % capacity;  // Aritmética modular para actualizar el índice
        size--;  // Disminuimos el tamaño
        return data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return queue[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return queue[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Cola: ");
        int i = first;
        for (int j = 0; j < size; j++) {
            sb.append(queue[i]).append(" ");
            i = (i + 1) % capacity;  // Recorre la cola circular
        }
        return sb.toString();
    }
}
