package graph;

public class Edge<E> {
    protected Vertex<E> refDest; //REFERENCIA AL VERTICE DESTINO DE LA ARISTA
    int weight; //PESO DE LA ARISTA

    public Edge(Vertex<E> refDest) { //CONSTRUCTOR ARISTAS SIN PESO
        this(refDest, -1);
    }

    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    public boolean equals(Object o) { //DOS ARISTAS SON IGUALES SI APUNTAN AL MISMO VERTICE
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    public String toString() {
        if (this.weight > -1)
            return refDest.getData() + " [" + this.weight + "], ";
        else
            return refDest.getData() + ", ";
    }
}
