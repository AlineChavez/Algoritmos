package Exceptions;

public class ExceptionIsEmpty extends Exception {      

	public ExceptionIsEmpty(String message) {
		super(message);
	}

	public ExceptionIsEmpty() {
		super("El árbol está vacío.");
	}
}

