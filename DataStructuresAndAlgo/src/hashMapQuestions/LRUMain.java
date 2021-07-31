package hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

	class Node {
		int key;
		int value;
		Node next;;
		Node prev;

	}

	Map<Integer, Node> m;
	int count;
	Node head;
	Node tail;
	int capacity;

	public LRUCache(int capacity) {
		// this.count = 0;
		this.capacity = capacity;

		// Create a Doubly linked list with only head and tail two elements.
		head = new Node();
		tail = new Node();

		head.prev = null;
		head.next = tail;

		tail.prev = head;
		tail.next = null;

		m = new HashMap<Integer, Node>();

	}

	public int get(int key) {

		// 1. If Do not contain return -1
		// 2. If map contain key, Please follow 3 steps.

		//// delete from list
		//// add in the list after head
		/// update the map
		//// return the value

		if (!m.containsKey(key)) {
			return -1;
		}

		else {
			Node node = m.get(key);
			int value = node.value;
			
			addInListAfterHead(node);
			deletefromList(node);
			updateMap(node);
			return value;
		}

	}

	private void updateMap(Node node) {
		m.put(node.key, node);

	}

	private void addInListAfterHead(Node node) {
		Node temp = head.next;
		node.prev = head;
		node.next = temp;

		head.next = node;
		temp.prev = node;

	}

	private void deletefromList(Node node) {
		Node p1 = node.prev;
		Node n1 = node.next;

		p1.next = n1;
		n1.prev = p1;

	}

	public void put(int key, int value) {
		Node n = new Node();
		n.key = key;
		n.value = value;

		if (m.size() < capacity) {

			if (m.containsKey(key)) {
				deletefromList(m.get(key));
				addInListAfterHead(n);
				m.put(key, n);
			}
			// Not in map.
			else {
				addInListAfterHead(n);
				m.put(key, n);

			}

		}

		// Map is full, Capacity reached and it's existing key
		else {

			if (m.containsKey(key)) {
				deletefromList(tail.prev);
				addInListAfterHead(n);
				// Update the key
				m.put(key, n);
			}

			else {

				// Map is full, Capacity reached and remove the least access key ( near tail)
				m.remove(tail.prev.key);
				deletefromList(tail.prev);
				addInListAfterHead(n);
				// Update the key
				m.put(key, n);

			}

		}

	}

}

public class LRUMain {

	public static void main(String arg[]) {
		// Create cache of size 2
		/*
		 * LRUCache cache = new LRUCache(2); cache.put(1, 1); cache.put(2, 2);
		 * System.out.println(cache.get(1)); cache.put(3, 3);
		 * System.out.println(cache.get(2)); cache.put(4, 4);
		 * System.out.println(cache.get(1)); System.out.println(cache.get(3));
		 * System.out.println(cache.get(4));
		 */

		// ["LRUCache","put","put","get","put","get","put","get","get","get"]
		// [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

		// [null,null,null,1,null,2,null,1,3,4]
		// [null,null,null,1,null,-1,null,-1,3,4]

		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(2, 2);
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));
		
		// ["LRUCache","put","put","get","put","put","get"]
		// [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
	}

}
