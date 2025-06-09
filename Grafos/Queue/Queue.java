package Queue;


import Exception.ExceptionIsEmpty;

public interface Queue<E> {
	void enqueue(E x);                   //INSERTAR UN ELEMENTO AL FINAL DE LA COLA   
	E dequeue() throws ExceptionIsEmpty; //ELIMINA Y DEVUELVE EL PRIMER ELEMENTO DE LA COLA 
	E front() throws ExceptionIsEmpty;   //SOLO MUESTRA EL PRIMER ELEMENTO
	E back() throws ExceptionIsEmpty;    //VER EL ULTIMO ELEMENTO AGREGADO
	boolean isEmpty();                     
}

