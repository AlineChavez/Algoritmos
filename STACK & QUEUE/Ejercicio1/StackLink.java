package Ejercicio1;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Node;

public class StackLink<E> implements Stack<E> {
	private Node<E> top;
	public StackLink() {
		top = null;
	}
	public void push(E x) {
		Node<E> newnode = new Node<>(x);
		newnode.setNext(top);
		top = newnode;
	}
	public E pop() throws ExceptionIsEmpty {
		if (isempty()) {
			throw new ExceptionIsEmpty("stack vacio....");
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	public E top() throws ExceptionIsEmpty {
		if (isempty()) {
			throw new ExceptionIsEmpty("stack vacio....");
		}
		return top.data;
	}
	public boolean isempty() {
		return top == null;
	}
	public boolean isfull() {
		return false;
	}
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("Pila: ");
	    Node<E> aux = top;
	    while (aux != null) {
	        sb.append(aux.getData()).append(" ");
	        aux = aux.getNext();
	    }
	    return sb.toString();
	}
}