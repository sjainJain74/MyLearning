package sorting;

import java.util.Arrays;

public class BubbleSort {

	/*
	 * Time Complexity: O(N2) Auxiliary Space: O(1) The worst-case condition when
	 * elements of the array are arranged in decreasing order. O(N2) Best case for bubble sort InsertionSort sort
	 * Complexity is O(N) when elements are sorted.
	 * 
	 * https://www.geeksforgeeks.org/bubble-sort/
	 */

	// https://leetcode.com/problems/sort-colors/

	public static void main(String arg[]) {
		int[] arr1 = new int[] { 2, 3, 1, 0 };
		int[] arr2 = new int[] { 2, 3, 1, 0 };
		int[] arr3 = new int[] { 1, 2, 3, 4 };
		int[] arr4 = new int[] { 1, 2, 3, 4 };
		int[] arr5 = new int[] { 1, 2, 3, 4 };
		int[] arr6 = new int[] { 2, 3, 1, 0 };

		int[] arr7 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr8 = new int[] { 2, 2, 3, 1, 0, 0 };

		int[] sortColor1 = new int[] { 2, 2, 0, 1, 0, 0 };
		int[] sortColor2 = new int[] { 2, 2, 0, 1, 0, 0 };

		int[] bubbleSort_GoogleInterview = new int[] { 4, 0, 1, 2 };

		bubbleSort(arr1);
		bubbleSort(arr3);
		bubbleSort(arr7);

		bubbleSortOptimized(arr2);
		bubbleSortOptimized(arr4);
		bubbleSortOptimized(arr8);

		// DO NOT WORK :(
		bubbleSortOptimizedSecondWay(arr5);
		bubbleSortOptimizedSecondWay(arr6);

		sortingColors_75(sortColor1);

		bubbleSort_GoogleInterview(bubbleSort_GoogleInterview);
	}

	private static void bubbleSort(int[] arr) {
		int N = arr.length;
		System.out.println("Before Sort " + Arrays.toString(arr));
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				// Logic for swap using the temp variable
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

		System.out.println("After  Sort " + Arrays.toString(arr));
	}

	private static void bubbleSortOptimized(int[] arr) {
		int N = arr.length;
		boolean swap = false;
		System.out.println("Before Sort Optimized" + Arrays.toString(arr));
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				// Logic for swap using the temp variable
				if (arr[j] > arr[j + 1]) {
					// If no swap is done list is sorted, No need to run the loop
					swap = true;
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}

			}
			if (swap == false) {
				// Break from outer loop no need running the loop
				break;
			}
		}

		System.out.println("After  Optimized " + Arrays.toString(arr));
	}

	// Note: this approach of adding the break in for condition does not work,we
	// need to run loop at least once to check if swap happens or not.
	private static void bubbleSortOptimizedSecondWay(int[] arr) {
		int N = arr.length;
		boolean swap = false;
		System.out.println("Before Sort Optimized Second Way" + Arrays.toString(arr));
		for (int i = 0; i < N - 1 && swap == true; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				// Logic for swap using the temp variable
				if (arr[j] > arr[j + 1]) {
					// If no swap is done list is sorted, No need to run the loop
					swap = true;
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}

			}

		}

		System.out.println("After Sort Optimized Second Way " + Arrays.toString(arr));
	}
	
	private static void bubbleSort_GoogleInterview(int[] arr) {
		int N = arr.length;
		System.out.println("Before bubbleSort_GoogleInterview " + Arrays.toString(arr));
		for (int i = 0; i < N - 1; i++) {
			for (int j = N - 1; j != i; j--) { // i!=j will break the loop , this logic is working same as j <N-i-1 :)

				// Logic for swap using the temp variable
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

		System.out.println("After  bubbleSort_GoogleInterview " + Arrays.toString(arr));
	}

	// Highly unoptimzed as we have only 3 types of colors 0,1,2. So bubble sort
	// will take O(N2), But it will be not use extraspace
	private static void sortingColors_75(int[] arr) {
		int N = arr.length;
		boolean swap = false;
		System.out.println("Before sortingColors_75" + Arrays.toString(arr));
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				// Logic for swap using the temp variable
				if (arr[j] > arr[j + 1]) {
					// If no swap is done list is sorted, No need to run the loop
					swap = true;
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}

			}
			if (swap == false) {
				// Break from outer loop no need running the loop
				break;
			}
		}

		System.out.println("After  sortingColors_75 " + Arrays.toString(arr));
	}

	

	
}
