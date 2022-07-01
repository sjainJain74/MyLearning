package Graphs_Learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class GraphsAdjList {

	public class Vertex {
		String lebel;

		public Vertex(String label) {
			this.lebel = label;
		}
	}

	public class Edge {
		String from;
		String to;
		int weight;

		public Edge(String from, String to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public String toString() {
			return from + " --> " + to + " | " + weight;

		}

	}

	public Map<String, List<Edge>> map;
	int verteCount;

	public GraphsAdjList(int verteCount) {
		map = new HashMap<String, List<Edge>>();

	}

	public void addEdge(String from, String to, int weight) {
		// adding first time in map and adding 1st Element to linkedlist
		if (map.get(from) == null) {
			map.put(from, new LinkedList<Edge>());
			this.map.get(from).add(new Edge(from, to, weight));
		} else {
			// adding Element to linkedlist
			this.map.get(from).add(new Edge(from, to, weight));
		}
	}

	public List<Edge> getNeighboursForVertex(String vertex) {
		// return map.get(vertex);
		return map.getOrDefault(vertex, new LinkedList<Edge>());

	}

	public List<Edge> getAllEdges() {

		List<Edge> allEdges = new ArrayList();
		List<List<Edge>> values = (List<List<Edge>>) this.map.values();

		for (List<Edge> each : values) {
			allEdges.add((Edge) each);
		}
		return allEdges;

	}

	public void print() {

		for (Entry<String, List<Edge>> key : map.entrySet()) {
			System.out.println("Key " + key.getKey());

			for (Edge eachEdge : key.getValue()) {
				System.out.println(eachEdge.toString());
			}

			// key.getValue().stream().forEach(edge->System.out.println(edge.toString()));
			System.out.println();
		}

	}

	public void bfsTraversal(String startingVertex) {
		// Create a Queue
		// Add zero element and mark visited
		// Add neighbour into queue
		// poll element
		
		Set<String> visisted = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.offer(startingVertex);
		visisted.add(startingVertex);

		while (!q.isEmpty()) {
			List<Edge> neighboursForVertex = getNeighboursForVertex(q.peek());

			for (Edge eachNeighbour : neighboursForVertex) {
				if (!visisted.contains(eachNeighbour.to)) {
					q.offer(eachNeighbour.to);
					visisted.add(eachNeighbour.to);
				}
			}
			System.out.println(q.poll());

		}

	}

}
