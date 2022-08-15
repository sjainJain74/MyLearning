package sorting;

import java.util.Arrays;

public class InsertionSort {
//Like rammi of card

	/*
	 * Deck of card :)
	 * 
	 * This is complex code took 3-4 hours to get the code correct,Must revise
	 * category
	 * 
	 * Time Complexity: O(N2) (Best, Worst case both) Complexity is O(N2) when
	 * elements are sorted also. In Bubble sort and insertion sort best case is O(N)
	 */

	/*
	 * This is complicated algo, Involving for loop and while loop. Pick one element
	 * for eg 4
	 * 
	 * 
	 * [1,2,7,8,4] ==> [1,2,7,8] [4]=>[1,2, ,7,8] => [1,2,4,7,8] =>Sorted list
	 * 
	 */

	/* Read from narsimbha Karu */

	public static void main(String arg[]) {
		int[] arr1 = new int[] { 10, 5 };
		int[] arr2 = new int[] { 20, 10, 5, 2, 1, 0 };
		int[] arr3 = new int[] { 1, 2, 3, 4 };
		int[] arr4 = new int[] { 1, 2, 3, 4 };
		int[] arr5 = new int[] { 1, 2, 3, 4 };
		int[] arr6 = new int[] { 2, 3, 1, 0 };
		int[] arr7 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr8 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr9 = new int[] { 0 };

		/*
		 * insertionSort(arr1); insertionSort(arr2); insertionSort(arr3);
		 * insertionSort(arr4); insertionSort(arr5); insertionSort(arr6);
		 * insertionSort(arr7); insertionSort(arr8); insertionSort(arr9);
		 */

		int[] arr11 = new int[] { 10, 5 };
		int[] arr22 = new int[] { 20, 10, 5, 2, 1, 0 };
		int[] arr33 = new int[] { 1, 2, 3, 4 };
		int[] arr44 = new int[] { 1, 2, 3, 4 };
		int[] arr55 = new int[] { 1, 2, 3, 4 };
		int[] arr66 = new int[] { 2, 3, 1, 0 };
		int[] arr77 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr88 = new int[] { 2, 2, 3, 1, 0, 0 };
		int[] arr99 = new int[] { 0 };

		insertionSort_usingfor(arr11);
		insertionSort_usingfor(arr22);
		insertionSort_usingfor(arr33);
		insertionSort_usingfor(arr44);
		insertionSort_usingfor(arr55);
		insertionSort_usingfor(arr66);
		insertionSort_usingfor(arr77);
		insertionSort_usingfor(arr88);
		insertionSort_usingfor(arr99);

		/*
		 * insertionSort(arr2); insertionSort(arr3); insertionSort(arr4);
		 * insertionSort(arr5); insertionSort(arr6); insertionSort(arr7);
		 * insertionSort(arr8);
		 */

	}

	// https://www.youtube.com/watch?v=wWhAhp6PIuQ

	// [2,3,5,| 4,7,5] At a moment we do have list sorted till a point...2,3,5 and
	// when we pick 4 we will again sort the left arrayß

	private static void insertionSort(int[] arr) {
		int N = arr.length;
		System.out.println("Before Sort " + Arrays.toString(arr));
		for (int i = 1; i < N; i++) { // we start from i =1 as if we start from i =0 than j-- will give us negative.
			int currentElement = arr[i];
			int j = i - 1; // We want to go left for all element from i-1,i-2 ....0;
			while (j >= 0 && arr[j] > currentElement) {
				// we are doing j-- that will take to infinity, thus we add j>=0 .
				// This need to be added before else we will get array index for arr[-1], Was
				// stuck in reverse ordering for 1 hour :(
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = currentElement; // Since we did j-- in last step thus we need to put current element to j+1

		}

		System.out.println("After  Sort " + Arrays.toString(arr));
	}

	// I got first click to solve via two for loop. But we have catch here we need
	// to run second loop arr[j] > curr

	private static void insertionSort_usingfor(int[] arr) {
		int N = arr.length;
		System.out.println("Before insertionSort_usingfor " + Arrays.toString(arr));
		for (int i = 1; i < N; i++) {
			int curr = arr[i];
			int empty = -1;

			for (int j = i - 1; j >= 0 && arr[j] > curr; j--) {
				arr[j + 1] = arr[j];
				empty = j;
				// we can put the arr[empty] = curr; here also , but not need put that after
				// move,
				// We can do that once one inner loop finishes.
				// Like we do while while putting cared in hand during rummy ;)
			}

			if (empty != -1) {
				arr[empty] = curr;
			}

		}

		System.out.println("After  insertionSort_usingfor " + Arrays.toString(arr));
	}

}
