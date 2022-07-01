package heapsAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BasicHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthLargest(new int[] { 1,2,3,4,5,6,7,8,9 }, 4));

	}

	public static int findKthLargest(int[] nums, int k) {

		// Creating heap of size k. it takes logk complecity to create this heap.
		// We need to fetch 4th lag so we will create min	 heap of sie k
		// We cannot specify size, that is in blocking queue
		/*
		 * Queue<Integer> heap = new PriorityQueue(new Comparator<Integer>() { public
		 * int compare(Integer o1, Integer o2) { // TODO Auto-generated method stub
		 * return o1 - o2; } });
		 */

		Queue<Integer> heap = new PriorityQueue<Integer>();
		for (int each : nums) {
			heap.add(each);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		return heap.peek();

	}

}
