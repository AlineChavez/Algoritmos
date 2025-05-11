package Actividad3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> queue = new PriorityQueueLinkSort<>();

        try {
            queue.enqueue("Low", 1);
            queue.enqueue("High", 3);
            queue.enqueue("Medium", 2);

            System.out.println(queue);               
            System.out.println("Front: " + queue.front()); 
            System.out.println("Back: " + queue.back());   

            System.out.println("Dequeue: " + queue.dequeue());  
            System.out.println(queue);               

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
