package graph;

import java.util.*;

public class GraphListEdge<T> {
    private List<T> vertices;          // LISTA DE VÉRTICES
    private List<Edge<T>> edges;       // LISTA DE ARISTAS

    public GraphListEdge() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    // INSERTA UN VÉRTICE SI NO EXISTE
    public boolean insertVertex(T v) {
        if (!searchVertex(v)) {
            vertices.add(v);
            return true;
        }
        return false;
    }

    // INSERTA UNA ARISTA ENTRE v Y z SI NO EXISTE Y AMBOS VÉRTICES EXISTEN
    public boolean insertEdge(T v, T z) {
        if (!searchVertex(v) || !searchVertex(z)) {
            System.out.println("ERROR: UNO O AMBOS VÉRTICES NO EXISTEN.");
            return false;
        }
        if (!searchEdge(v, z)) {
            edges.add(new Edge<>(v, z));
            return true;
        }
        return false;
    }

    // BUSCA UN VÉRTICE, RETORNA TRUE SI EXISTE
    public boolean searchVertex(T v) {
        return vertices.contains(v);
    }

    // BUSCA UNA ARISTA ENTRE v Y z, RETORNA TRUE SI EXISTE
    public boolean searchEdge(T v, T z) {
        for (Edge<T> e : edges) {
            if ((e.v1.equals(v) && e.v2.equals(z)) || (e.v1.equals(z) && e.v2.equals(v))) {
                return true;
            }
        }
        return false;
    }

    // RECORRIDO BFS DESDE EL VÉRTICE 'start', MUESTRA VÉRTICES VISITADOS
    public void bfs(T start) {
        if (!searchVertex(start)) {
            System.out.println("EL VÉRTICE INICIAL NO EXISTE.");
            return;
        }

        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            System.out.println("VISITANDO: " + current);

            // RECORREMOS ARISTAS PARA ENCONTRAR VECINOS
            for (Edge<T> e : edges) {
                T neighbor = null;
                if (e.v1.equals(current)) {
                    neighbor = e.v2;
                } else if (e.v2.equals(current)) {
                    neighbor = e.v1;
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // CLASE INTERNA PARA REPRESENTAR UNA ARISTA NO DIRIGIDA
    private static class Edge<T> {
        T v1, v2;

        Edge(T v1, T v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
