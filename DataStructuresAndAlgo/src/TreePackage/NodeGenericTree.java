package TreePackage;

import java.util.ArrayList;
import java.util.Stack;

public class NodeGenericTree {
	int data;

	public NodeGenericTree(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ArrayList<NodeGenericTree> getGenericTreeList() {
		return genericTreeChildList;
	}

	public void setGenericTreeList(ArrayList<NodeGenericTree> genericTreeChildList) {
		this.genericTreeChildList = genericTreeChildList;
	}

	ArrayList<NodeGenericTree> genericTreeChildList = new ArrayList<NodeGenericTree>();

	public static void main(String arg[]) {

		NodeGenericTree root = CreateTree();
		System.out.println(root);

	}

	private static NodeGenericTree CreateTree() {
		int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };

		Stack<NodeGenericTree> stack = new Stack<NodeGenericTree>();
		NodeGenericTree root = new NodeGenericTree(arr[0]);
		stack.push(root);

		for (int i = 1; i < arr.length; i++) {
			if (!(arr[i] == -1)) {
				NodeGenericTree node = new NodeGenericTree(arr[i]);

				stack.peek().getGenericTreeList().add(node);
				stack.push(node);
			}
			// When -1
			else {
				stack.pop();

			}
		}
		return root;
	}

}
