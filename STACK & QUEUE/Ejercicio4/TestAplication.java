package Ejercicio4;

import Actividad1.ExceptionIsEmpty;

public class TestAplication {
	public static void main(String[] args) throws ExceptionIsEmpty {
		// Casos de prueba
		System.out.println(Aplication.symbolBalancing("(()()()[()])")); // true
		System.out.println(Aplication.symbolBalancing("(((())))[]")); // true
		System.out.println(Aplication.symbolBalancing("([[]])([]")); // false
		System.out.println(Aplication.symbolBalancing("([[]])")); // true
		System.out.println(Aplication.symbolBalancing("[")); // false
		System.out.println(Aplication.symbolBalancing("[[][[]]{{{{}}}}]")); // true
	}
}
