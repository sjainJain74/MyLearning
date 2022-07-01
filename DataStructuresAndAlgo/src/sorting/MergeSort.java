package sorting;

import java.util.Arrays;

public class MergeSort {

	// Let's learn merge first.

	public static void main(String arg[]) {

		int[] arr1 = new int[] { 2, 4, 6, 8, 10 };
		int[] arr2 = new int[] { 0, 1, 3, 5 };

		int[] arr11 = new int[] { 1 };
		int[] arr22 = new int[] { 0 };

		// expected output = [0,1,2,3,4,6,8,10]

		System.out.println("Before Merge these are 2 arrays " + Arrays.toString(arr1) + "  " + Arrays.toString(arr2));
		System.out.println("After  Merge " + Arrays.toString(merge(arr1, arr2)));

		System.out.println("Before Merge these are 2 arrays " + Arrays.toString(arr11) + "  " + Arrays.toString(arr22));
		System.out.println("After  Merge " + Arrays.toString(merge(arr11, arr22)));

		int[] mergeForMergeSort = new int[] { 0, 1, 3, 2, 4 };
		System.out.println("Before Merge of Merge Sort " + Arrays.toString(mergeForMergeSort));
		// int[] arr, int l, int m, int h
		System.out.println("After Merge of Merge Sort " + Arrays.toString(mergeForMergeSort(mergeForMergeSort, 0,
				(0 + mergeForMergeSort.length - 1) / 2, mergeForMergeSort.length - 1)));

		int[] mergeForMergeSort2 = new int[] { 0, 2, 1, 4 };
		System.out.println("Before Merge of Merge Sort " + Arrays.toString(mergeForMergeSort2));
		// int[] arr, int l, int m, int h
		System.out.println("After Merge of Merge Sort " + Arrays.toString(mergeForMergeSort(mergeForMergeSort2, 0,
				(0 + mergeForMergeSort2.length - 1) / 2, mergeForMergeSort2.length - 1)));

		// Try to drw
		int[] mergeSortInput = new int[] { 12, 13, 14, 2, 4, 6, 8, 10 };
		System.out.println("Before Merge Sort" + Arrays.toString(mergeSortInput));
		System.out
				.println("After Merge Sort" + Arrays.toString(mergeSort(mergeSortInput, 0, mergeSortInput.length - 1)));

	}

	private static int[] mergeSort(int[] arr, int start, int end) {

		if (start == end) {
			// This is classy case of base case condition
			//return arr; // this is wrong
			return new int[] { arr[start] };
			

		}
		while (start < end) {
			int mid = (start + end) / 2;
			int[] arrSortedLeft = mergeSort(arr, start, mid);
			int[] arrSortedRight = mergeSort(arr, mid + 1, end);
			return merge(arrSortedLeft, arrSortedRight);
		}
		return arr;

	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int s1 = arr1.length; // 5
		int s2 = arr2.length; // 3
		int[] arrOut = new int[s1 + s2];

		int i = 0;
		int j = 0;
		int k = 0;

		// Below while will merge [0,1,2,3] --> leaving 4,6,8,10 to be merged later in
		while (i < s1 && j < s2) {
			if (arr1[i] < arr2[j]) {
				arrOut[k] = arr1[i];
				k++;
				i++;
			} else {
				arrOut[k] = arr2[j];
				k++;
				j++;

			}
		}

		// Merging 4,6,8,10 in the list
		while (i < s1) {
			arrOut[k] = arr1[i];
			i++;
			k++;
		}
		while (j < s2) {
			arrOut[k] = arr2[j];
			j++;
			k++;

		}

		return arrOut;
	}

	// 1, 3, 4, 2, 6, 8, 18, 20, 21
	// l=0 h =8

	private static int[] mergeForMergeSort(int[] arr, int l, int m, int h) {
		int[] arrOut = new int[arr.length];

		int i = 0;
		int j = m + 1;
		int k = 0;

		while (i <= m && j <= h) {
			if (arr[i] < arr[j]) {
				arrOut[k] = arr[i];
				k++;
				i++;
			} else {
				arrOut[k] = arr[j];
				k++;
				j++;

			}
		}

		// Merging 4,6,8,10 in the list
		while (i <= l) {
			arrOut[k] = arr[i];
			i++;
			k++;
		}
		while (j <= h) {
			arrOut[k] = arr[j];
			j++;
			k++;

		}

		return arrOut;
	}
}
