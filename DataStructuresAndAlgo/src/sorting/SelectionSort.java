package sorting;

import java.util.Arrays;

public class SelectionSort {
     //Like school line. Select Chotu student come in first
	 //https://www.youtube.com/watch?v=B-nqY6IYqVw

	/*
	 * Time Complexity: O(N2) (Best, Worst case both) Complexity is O(N2) when
	 * elements are sorted also. In Bubble sort and insertion sort best case is O(N)
	 */

	/*
	 * Algo SELECT minimum element and place it at start position. Find second
	 * largest and place that at second position
	 * 
	 */

	/* Read from narsimbha Karu */

	public static void main(String arg[]) {
		int[] arr1 = new int[] { 2, 3, 1, 0 };
		int[] arr2 = new int[] { 2, 3, 1, 0 };
		int[] arr3 = new int[] { 1, 2, 3, 4 };
		int[] arr4 = new int[] { 1, 2, 3, 4 };
		int[] arr5 = new int[] { 1, 2, 3, 4 };
		int[] arr6 = new int[] { 2, 3, 1, 0 };
		int[] arr7 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr8 = new int[] { 2, 2, 3, 1, 0, 0 };

		selectionSort(arr1);
		selectionSort(arr2);
		selectionSort(arr3);
		selectionSort(arr4);
		selectionSort(arr5);
		selectionSort(arr6);
		selectionSort(arr7);
		selectionSort(arr8);

	}

	private static void selectionSort(int[] arr) {
		int N = arr.length;
		System.out.println("Before Sort " + Arrays.toString(arr));
		for (int i = 0; i < N; i++) {
			// I was tempted to take min = arr[i],but this will not help in swapping later.
			int min = i;
			for (int j = i + 1; j < N; j++) {
				// Logic for swap using the temp variable
				if (arr[j] < arr[min]) {
					min = j;
				}

				// swap minimum element with i th element
				//we should add
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;

				// After one swap, Minimum element is at i=0
				// After second swap, Minimum element is at i=1
				// After third swap, Minimum element is at i=2

			}
		}

		System.out.println("After  Sort " + Arrays.toString(arr));
	}

}
