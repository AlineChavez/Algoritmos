package graph;

//import Stack_Queue.Queue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.*;
import ListLinked.ListLinked;

public class GraphLink<E> {
	protected ListLinked<Vertex<E>> listVertex;//LISTA DE TODOS LOS VERTICES DEL GRAFO

	public GraphLink() {
		listVertex = new ListLinked<>();
	}

	public void insertVertex(E data) {
		Vertex<E> vertex = new Vertex<>(data);
		if (!listVertex.search(vertex)) {
			listVertex.insert(vertex);
		}
	}

	public void insertEdge(E verOri, E verDes) {
		Vertex<E> vOri = listVertex.get(listVertex.indexOf(new Vertex<>(verOri)));//BUSCA VERTICE ORIGEN
		Vertex<E> vDes = listVertex.get(listVertex.indexOf(new Vertex<>(verDes)));//BUSCA VERTICE DESTINO

		if (vOri != null && vDes != null) {   
			Edge<E> edge1 = new Edge<>(vDes);  //CREA ARISTAS EN VARIAS DIRECCIONES(NO DIRIGIDO)
			Edge<E> edge2 = new Edge<>(vOri);
			if (!vOri.listAdj.search(edge1)) {
				vOri.listAdj.insert(edge1);
			}
			if (!vDes.listAdj.search(edge2)) {
				vDes.listAdj.insert(edge2);
			}
		}
	}

	public boolean searchVertex(E v) { //SI EXISTE UN VERTICE CON ESE DATO
		return listVertex.search(new Vertex<>(v));
	}

	public boolean searchEdge(E v, E z) { //BUSCA SI HAY UNA ARISTA ENTRE V Y Z
		Vertex<E> v1 = listVertex.get(listVertex.indexOf(new Vertex<>(v)));
		Vertex<E> v2 = listVertex.get(listVertex.indexOf(new Vertex<>(z)));

		if (v1 != null && v2 != null) {
			return v1.listAdj.search(new Edge<>(v2));
		}
		return false;
	}

	public void removeVertex(E v) { //ELIMINA UN VERTICE Y TODAS LAS ARISTAS QUE LO CONECTAN
		Vertex<E> vertex = listVertex.get(listVertex.indexOf(new Vertex<>(v)));
		if (vertex != null) {
			for (int i = 0; i < listVertex.size(); i++) {
				Vertex<E> temp = listVertex.get(i);
				temp.listAdj.remove(new Edge<>(vertex));
			}
			listVertex.remove(vertex);
		}
	}

	public void removeEdge(E v, E z) {//ELIMINBA LA ARISTA ENTRE V Y Z
		Vertex<E> v1 = listVertex.get(listVertex.indexOf(new Vertex<>(v)));
		Vertex<E> v2 = listVertex.get(listVertex.indexOf(new Vertex<>(z)));

		if (v1 != null && v2 != null) {
			v1.listAdj.remove(new Edge<>(v2));
			v2.listAdj.remove(new Edge<>(v1));
		}
	}

	public void dfs(E v) { //RECORRIDO DFS(PROFUNDIDAD) DESDE EL VERTICE V
		boolean[] visited = new boolean[listVertex.size()];
		Vertex<E> start = listVertex.get(listVertex.indexOf(new Vertex<>(v)));
		if (start != null) {
			dfsVisit(start, visited);
		}
	}

	private void dfsVisit(Vertex<E> current, boolean[] visited) { //MARCA VERTICES VISITADOS Y SIGUE RECORRIENDO 
		int index = listVertex.indexOf(current);
		if (index == -1 || visited[index]) return;

		visited[index] = true;
		System.out.print(current.getData() + " ");

		for (int i = 0; i < current.listAdj.size(); i++) {
			Edge<E> edge = current.listAdj.get(i);
			Vertex<E> neighbor = edge.refDest;
			dfsVisit(neighbor, visited);
		}
	}

	public void bfs(E v) { // RECORRIDO BFS (ANCHURA)
	    boolean[] visited = new boolean[listVertex.size()]; // MARCA VÉRTICES VISITADOS

	    Vertex<E> start = listVertex.get(listVertex.indexOf(new Vertex<>(v))); // VÉRTICE DE INICIO

	    if (start == null) return; // SI NO EXISTE, TERMINA

	    Queue<Vertex<E>> queue = new LinkedList<>(); // COLA PARA EL RECORRIDO
	    queue.add(start); 
	    visited[listVertex.indexOf(start)] = true;

	    while (!queue.isEmpty()) {
	        Vertex<E> current = queue.poll(); // OBTIENE SIGUIENTE VÉRTICE
	        System.out.print(current.getData() + " "); // IMPRIME VÉRTICE

	        for (int i = 0; i < current.listAdj.size(); i++) {
	            Vertex<E> neighbor = current.listAdj.get(i).refDest;
	            int index = listVertex.indexOf(neighbor);

	            if (!visited[index]) {
	                visited[index] = true;
	                queue.add(neighbor); // AGREGA VECINOS NO VISITADOS
	            }
	        }
	    }
	}


