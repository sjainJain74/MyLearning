package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeIntervalPattern {

	public static void main(String agr[]) {
		/*
		 * int[][] input = new int[][] { { 5, 8 }, { 6, 8 } };
		 * System.out.println(meetingRoom2_Leetcode_253_approch1(input));
		 * 
		 * int[][] input_1353_1 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 }
		 * }; int[][] input_1353_2 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		 * System.out.println(meetingRoom2_Leetcode_1353(input_1353_2));
		 */

		int[] far1 = new int[] { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 };
		int[] far2 = new int[] { 1, 0, 1, 0, 0, 0, 0, 1 };
		int[] far3 = new int[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
		int[] far4 = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 0 };
		int[] far5 = new int[] { 0, 1 };

		/*
		 * System.out.println(farOne(far1)); System.out.println(farOne(far2));
		 * System.out.println(farOne(far3)); System.out.println(farOne(far4));
		 */
		System.out.println(farOne(far2));

	}

	public static int farOne(int[] input) {
		int N = input.length;
		int[] tuble = new int[] { 0, 0 };
		int maxDiff = 0;
		int index = 0;

		int maxDiffforStart = 0;
		int maxDiffforEnd = 0;

		// Handling the zero from starting.
		int s = 0;
		if (input[0] == 0) {
			while (s < N - 1 && input[s] == 0) {
				maxDiffforStart++;
				s++;
			}
		}

		// Handling the zero from end.
		int e = N - 1;
		if (input[N - 1] == 0) {
			while (e >= 0 && input[e] == 0) {
				maxDiffforEnd++;
				e--;
			}
		}

		if (maxDiffforStart > maxDiffforEnd) {
			index = 0;
		} else {
			index = N - 1;
		}

		maxDiff = Math.max(maxDiffforStart, maxDiffforEnd);

		for (int i = s; i <= e; i++) {
			if (input[i] == 1) {
				tuble[0] = tuble[1];
				tuble[1] = i;

				int diff = tuble[1] - tuble[0];
				if (maxDiff < diff/2) {
					maxDiff = diff/2;
					
				}
			}
		}

		return maxDiff;
	}

	public static int meetingRoom2_Leetcode_253_approch1(int[][] intervals) {

		// Sort the array based on start time. Let's get the meeting as and when they
		// are scheduled.

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
				// Asec order. Swap when first element is bigger than second
				// Swap done when this is positive
			}

		});

		Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});

		minHeap.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (minHeap.peek() <= intervals[i][0]) {
				minHeap.poll();
				minHeap.add(intervals[i][1]);
			} else {
				minHeap.add(intervals[i][1]);
			}
		}
		return minHeap.size();

	}

	// This code is giving TLE
	public static int meetingRoom2_Leetcode_1353(int[][] intervals) {

		// Sort the array based on End time. Let's attend the event that is finishing
		// early

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
				// Asec order. Swap when first element is bigger than second
				// Swap done when this is positive
			}

		});

		boolean[] booked = new boolean[100000];
		int count = 0;
		for (int[] each : intervals) {
			int i = each[0];

			while (i <= each[1]) {
				if (booked[i - 1]) {
					i++;
				} else {
					booked[i - 1] = true;
					count++;
					break;
				}
			}

		}
		return count;
	}

}