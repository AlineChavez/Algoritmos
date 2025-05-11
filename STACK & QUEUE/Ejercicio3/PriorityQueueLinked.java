package Ejercicio3;

import Actividad1.ExceptionIsEmpty;
import Actividad3.PriorityQueue;

public class PriorityQueueLinked<t> implements PriorityQueue<t, Integer> {
    private QueueLink<t>[] prioridades;
    private int cantidadPrioridades;

    public PriorityQueueLinked(int cantidadPrioridades) {
        this.cantidadPrioridades = cantidadPrioridades;
        prioridades = new QueueLink[cantidadPrioridades];
        for (int i = 0; i < cantidadPrioridades; i++) {
            prioridades[i] = new QueueLink<>();
        }
    }

    public void enqueue(t x, Integer p) {
        if (p < 0 || p >= cantidadPrioridades) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        prioridades[p].enqueue(x);
    }

    public t dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < cantidadPrioridades; i++) {
            if (!prioridades[i].isEmpty()) {
                return prioridades[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public t front() throws ExceptionIsEmpty {
        for (int i = 0; i < cantidadPrioridades; i++) {
            if (!prioridades[i].isEmpty()) {
                return prioridades[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public t back() throws ExceptionIsEmpty {
        for (int i = cantidadPrioridades - 1; i >= 0; i--) {
            if (!prioridades[i].isEmpty()) {
                return prioridades[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public boolean isEmpty() {
        for (QueueLink<t> q : prioridades) {
            if (!q.isEmpty()) return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadPrioridades; i++) {
            sb.append("P").append(i).append(": ").append(prioridades[i]).append("\n");
        }
        return sb.toString();
    }

    public void clear() {
        for (QueueLink<t> q : prioridades) {
            q.clear();
        }
    }
}