	public ArrayList<E> bfsPath(E v, E z) { // RUTA MÁS CORTA DE V A Z (BFS)
	    boolean[] visited = new boolean[listVertex.size()]; // MARCA VISITADOS
	    HashMap<Vertex<E>, Vertex<E>> prev = new HashMap<>(); // GUARDA EL CAMINO (PREDECESORES)

	    Vertex<E> start = listVertex.get(listVertex.indexOf(new Vertex<>(v))); // VÉRTICE DE INICIO
	    Vertex<E> end = listVertex.get(listVertex.indexOf(new Vertex<>(z)));   // VÉRTICE FINAL

	    if (start == null || end == null) return null; // SI NO EXISTEN, RETORNA NULO

	    Queue<Vertex<E>> queue = new LinkedList<>(); // COLA PARA BFS
	    queue.add(start);
	    visited[listVertex.indexOf(start)] = true;

	    while (!queue.isEmpty()) {
	        Vertex<E> current = queue.poll(); // SIGUIENTE VÉRTICE EN LA COLA
	        if (current.equals(end)) break; // SI LLEGA AL FINAL, SALE

	        for (int i = 0; i < current.listAdj.size(); i++) {
	            Vertex<E> neighbor = current.listAdj.get(i).refDest;
	            int index = listVertex.indexOf(neighbor);
	            if (!visited[index]) {
	                visited[index] = true;
	                prev.put(neighbor, current); // REGISTRA DE DÓNDE VIENE
	                queue.add(neighbor);
	            }
	        }
	    }

	    ArrayList<E> path = new ArrayList<>(); // RECONSTRUYE EL CAMINO DESDE END A START
	    if (!prev.containsKey(end) && !start.equals(end)) return path; // SIN CAMINO

	    for (Vertex<E> at = end; at != null; at = prev.get(at)) {
	        path.add(0, at.getData()); // AGREGA AL INICIO DE LA LISTA
	        if (at.equals(start)) break;
	    }

	    return path; // DEVUELVE LA RUTA
	}


	public void insertEdgeWeight(E v, E z, int w) {
	    Vertex<E> vOri = listVertex.get(listVertex.indexOf(new Vertex<>(v))); // OBTIENE VÉRTICE ORIGEN
	    Vertex<E> vDes = listVertex.get(listVertex.indexOf(new Vertex<>(z))); // OBTIENE VÉRTICE DESTINO

	    if (vOri != null && vDes != null) { // SI AMBOS EXISTEN
	        Edge<E> edge1 = new Edge<>(vDes, w); // CREA ARISTA ORIGEN->DESTINO
	        Edge<E> edge2 = new Edge<>(vOri, w); // CREA ARISTA DESTINO->ORIGEN (NO DIRIGIDO)

	        if (!vOri.listAdj.search(edge1)) { // SI NO EXISTE LA ARISTA ORIGEN->DESTINO
	            vOri.listAdj.insert(edge1); // INSERTA LA ARISTA
	        } else {
	            int idx = vOri.listAdj.indexOf(edge1);
	            vOri.listAdj.get(idx).weight = w; // ACTUALIZA PESO SI YA EXISTE
	        }

	        if (!vDes.listAdj.search(edge2)) { // LO MISMO PARA DESTINO->ORIGEN
	            vDes.listAdj.insert(edge2);
	        } else {
	            int idx = vDes.listAdj.indexOf(edge2);
	            vDes.listAdj.get(idx).weight = w;
	        }
	    }
	}


	public ArrayList<E> shortPath(E v, E z) {
	    Vertex<E> start = listVertex.get(listVertex.indexOf(new Vertex<>(v))); // VÉRTICE INICIO
	    Vertex<E> end = listVertex.get(listVertex.indexOf(new Vertex<>(z)));   // VÉRTICE FIN
	    if (start == null || end == null) return null;

	    int n = listVertex.size();
	    int[] dist = new int[n];           // DISTANCIAS
	    Vertex<E>[] prev = new Vertex[n];  // PREDECESORES PARA RECONSTRUIR CAMINO
	    boolean[] visited = new boolean[n];// MARCA VÉRTICES VISITADOS

	    final int INF = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) dist[i] = INF;

	    int startIdx = listVertex.indexOf(start);
	    dist[startIdx] = 0;

