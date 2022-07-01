package BinarySearchFolder;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting2DArray {

	public static void main(String arg[]) {

		int mat[][] = new int[][] { { 0, 2 }, { 1, 4 }, { 3, 2 }, { 4, 5 } };
		System.out.println("Before Sorting");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(mat[i][0] + " " + mat[i][1]);
		}

		sortBasedOnSecondColumn(mat);
		System.out.println("After Sorting");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(mat[i][0] + " " + mat[i][1]);
		}

	}

	private static void sortBasedOnSecondColumn(int[][] mat) {
		Arrays.sort(mat, new MyComparatorForSortingBasedTupleDesc());
		//Arrays.sort(mat, new MyComparatorForSortingBasedTupleDescSimplified());

	}

}

class MyComparatorForSortingBasedTupleDesc implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {

		if (o1[1] > o2[1]) {
			return -1;
		} else if (o1[1] < o2[1]) {
			return 1;
		}

		else if (o1[1] == o2[1] && o1[0] > o2[0]) {
			return -1;
		}

		else if (o1[1] == o2[1] && o1[0] < o2[0]) {
			return 1;
		}

		// Both Equal
		return 0;

	}

}

class MyComparatorForSortingBasedTupleDescSimplified implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {

		if (o1[1] != o2[1]) {
			// desc by second column , Second record - first record ( Bigger - Smaller)
			//+ve means swap, negative means do not swap
			return o2[1] - o1[1];
		}

		else if (o1[1] == o2[1]) {
			// desc by first column, Second record - first record ( Bigger - Smaller)
			return o2[0] - o1[0];
		}

		else
			return 0;
	}
}
