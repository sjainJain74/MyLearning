package sorting;

import java.util.Arrays;

public class CountingSort {

	// Very Good question using 3 pointer
	// https://leetcode.com/problems/sort-colors/submissions/
	// Video https://www.youtube.com/watch?v=oaVa-9wmpns

	public static void main(String arg[]) {
		int[] sortColor1 = new int[] { 2, 2, 0, 1, 0, 0 };
		int[] sortColor2 = new int[] { 2, 2, 0, 1, 0, 0 };
		sortingColors_WithTwoPass_75(sortColor1);

		sortingColors_WithOnePass(sortColor2);

	}

	private static void sortingColors_WithTwoPass_75(int[] arr) {
		int N = arr.length;
		int zero = 0;
		int one = 0;
		int two = 0;

		System.out.println("Before sortingColors_WithTwoPass_75" + Arrays.toString(arr));

		// Can use map also, But this approch is better.

		// We have 3 number 0,1,2
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				zero++;
			} else if (arr[i] == 1) {
				one++;
			}
			if (arr[i] == 2) {
				two++;
			}

		}

		// thinking of this is complex!! Revise again
		// We can do that in one for loop also by if else inside on index ;)

		for (int i = 0; i < zero; i++) {
			arr[i] = 0;
		}
		for (int i = zero; i < zero + one; i++) {
			arr[i] = 1;
		}
		for (int i = zero + one; i < zero + one + two; i++) {
			arr[i] = 2;
		}
		
		
		/*
		 * for (int i = 0; i < N-1; i++) { if(i<zero) arr[i] = 0; else if(i>zero &&
		 * i<zero+one) arr[i] = 1 }
		 */
		System.out.println("After sortingColors_WithTwoPass_75" + Arrays.toString(arr));

	}

	private static void sortingColors_WithOnePass(int[] arr) {
		int N = arr.length;
		int l = 0; // Index +1 for zero's chain
		int r = N - 1;
		int m = 0;// Index -1 for one's chain

		System.out.println("Before sortingColors_WithOnePass" + Arrays.toString(arr));

		while (m <= r) {
			// If we found zero
			if (arr[m] == 0) {
				swap(arr, m, l);
				l++;
				m++;

			}
			// If we found one
			else if (arr[m] == 1) {
				m++;

			} // If we found two
			else {

				swap(arr, m, r);
				r--;

			}

		}

		System.out.println("After sortingColors_WithOnePass" + Arrays.toString(arr));

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
