package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

	// https://leetcode.com/problems/merge-intervals/

	public static void main(String arg[]) {

		// int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 4 } };
		// Expected Output int [] [] output ={{1,4}};

		// int[][] intervals = { { 3, 6 }, { 4, 5 }, { 4, 8 }, { 9, 11 } };
		int[][] intervals = { { 4, 8 }, { 4, 5 }, { 9, 11 }, { 3, 6 } };
		// int [] [] output2 ={{3,8},{9,11}};

		// This is how sorting works
		// Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

		// Arrays.sort(intervals, new MyTupleComparator());

		// System.out.println(Arrays.toString(getTimeSpan(intervals)[0])); // [3, 8]
		// System.out.println(Arrays.toString(getTimeSpan(intervals)[1])); // [9, 11]

		System.out.println(getTimeSpan_Revision_2021_08_01(intervals));

	}

	private static int[][] getTimeSpan(int[][] intervals) {
		Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
		LinkedList<int[]> mergedList = new LinkedList<>();
		// As we are not sure of output size of this list, And we will delete this
		// frequently
		for (int i = 0; i < intervals.length; i++) {
			if (i == 0) {
				// Add first pair from intervals in mergedList
				mergedList.add(intervals[0]);
				continue;
			}
			// In case we found overlapping pairs. First element in merged will remain as
			// such, But second element will higher value of merged._2 and intervals._2
			else if (mergedList.getLast()[1] >= intervals[i][0]) {
				mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], intervals[i][1]);

			}
			// No overlapping happening, let's add tuple from intervals list
			else {
				mergedList.add(intervals[i]);
			}

		}
		return mergedList.toArray(new int[mergedList.size()][]);

		// dimension(no. of rows) is not specified
		// int[][] arr = new int[][3];

		// The line below will execute without any error, as
		// the first dimension(no. of rows) is specified
		// int[][] arr = new int[2][];

	}

	private static int[][] getTimeSpan_Revision_2021_08_01(int[][] intervals) {
		Arrays.sort(intervals, new MyTupleComparator());
		LinkedList<int[]> output = new LinkedList<int[]>(); // As we are not sure of size and we need to get last
															// element always

		for (int x = 0; x < intervals.length; x++) {
			if (x == 0) {
				output.add(intervals[0]); // Trick to remember
			}

			// Merging if interval overlap
			else if (output.getLast()[1] > intervals[x][0]) {
				output.getLast()[1] = Math.max(output.getLast()[1], intervals[x][1]);
			} else {
				output.add(intervals[x]);
			}

		}

		return output.toArray(new int[output.size()][]);

	}

}

class MyTupleComparator implements Comparator<int[]> {

	public int compare(int[] o1, int[] o2) {

		return Integer.compare(o1[0], o2[0]);
	}

}
