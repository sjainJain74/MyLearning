package Graphs_Learning;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphAdjListPractise {

	Map<Vertex, LinkedList<Edge>> map;
	Integer vertexCount;
	// private LinkedList<Edge> new Edge(start, end, weight);

	public GraphAdjListPractise() {
		map = new HashMap<>();

	}

	public void addEdge(Vertex start, Vertex end, Integer weight) {

		// if vertex if missing
		if (map.get(start).isEmpty()) {
			map.put(start, new LinkedList<Edge>());
			map.get(start).add(new Edge(start, end, weight));
		} else {
			// Go to the map key where we have the
			map.get(start).add(new Edge(start, end, weight));

		}

	}
	
	public void allEdges () {}

	public class Vertex {
		String name;

		public Vertex(String name) {
			this.name = name;
		}

	}

	public class Edge {
		private Vertex start;
		private Vertex end;
		Integer weight;

		// Constructor for Edge
		public Edge(Vertex start, Vertex end, Integer weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;

		}
	}

}
