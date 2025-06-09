package JGraphTExample;

import org.jgrapht.*;

import org.jgrapht.graph.*;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.*;
import org.jgrapht.traverse.*;

import java.util.*;

public class JGraphTExample {
    public static void main(String[] args) {
        // Crear grafo no dirigido ponderado con String como vértice y DefaultWeightedEdge para aristas
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Agregar vértices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Agregar aristas con pesos
        graph.setEdgeWeight(graph.addEdge("A", "B"), 2);
        graph.setEdgeWeight(graph.addEdge("A", "C"), 4);
        graph.setEdgeWeight(graph.addEdge("B", "D"), 1);
        graph.setEdgeWeight(graph.addEdge("C", "E"), 3);
        graph.setEdgeWeight(graph.addEdge("D", "E"), 5);

        // Mostrar vértices y aristas con pesos
        System.out.println("Vértices del grafo: " + graph.vertexSet());
        System.out.println("Aristas del grafo:");
        for (DefaultWeightedEdge e : graph.edgeSet()) {
            System.out.printf("(%s -- %s) peso=%.1f\n", graph.getEdgeSource(e), graph.getEdgeTarget(e), graph.getEdgeWeight(e));
        }

        // BFS desde "A"
        System.out.println("\nRecorrido BFS desde A:");
        BreadthFirstIterator<String, DefaultWeightedEdge> bfsIterator = new BreadthFirstIterator<>(graph, "A");
        while (bfsIterator.hasNext()) {
            System.out.print(bfsIterator.next() + " ");
        }
        System.out.println();

        // DFS desde "A"
        System.out.println("\nRecorrido DFS desde A:");
        DepthFirstIterator<String, DefaultWeightedEdge> dfsIterator = new DepthFirstIterator<>(graph, "A");
        while (dfsIterator.hasNext()) {
            System.out.print(dfsIterator.next() + " ");
        }
        System.out.println();

        // Camino mínimo con Dijkstra desde A a E
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstra.getPath("A", "E");

        System.out.println("\nCamino más corto (Dijkstra) de A a E:");
        if (path != null) {
            System.out.println("Camino: " + path.getVertexList());
            System.out.println("Peso total: " + path.getWeight());
        } else {
            System.out.println("Nxo hay camino entre A y E.");
        }

        // Grado de un vértice
        System.out.println("\nGrado del vértice B: " + graph.degreeOf("B"));

        // Comprobar si el grafo es conexo
        ConnectivityInspector<String, DefaultWeightedEdge> inspector = new ConnectivityInspector<>(graph);
        System.out.println("¿El grafo es conexo? " + inspector.isConnected());
    }
}
