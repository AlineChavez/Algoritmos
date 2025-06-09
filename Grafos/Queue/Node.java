package Queue;


public class Node<E> {  //NODE REPRESENTA CADA ELEMENTO DE UNA LISTA ENLAZADA
    public E data;         //GUARDA VALOR DEL NODO
    public Node<E> next;   //GUARDA LA REFERENCIA DEL SIGUIENTE NODO DE LA LISTA SI NO HAY ES EL ULTIMO NODO

    public Node(E data) {
        this.data = data;
        this.next = null;    //ES NULO PORQUE AL CREARLO NO APUNTO A NINGUN OTRO NODO
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {		//PARA ASIGNAR EL SIGUIENTE NODO (CREA LA CONEXION ENTRE ESTE NODO Y EL SIGUIENTE)
        this.next = next;
    }
}

