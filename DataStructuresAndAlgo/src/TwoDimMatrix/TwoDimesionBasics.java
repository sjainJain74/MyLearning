package TwoDimMatrix;

import java.util.ArrayList;
import java.util.List;

public class TwoDimesionBasics {
	public static void main(String arg[]) {
		int[][] input = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		// leetcode48(input);

		int[][] spiral = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		// System.out.println(leetcod_54(spiral));

		int[][] spiral2 = new int[][] { { 1, 2, 3, 4, 5 }, { 14, 15, 16, 17, 6 }, { 13, 20, 19, 18, 7 },
				{ 12, 11, 10, 9, 8 } };
		// System.out.println(leetcod_54(spiral2));

		int[][] spiral4 = new int[][] { { 1, 2 }, { 6, 3 }, { 5, 4 }, };
		// System.out.println(leetcod_54(spiral4));

		int[][] spiral5 = new int[][] { { 1, 2 }, { 4, 3 } };
		// System.out.println(leetcod_54(spiral5));

		int[][] spiral3 = new int[][] { { 1, 2, 3, 4 }, { 10, 11, 12, 5 }, { 9, 8, 7, 6 }, };
		System.out.println(leetcod_54(spiral3));
	}

	public static List<Integer> leetcod_54(int[][] matrix) {

		int columnLength = matrix[0].length;
		int rowLength = matrix.length;

		int rowStart = 0;
		int rowEnd = rowLength - 1;

		int columnStart = 0;
		int columnEnd = columnLength - 1;

		List<Integer> result = new ArrayList<Integer>();

		//If we put condition on row or column, We might end up extra row or column iteration
		while (true) {

			// Move left to right
			for (int i = columnStart; i <= columnEnd; i++) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;
			//Checking everytime if we are done..
			if(rowStart>rowEnd ||columnStart>columnEnd) break; // We can have only one condition also.

			// Move Top to Bottom
			for (int i = rowStart; i <= rowEnd; i++) {
				result.add(matrix[i][columnEnd]);
			}

			columnEnd--;
			//Checking everytime if we are done..
			if(rowStart>rowEnd ||columnStart>columnEnd) break; // We can have only one condition also.

			// Move Right to Left
			for (int i = columnEnd; i >= columnStart; i--) {
				result.add(matrix[rowEnd][i]);
			}

			rowEnd--;
			//Checking everytime if we are done..
			
			if(rowStart>rowEnd ||columnStart>columnEnd) break;// We can have only one condition also.

			// Move Bottom to Top

			for (int i = rowEnd; i >= rowStart; i--) {
				result.add(matrix[i][columnStart]);
			}

			columnStart++;
			//Checking everytime if we are done..
			if(rowStart>rowEnd ||columnStart>columnEnd) break; // We can have only one condition also.
		}
		return result;

	}

	// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
	// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
	private static void leetcode48(int[][] matrix) {
		// TODO Auto-generated method stub
		// Transpose first along ANY diagonal

		int l = matrix[0].length;
		for (int i = 0; i < l; i++) {
			// Be caution to run half loop else you will get same array ;)
			for (int j = i + 1; j < l; j++) {
				// This can be added in if condition also.
				if (j > i) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
					// a[i][j] =a[j][i]; when i=!j;}
				}
			}

		}

		// Swap the columns, We have to cautious with our i and J here
		// iterate vertically thus j loop is outside and we will only go halfway
		// i loop will be from 0 to l-1
		// swap just check once for 3X3 matrix.

		for (int j = 0; j < l / 2; j++) {ß
			for (int i = 0; i < l; i++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][l - j - 1];
				matrix[i][l - j - 1] = temp;
			}

		}

	}

	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate
	// Image.
	// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
	// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
	private static void leetcode48_optimized(int[][] matrix) {
		// TODO Auto-generated method stub
		// Transpose first along ANY diagonal

		int l = matrix[0].length;
		for (int i = 0; i < l; i++) {
			// Be caution to run half loop else you will get same array ;)
			for (int j = i + 1; j < l && j > i; j++) {
				// j < l ..This can be added in if condition below.
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
				// a[i][j] =a[j][i]; when i=!j;}
			}

		}

		// Swap the columns, We have to cautious with our i and J here
		// iterate vertically thus j loop is outside and we will only go halfway
		// i loop will be from 0 to l-1
		// swap just check once for 3X3 matrix.

		for (int j = 0; j < l / 2; j++) {
			for (int i = 0; i < l; i++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][l - j - 1];
				matrix[i][l - j - 1] = temp;
			}

		}

	}
}
