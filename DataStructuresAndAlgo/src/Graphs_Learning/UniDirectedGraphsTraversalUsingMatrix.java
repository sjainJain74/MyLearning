package Graphs_Learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Graphs_Learning.GraphsAdjList.Edge;

public class UniDirectedGraphsTraversalUsingMatrix {

	public static void main(String arg[]) {
		int size = 6; // Number of nodes

		GraphsMatrix graph = new GraphsMatrix(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(1, 3);
		graph.addEdge(1, 2);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);

		graph.addEdge(3, 5);

		graph.addEdge(4, 5);

		boolean[] visisted = new boolean[size];
		System.out.println("DFS Traversal Recurrsion");
		dfs(0, visisted, size, graph.adjMatrix);
		// System.out.println("DFS Traversal Iteratively");
	}

	// DFS With Recurrsion
	private static void dfs(int start, boolean[] visited, int size, boolean[][] adjMatrix) {

		if (visited[start]) {
			return;
		}

		else {
			System.out.println("Print Element " + start);
			visited[start] = true;
			for (int i = 0; i < size; i++) {
				if (adjMatrix[start][i]) {
					dfs(i, visited, size, adjMatrix);
				}
			}
		}
	}

}
