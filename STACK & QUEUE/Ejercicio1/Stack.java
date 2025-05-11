package Ejercicio1;
import Actividad1.ExceptionIsEmpty;
public interface Stack<e> {
	void push(e x);
	e pop() throws ExceptionIsEmpty;
	e top() throws ExceptionIsEmpty;
	boolean isempty();
	boolean isfull();
}