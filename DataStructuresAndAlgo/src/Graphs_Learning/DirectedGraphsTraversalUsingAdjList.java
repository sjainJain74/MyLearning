package Graphs_Learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Graphs_Learning.GraphsAdjList.Edge;

public class DirectedGraphsTraversalUsingAdjList {

	public static void main(String arg[]) {
		int v = 6; // Number of nodes
		GraphsAdjList graph = new GraphsAdjList(v);

		// From Zero
		graph.addEdge("0", "1", 4);
		graph.addEdge("0", "2", 3);

		// From one
		graph.addEdge("1", "3", 3);
		graph.addEdge("1", "2", 1);

		// From two
		graph.addEdge("2", "3", 1);
		graph.addEdge("2", "4", 3);

		// From three
		graph.addEdge("3", "5", 2);

		// From four
		graph.addEdge("4", "5", 6);
		
	


		graph.print();
		System.out.println("BFS Traversal");
		System.out.println(bfsTraversalUsingAdjList("0", graph));

		// String vertex, GraphsList graph, List<String> outPutDFS, Set<String> visisted
		List<String> outPutDFS = new ArrayList<String>();
		HashSet<String> visisted = new HashSet<String>();
		System.out.println("DFS Traversal Recurrsion");
		System.out.println(dfsTraversalWithRecurrsionUsingAdjList("0", graph, outPutDFS, visisted));
		System.out.println("DFS Traversal Iteratively");
		System.out.println(dfsTraversalIterativeUsingAdjList("0", graph));
	}

	public static List bfsTraversalUsingAdjList(String startingVertex, GraphsAdjList graph) {
		// Create a Queue
		// Add zero element and mark visited
		// Add neighbour into queue
		// poll element
		List<String> outPutBFS = new ArrayList();
		Set<String> visisted = new HashSet();
		Queue<String> q = new LinkedList<String>();
		q.offer(startingVertex);
		visisted.add(startingVertex);

		while (!q.isEmpty()) {
			List<Edge> neighboursForVertex = graph.getNeighboursForVertex(q.peek());

			for (Edge eachNeighbour : neighboursForVertex) {
				if (!visisted.contains(eachNeighbour.to)) {
					q.offer(eachNeighbour.to);
					visisted.add(eachNeighbour.to);
				}
			}
			outPutBFS.add(q.poll());
			// System.out.println(q.poll());

		}
		return outPutBFS;

	}

	// DFS With Recurrsion
	public static List<String> dfsTraversalWithRecurrsionUsingAdjList(String vertex, GraphsAdjList graph,
			List<String> outPutDFS, Set<String> visisted) {

		if (visisted.contains(vertex) || vertex == null) {
			return outPutDFS;
		} else {
			// Data Left Right pre order of tree
			// System.out.println(vertex);
			outPutDFS.add(vertex);
			visisted.add(vertex);
			for (Edge eachEdge : graph.getNeighboursForVertex(vertex)) {
				dfsTraversalWithRecurrsionUsingAdjList(eachEdge.to, graph, outPutDFS, visisted);
			}

		}
		return outPutDFS;
	}

	// DFS With Without Recurrsion

	public static List<String> dfsTraversalIterativeUsingAdjList(String vertex, GraphsAdjList graph) {

		List<String> outPutDFS = new LinkedList();
		Stack<String> stack = new Stack<String>();
		HashSet<String> visisted = new HashSet<String>();
		stack.push(vertex);
		outPutDFS.add(vertex);
		visisted.add(vertex);

		while (!stack.isEmpty()) {
			List<Edge> edgeList = graph.getNeighboursForVertex(vertex);
			Edge anyUnvisitedEdge = getUnvisited(edgeList, visisted);

			if (anyUnvisitedEdge != null) {
				visisted.add(anyUnvisitedEdge.to);
				stack.push(anyUnvisitedEdge.to);
				outPutDFS.add(anyUnvisitedEdge.to);
				vertex = anyUnvisitedEdge.to;
			} else {
				vertex = stack.pop();
			}

		}
		return outPutDFS;
	}

	private static Edge getUnvisited(List<Edge> edgeList, Set<String> visisted) {
		for (Edge eachEdge : edgeList) {
			if (!visisted.contains(eachEdge.to)) {
				return eachEdge;
			}
		}
		return null;

	}
}
