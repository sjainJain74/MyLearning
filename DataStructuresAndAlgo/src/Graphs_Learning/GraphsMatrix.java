package Graphs_Learning;

import java.util.List;
import java.util.Map.Entry;

import Graphs_Learning.GraphsAdjList.Edge;

//Undirected Graphs (Both Direction)
// Good when graph is dense
//Storage O(V2)
public class GraphsMatrix {
	public class Vertex {
		Character lebel;

		public Vertex(Character label) {
			this.lebel = label;

		}
	}

	public class Edges {

	}

	int verrtexCount;
	boolean[][] adjMatrix;

	public GraphsMatrix(int verrtexCount) {
		this.verrtexCount = verrtexCount;
		this.adjMatrix = new boolean[verrtexCount][verrtexCount];
	}

	// This is simply adding into 2D matrix
	public void addEdge(int x, int y) {
		if (x >= 0 && x < verrtexCount && y >= 0 && y < verrtexCount)
			adjMatrix[x][y] = true;
		adjMatrix[y][x] = true;
	}

	// This is simply adding into 2D matrix
	public void removeEdge(int x, int y) {
		if (x >= 0 && x < verrtexCount && y >= 0 && y < verrtexCount)
			adjMatrix[x][y] = false;
		adjMatrix[y][x] = false;
	}

	// This is simply adding into 2D matrix
	public boolean isEdge(int x, int y) {
		if (x >= 0 && x < verrtexCount && y >= 0 && y < verrtexCount)
			return adjMatrix[x][y];
		else
			return false;
	}

}
