package graph;

public class MainGraphListEdge {
   public static void main(String[] args) {
       GraphListEdge<String> grafo = new GraphListEdge<>();
       
       // INSERTAR VÉRTICES
       grafo.insertVertex("A");
       grafo.insertVertex("B");
       grafo.insertVertex("C");
       grafo.insertVertex("D");
       grafo.insertVertex("E");
       
       // INSERTAR ARISTAS
       grafo.insertEdge("A", "B");
       grafo.insertEdge("A", "C");
       grafo.insertEdge("B", "D");
       grafo.insertEdge("C", "E");
       grafo.insertEdge("D", "E");
       
       // BUSCAR VÉRTICES Y ARISTAS
       System.out.println("¿EXISTE EL VÉRTICE C? " + grafo.searchVertex("C"));
       System.out.println("¿EXISTE ARISTA A-B? " + grafo.searchEdge("A", "B"));
       System.out.println("¿EXISTE ARISTA C-D? " + grafo.searchEdge("C", "D"));
       
       // RECORRIDO BFS DESDE A
       System.out.println("\nBFS DESDE A:");
       grafo.bfs("A");
   }
}

