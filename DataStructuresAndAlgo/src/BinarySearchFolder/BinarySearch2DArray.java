package BinarySearchFolder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BinarySearch2DArray {

	public static void main(String arg[]) {

		int mat[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 } };
		int k = 3;

		System.out.println(Arrays.toString(kWeakestRows(mat, k)));

	}

	private static int binarySearchWithDublicateFirstOccurance(int[] myArray) {
		int start = 0;
		int end = myArray.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (myArray[mid] == 0) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return end;

	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		int row = mat.length;

		PriorityQueue<int[]> pTuple = new PriorityQueue<int[]>(new MyDescComparatorForTuple());

		for (int j = 0; j < row; j++) {
			pTuple.add(new int[] { j, binarySearchWithDublicateFirstOccurance(mat[j]) });
		}

		int[] output = new int[k];

		for (int j = 0; j < k; j++) {
			output[j] = pTuple.poll()[0];
		}
		return output;
	}
}

class MyDescComparatorForTuple implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub

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

		// Both Equal
		return 0;

	}
}
