package Ejercicio2;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<String> colaNombres = new QueueArray<>(5);
        Queue<Integer> colaNumeros = new QueueArray<>(3);

        try {
            colaNombres.enqueue("Al");
            colaNombres.enqueue("Ch");
            colaNombres.enqueue("To");

            System.out.println(colaNombres);
            System.out.println("Frente: " + colaNombres.front());
            System.out.println("Final: " + colaNombres.back());

            System.out.println("Dequeue: " + colaNombres.dequeue());
            System.out.println(colaNombres);

            colaNumeros.enqueue(100);
            colaNumeros.enqueue(200);
            System.out.println(colaNumeros);
            System.out.println("Dequeue: " + colaNumeros.dequeue());
            System.out.println("Frente: " + colaNumeros.front());

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage()); // por cola llena
        }
    }
}
