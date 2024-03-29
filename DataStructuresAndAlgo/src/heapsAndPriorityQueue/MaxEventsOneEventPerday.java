package heapsAndPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxEventsOneEventPerday {

	public static void main(String arg[]) {
		int[][] events1 = { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } };
		int[][] events2 = { { 1, 10000 } };
		int[][] events3 = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } };
		int[][] events4 = { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } };
		int[][] events5 = { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } };
		int[][] events6 = { { 1, 3 }, { 1, 3 }, { 1, 3 }, { 3, 4 } };
		int[][] events8 = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 }, { 1, 8 }, { 1, 9 },
				{ 1, 10 } };
		
		int[][] events7 = { { 2, 3 }, { 3, 4 }, { 1, 5 }, { 4, 5 }};

		/*
		 * System.out.println(maxEvents(events1));
		 * System.out.println(maxEvents(events2));
		 * System.out.println(maxEvents(events3));
		 * System.out.println(maxEvents(events4));
		 * System.out.println(maxEvents(events5)); //Failing
		 * System.out.println(maxEvents(events6));
		 * System.out.println(maxEvents(events7)); System.out.println();
		 * 
		 * System.out.println(maxEventsWithDiff(events1));
		 * System.out.println(maxEventsWithDiff(events2));
		 * System.out.println(maxEventsWithDiff(events3));
		 * System.out.println(maxEventsWithDiff(events4));
		 * System.out.println(maxEventsWithDiff(events5));
		 * System.out.println(maxEventsWithDiff(events6)); //Failing
		 * System.out.println(maxEventsWithDiff(events7));
		 * 
		 * System.out.println();
		 * 
		 * System.out.println(maxEventsWithEndDateSort(events1));
		 * System.out.println(maxEventsWithEndDateSort(events2));
		 * System.out.println(maxEventsWithEndDateSort(events3));
		 * System.out.println(maxEventsWithEndDateSort(events4));
		 * System.out.println(maxEventsWithEndDateSort(events5));
		 * System.out.println(maxEventsWithEndDateSort(events6));
		 */
		System.out.println(maxEventsWithEndDateSort_2022(events7));

	}

	private static int maxEvents(int[][] events) {

		Arrays.sort(events, new MyTupleStartEnd());

		Map<Integer, int[]> mapDataEvent = new HashMap<>();

		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyTupleStartEnd());

		for (int i = 0; i < events.length; i++) {
			pTuple.add(events[i]);
		}

		for (int[] eachTuple : pTuple) {
			int i = eachTuple[0];
			while (i <= eachTuple[1]) {
				if (!mapDataEvent.containsKey(i)) {
					mapDataEvent.put(i, eachTuple);
					break;
				} else {
					i++;
				}

			}
		}

		return mapDataEvent.size();
	}

	private static int maxEventsWithDiff(int[][] events) {

		Map<Integer, int[]> mapDataEvent = new HashMap<>();

		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyTupleDiffComparator());

		for (int i = 0; i < events.length; i++) {
			pTuple.add(events[i]);
		}

		while (!pTuple.isEmpty()) {
			int[] eachTuple = pTuple.poll();
			int i = eachTuple[0];
			while (i <= eachTuple[1]) {
				if (!mapDataEvent.containsKey(i)) {
					mapDataEvent.put(i, eachTuple);
					break;
				} else {
					i++;
				}

			}
		}

		return mapDataEvent.size();
	}

	private static int maxEventsWithEndDateSort(int[][] events) {

		boolean[] daysBooked = new boolean[100000];
		int count = 0;

		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyTupleEndStart());

		for (int i = 0; i < events.length; i++) {
			pTuple.add(events[i]);
		}

		while (!pTuple.isEmpty()) {
			int[] eachTuple = pTuple.poll();
			int i = eachTuple[0];
			while (i <= eachTuple[1]) {
				if (!daysBooked[i]) {
					daysBooked[i] = true;
					count++;
					break;
				} else {
					i++;
				}

			}
		}

		return count;
	}
	
	
	private static int maxEventsWithEndDateSort_2022(int[][] events) {

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new MyTupleEndStart());

		for (int i = 0; i < events.length; i++) {
			pq.add(events[i]);
		}

		LinkedList<int[]> output = new LinkedList<int[]>();
		output.add(pq.poll());

		while (pq.size() != 0) {
			int[] eachTuple = pq.poll(); // started from second tuple
			if (output.getLast()[1] <= eachTuple[0]) {
				output.add(eachTuple);
			}
		}

		return output.size();
	}

	private static int maxEventsWithEndDateSortAndDayIteration(int[][] events) {

		boolean[] daysBooked = new boolean[100000];
		int count = 0;
		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyTupleEndStart());

		for (int i = 0; i < events.length; i++) {
			pTuple.add(events[i]);
		}

		for (int i = 0; i < 100000; i++) {
			if (!daysBooked[i]) {
				daysBooked[i] = true;
				pTuple.poll();
				count++;
			}

		}
		return count;

	}
}

class MyTupleStartEnd implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {

		if (o1[0] > o2[0]) {
			return 1;
		} else if (o1[0] < o2[0]) {
			return -1;
		}	

		else if (o1[0] == o2[0] && o1[1] > o2[1]) {
			return 1;
		}

		else if (o1[0] == o2[0] && o1[1] < o2[1]) {
			return -1;
		}
		return 0;

	}

}

class MyTupleEndStart implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {

		if (o1[1] > o2[1]) {
			return 1;
		} else if (o1[1] < o2[1]) {
			return -1;
		}

		else if (o1[1] == o2[1] && o1[0] > o2[0]) {
			return 1;
		}

		else if (o1[1] == o2[1] && o1[0] < o2[0]) {
			return -1;
		}
		return 0;

	}

}

class MyTupleDiffComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {

		if (o2[1] - o2[0] > o1[1] - o1[0]) {
			return -1;
		} else if (o2[1] - o2[0] < o1[1] - o1[0]) {
			return 1;
		}

		else if ((o2[1] - o2[0] == o1[1] - o1[0]) && (o1[0] > o2[0])) {
			return 1;
		}

		else if ((o2[1] - o2[0] == o1[1] - o1[0]) && (o1[0] < o2[0])) {
			return -1;
		}
		return 0;
	}
}
