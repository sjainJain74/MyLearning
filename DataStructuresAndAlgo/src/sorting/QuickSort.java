package sorting;

import java.util.Arrays;
import java.util.Collections;

//https://www.youtube.com/watch?v=QN9hnmAgmOc  ->Must watch!! best explanation for quick sort partition

public class QuickSort {

	public static void main(String arg[]) {
		//int[] input1 = new int[] { 4, 1, 8, 10, 2 };
		//int[] input1 = new int[] { 4, 1, 8, 10 }; //Array Index out of bound
		int[] input1 = new int[] { 1, 2, 8, 3, 14, 4, 16, 12 }; //Stack Overflow
		//int[] input1 = new int[] { 11, 1, 8, 10, 2 };
		
		
		/*
		 * int[] input2 = new int[] { 10, 2, 8, 3, 14, 4, 16, 12 }; int[] input3 = new
		 * int[] { 10, 2 }; int[] input4 = new int[] { 10 };
		 */

		/*
		 * System.out.println("Before sortingColors_75" + Arrays.toString(input1));
		 * quickSort(input1, 0, input1.length - 1);
		 * System.out.println("After sortingColors_75" + Arrays.toString(input1));
		 */

		// sortArray(input1);

		System.out.println("Before sortingColors_75" + Arrays.toString(input1));
		quicksort_Diplav(input1, 0, input1.length - 1);
		System.out.println("After sortingColors_75" + Arrays.toString(input1));

		/*
		 * System.out.println("Before sortingColors_75" + Arrays.toString(input2));
		 * quickSort(input2, 0, input2.length - 1);
		 * System.out.println("After sortingColors_75" + Arrays.toString(input2));
		 * 
		 * System.out.println("Before sortingColors_75" + Arrays.toString(input3));
		 * quickSort(input3, 0, input3.length - 1);
		 * System.out.println("After sortingColors_75" + Arrays.toString(input3));
		 * 
		 * System.out.println("Before sortingColors_75" + Arrays.toString(input4));
		 * quickSort(input4, 0, input4.length - 1);
		 * System.out.println("After sortingColors_75" + Arrays.toString(input4));
		 */
	}

	public static int[] sortArray(int[] input1) {
		quickSort(input1, 0, input1.length - 1);
		return input1;
	}

	private static void quicksort_Diplav(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition_diplav(arr, start, end);
		quicksort_Diplav(arr, start, pivot );
		quicksort_Diplav(arr, pivot + 1, end);

	}
	
	private static void quickSort(int[] input, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int p = partition(input, start, end);
			quickSort(input, start, p);
			quickSort(input, p + 1, end);
		}
	}

	private static int partition_diplav(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start;
		int j = end;
		while (i <= j) {
			while (i <= j && arr[i] < pivot) {
				i++;
			}
			while (j >= i && arr[j] >= pivot) {
				j--;
			}
			if (i < j) {
				swap(arr, i, j);
			}

		}
		swap(arr, i, end);
		return i;
	}
	
	private static int partition(int[] input, int start, int end) {
		int pivot = input[start];
		int i = start;
		int j = end;

		while (i <= j) {
			while (i <= j && input[i] <= pivot) // i<=j if we do not put we will run into stack overflow.
				i++;
			while (i <= j && input[j] > pivot)
				j--;
			// Tedious to think. Must revise jenny's video for this.
			if (i < j) {
				swap(input, i, j);
			}
		}

		swap(input, j, start);
		return j;

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}



	
}
