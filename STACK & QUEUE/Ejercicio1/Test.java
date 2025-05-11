package Ejercicio1;

import Actividad1.ExceptionIsEmpty;

public class Test {
	public static void main(String[] args) throws ExceptionIsEmpty {
		Stack<Integer> pilaenteros = new StackLink<>();
		pilaenteros.push(10);
		pilaenteros.push(20);
		pilaenteros.push(30);
		System.out.println("Pila de enteros: " + pilaenteros.toString());
		System.out.println("Tope: " + pilaenteros.top());
		System.out.println("Pop: " + pilaenteros.pop());
		System.out.println("Pila tras pop: " + pilaenteros.toString());
		Stack<String> pilastrings = new StackLink<>();
		pilastrings.push("Hola");
		pilastrings.push("Mun");
		System.out.println("Pila de strings: " + pilastrings);
	}
}