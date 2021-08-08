package Graphs_Learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Graphs_Learning.GraphsList.Edge;

public class BothSideDirectedGraphsTraversalUsingMatrix {

	public static void main(String arg[]) {
		int v = 6; // Number of nodes

		GraphsMatrix graph = new GraphsMatrix(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(1, 3);
		graph.addEdge(1, 2);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);

		graph.addEdge(3, 5);

		graph.addEdge(4, 5);

		System.out.println("BFS Traversal");
		System.out.println(bfsTraversalUsingAdjList(0, graph));

		// String vertex, GraphsList graph, List<String> outPutDFS, Set<String> visisted

		// System.out.println(dfsTraversalIterativeUsingAdjList(0, graph));

		List<String> outPutDFS = new ArrayList<String>();
		boolean[][] visisted = new boolean[v][v];
		System.out.println("DFS Traversal Recurrsion");
		System.out.println(dfsTraversalWithRecurrsionUsingAdjList(0, graph, outPutDFS, visisted));
		// System.out.println("DFS Traversal Iteratively");
	}

	public static List bfsTraversalUsingAdjList(int i, GraphsMatrix graph) {
		// Create a Queue
		// Add zero element and mark visited
		// Add neighbour into queue
		// poll element
		List<String> outPutBFS = new ArrayList();
		Set<String> visisted = new HashSet();
		Queue<String> q = new LinkedList<String>();
		q.offer(i);
		visisted.add(i);

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
	public static List<String> dfsTraversalWithRecurrsionUsingAdjList(int x, int y, GraphsMatrix graph,
			boolean[][] visisted) {

		if (visisted[x][y] || x > 0 || y > 0 || x < graph.verrtexCount || y < graph.verrtexCount) {
			return outPutDFS;
		} else {
			// Data Left Right pre order of tree
			 System.out.println(" x "+ x +" y "+y);
			//outPutDFS.add(x,y);
			visisted[x][y] = true;
			
				dfsTraversalWithRecurrsionUsingAdjList(x+1,y ,graph,visisted);
				dfsTraversalWithRecurrsionUsingAdjList(x,y+1 ,graph,visisted);
				dfsTraversalWithRecurrsionUsingAdjList(x-1,y ,graph,visisted);
				dfsTraversalWithRecurrsionUsingAdjList(x,y-1 ,graph,visisted);
			}

		}
		return outPutDFS;
	}

	// DFS With Without Recurrsion

	public static List<String> dfsTraversalIterativeUsingAdjList(String vertex, GraphsMatrix graph) {

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