	    // COLA DE PRIORIDAD POR DISTANCIA MÍNIMA
	    PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[listVertex.indexOf(a)]));
	    pq.add(start);

	    while (!pq.isEmpty()) {
	        Vertex<E> current = pq.poll();
	        int currentIdx = listVertex.indexOf(current);
	        if (visited[currentIdx]) continue;   // YA PROCESADO
	        visited[currentIdx] = true;

	        if (current.equals(end)) break;      // LLEGÓ AL DESTINO

	        for (int i = 0; i < current.listAdj.size(); i++) {
	            Edge<E> edge = current.listAdj.get(i);
	            Vertex<E> neighbor = edge.refDest;
	            int neighborIdx = listVertex.indexOf(neighbor);

	            if (!visited[neighborIdx] && edge.weight >= 0) {
	                int newDist = dist[currentIdx] + edge.weight;
	                if (newDist < dist[neighborIdx]) { // ACTUALIZA SI MEJOR DISTANCIA
	                    dist[neighborIdx] = newDist;
	                    prev[neighborIdx] = current;
	                    pq.add(neighbor);
	                }
	            }
	        }
	    }

	    // RECONSTRUCCIÓN DEL CAMINO DESDE END A START
	    ArrayList<E> path = new ArrayList<>();
	    if (dist[listVertex.indexOf(end)] == INF) return path; // SIN RUTA

	    for (Vertex<E> at = end; at != null; at = prev[listVertex.indexOf(at)]) {
	        path.add(0, at.getData());
	        if (at.equals(start)) break;
	    }
	    return path;
	}

	public boolean isConexo() {
	    if (listVertex.size() == 0) return true; // GRAFO VACÍO SE CONSIDERA CONEXO

	    boolean[] visited = new boolean[listVertex.size()];
	    Vertex<E> start = listVertex.get(0); // INICIA DESDE EL PRIMER VÉRTICE

	    dfsVisit(start, visited); // RECORRIDO DFS PARA MARCAR VÉRTICES VISITADOS

	    for (boolean v : visited) {
	        if (!v) return false; // SI HAY ALGÚN VÉRTICE NO VISITADO, NO ES CONEXO
	    }
	    return true; // TODOS LOS VÉRTICES FUERON VISITADOS, ES CONEXO
	}

	public Stack<E> Dijkstra(E v, E w) {
	    ArrayList<E> path = shortPath(v, w); // OBTIENE RUTA MÁS CORTA
	    Stack<E> stackPath = new Stack<>();  // USA PILA PARA GUARDAR LA RUTA
	    for (E vertex : path) {
	        stackPath.push(vertex);          // AGREGA VÉRTICES A LA PILA
	    }
	    return stackPath;                    // RETORNA LA PILA
	}

	// Grado del vértice
	public int grado(E data) {
	    Vertex<E> v = listVertex.get(listVertex.indexOf(new Vertex<>(data)));
	    if (v == null) return -1;
	    return v.listAdj.size();
	}

	// Verifica si hay un camino Px de longitud x (camino simple)
	public boolean esCaminoPx(ArrayList<E> camino) {
	    if (camino.size() < 2) return false;

	    for (int i = 0; i < camino.size() - 1; i++) {
	        if (!searchEdge(camino.get(i), camino.get(i + 1))) return false;
	    }

	    Set<E> nodosUnicos = new HashSet<>(camino);
	    return nodosUnicos.size() == camino.size(); // sin repetidos
	}

	// Verifica si es un ciclo Cx de longitud x
	public boolean esCicloCx(ArrayList<E> ciclo) {
	    if (ciclo.size() < 3) return false;
	    if (!ciclo.get(0).equals(ciclo.get(ciclo.size() - 1))) return false;

	    for (int i = 0; i < ciclo.size() - 1; i++) {
	        if (!searchEdge(ciclo.get(i), ciclo.get(i + 1))) return false;
	    }

	    Set<E> nodosInternos = new HashSet<>(ciclo.subList(0, ciclo.size() - 1));
	    return nodosInternos.size() == ciclo.size() - 1; // sin repetir excepto inicio/fin
	}

	// Verifica si el conjunto de nodos forma una rueda Wx
	public boolean esRuedaWx(ArrayList<E> nodos) {
	    if (nodos.size() < 4) return false;

	    E centro = nodos.get(0); // Nodo central
	    List<E> perifericos = nodos.subList(1, nodos.size());

	    // El centro debe estar conectado a todos los periféricos
	    for (E p : perifericos) {
	        if (!searchEdge(centro, p)) return false;
	    }

	    // Verificar que los periféricos formen un ciclo
	    ArrayList<E> ciclo = new ArrayList<>(perifericos);
	    ciclo.add(perifericos.get(0));
	    return esCicloCx(ciclo);
	}

	// Verifica si el grafo es completo Kx
	public boolean esCompleto() {
	    int n = listVertex.size();
	    for (int i = 0; i < n; i++) {
	        Vertex<E> vi = listVertex.get(i);
	        for (int j = i + 1; j < n; j++) {
	            Vertex<E> vj = listVertex.get(j);
	            if (!vi.listAdj.search(new Edge<>(vj)) || !vj.listAdj.search(new Edge<>(vi))) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	   private class Vertice {
	        E data;
	        List<Vertice> adj;

	        Vertice(E data) {
	            this.data = data;
	            this.adj = new LinkedList<>();
	        }
	    }

	    private List<Vertice> verticesListAdj;

	    
	public String toString() {
		return this.listVertex.toString();
	}
}
