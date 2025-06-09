package graph;

import ListLinked.ListLinked;

public class Vertex<E> {
    private E data;   //INFORMACION DEL VERTICE
    protected ListLinked<Edge<E>> listAdj;  //LISTAS DE ADYACENCIA (ARISTAS)

    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<>();
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o) {  //DOS VERTICES SON IGUALES SI SU DATO ES IGUAL
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
}
