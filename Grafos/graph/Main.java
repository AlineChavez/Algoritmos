package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GraphLink<String> grafoLink = new GraphLink<>();

        // Insertar vértices
        grafoLink.insertVertex("A");
        grafoLink.insertVertex("B");
        grafoLink.insertVertex("C");
        grafoLink.insertVertex("D");
        grafoLink.insertVertex("E");

        // Insertar aristas
        grafoLink.insertEdge("A", "B");
        grafoLink.insertEdge("A", "C");
        grafoLink.insertEdge("B", "D");
        grafoLink.insertEdge("C", "E");
        grafoLink.insertEdge("D", "E");

        // Operaciones básicas
        System.out.println("¿Existe el vértice C? " + grafoLink.searchVertex("C"));
        System.out.println("¿Existe la arista A-B? " + grafoLink.searchEdge("A", "B"));
        System.out.println("¿Existe la arista C-D? " + grafoLink.searchEdge("C", "D"));

        System.out.println("\nDFS desde A:");
        grafoLink.dfs("A");

        System.out.println("\nBFS desde A:");
        grafoLink.bfs("A");

        // Grado de un vértice
        System.out.println("\nGrado del vértice C: " + grafoLink.grado("C")); // Esperado: 2

        // Camino Px
        ArrayList<String> camino = new ArrayList<>(Arrays.asList("A", "C", "E"));
        System.out.println("\n¿Camino Px (A-C-E)? " + grafoLink.esCaminoPx(camino));

        // Ciclo Cx
        ArrayList<String> ciclo = new ArrayList<>(Arrays.asList("C", "E", "D", "B", "A", "C")); // no existe
        System.out.println("¿Ciclo Cx (C-E-D-B-A-C)? " + grafoLink.esCicloCx(ciclo));

        // Rueda Wx: requiere un nodo central conectado a todos y los periféricos conectados en ciclo
        ArrayList<String> rueda = new ArrayList<>(Arrays.asList("C", "A", "B", "E")); // no es válida
        System.out.println("¿Rueda Wx (C centro)? " + grafoLink.esRuedaWx(rueda));

        // Completo Kx
        System.out.println("¿Es completo (Kx)? " + grafoLink.esCompleto());
    }
}
