package Ejercicio3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        PriorityQueueLinked<String> priorityQueue = new PriorityQueueLinked<>(3);
        try {
            priorityQueue.enqueue("uno", 1);
            priorityQueue.enqueue("dos", 2);
            priorityQueue.enqueue("tres", 0);

            System.out.println("Cola de prioridad: ");
            System.out.println(priorityQueue);
            System.out.println("Frente: " + priorityQueue.front());
            System.out.println("Último: " + priorityQueue.back());

            System.out.println("Dequeue: " + priorityQueue.dequeue());
            System.out.println(priorityQueue);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
