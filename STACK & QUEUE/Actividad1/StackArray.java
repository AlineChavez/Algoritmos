package Actividad1;

public class StackArray<E> implements Stack<E> {
	private E[] array;
	private int tope;

	public StackArray(int n) {
		this.array = (E[]) new Object[n];
		this.tope = -1;
	}

	@Override
	public void push(E x) {
		if (isFull()) {
			throw new RuntimeException("La pila está llena");
		}
		array[++tope] = x;
	}

	@Override
	public E pop() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("La pila está vacía");
		}
		return array[tope--];
	}

	@Override
	public E top() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("La pila está vacía");
		}
		return array[tope];
	}

	@Override
	public boolean isEmpty() {
		return tope == -1;
	}

	public boolean isFull() {
		return tope == array.length - 1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Pila: ");
		for (int i = tope; i >= 0; i--) {
			sb.append(array[i]).append(" ");
		}
		return sb.toString();
	}
}
