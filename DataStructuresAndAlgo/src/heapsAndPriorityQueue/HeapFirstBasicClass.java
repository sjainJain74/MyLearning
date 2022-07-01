package heapsAndPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapFirstBasicClass {

	public static void main(String arg[]) {

		// Min heap and Max heap basic implementation.

		PriorityQueue<Integer> p = new PriorityQueue<Integer>(5, new MyDescComparator());
		p.add(3);
		System.out.println(p.peek());
		p.add(4);
		System.out.println(p.peek());
		p.add(1);
		System.out.println(p.peek());
		p.add(0);
		System.out.println(p.peek());
		p.add(2);
		System.out.println(p.peek());

		System.out.println("*************");
		/*
		 * PriorityQueue<Integer> p3 = new PriorityQueue<Integer>(2, new
		 * MyDescComparator()); p3.add(5); p3.add(4); p3.add(0); p3.add(2); p3.add(7);
		 * p3.add(3); p3.add(-1); p3.add(2);
		 * 
		 * System.out.print(p3.poll()); System.out.print(p3.poll());
		 * System.out.print(p3.poll()); System.out.print(p3.poll());
		 * System.out.print(p3.poll()); System.out.print(p3.poll());
		 * System.out.print(p3.poll()); System.out.print(p3.poll());
		 */

		// This is min heap, That means smallest at root
		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyDescComparatorForTuple());
		pTuple.add(new int[] { 3, 1 });
		pTuple.add(new int[] { 4, 1 });
		pTuple.add(new int[] { 5, 1 });
		pTuple.add(new int[] { 0, 1 });
		pTuple.add(new int[] { 1, 1 });
		pTuple.add(new int[] { 2, 1 });

		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));
		System.out.print(Arrays.toString(pTuple.poll()));

	}

}

//Min heap comparator, Sort asec
//4,0,1,2 -->0,1,2,4
class MyDescComparatorForTuple implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub

		if (o1[1] > o2[1]) {
			return 1; //swap
		} else if (o1[1] < o2[1]) {
			return -1; //No need to swap
		}

		else if (o1[1] == o2[1] && o1[0] > o2[0]) {
			return 1;
		}

		else if (o1[1] == o2[1] && o1[0] < o2[0]) {
			return -1;
		}

		// Both Equal
		return 0;

	}
}



class MyDescComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		// return o2.compareTo(o1); //--> Max Heap
		return o1.compareTo(o2); // --> Min Heap

	}

}