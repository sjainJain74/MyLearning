package DP;

public class MaxSumSubArray {
	private static int[] numsArray = { -2, 1 };

	public static void main(String arg[]) {
		// int[] numsArray = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(findBestSubarray(0, numsArray.length - 1));
	}

	private static int findBestSubarray(int left, int right) {
		// Base case - empty array.

		if (left >= right) {
			return numsArray[left];
		}

		int mid = Math.floorDiv(left + right, 2);

		// Find the best subarray possible from both halves.
		int bestCombinedSum = findBestCrossingArray(left, right, mid);
		int leftHalf = findBestSubarray(left, mid - 1);
		int rightHalf = findBestSubarray(mid + 1, right);

		// The largest of the 3 is the answer for any given input array.
		return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
	}

	private static int findBestCrossingArray(int left, int right, int mid) {
		int curr = 0;
		int bestLeftSum = 0;
		int bestRightSum = 0;

		// **********Calculating the BSS(Best Combined Sum) ************
		// Iterate from the middle to the beginning.
		for (int i = mid - 1; i >= left; i--) {
			curr += numsArray[i];
			bestLeftSum = Math.max(bestLeftSum, curr);
		}

		// Reset curr and iterate from the middle to the end.
		curr = 0;
		for (int i = mid + 1; i <= right; i++) {
			curr += numsArray[i];
			bestRightSum = Math.max(bestRightSum, curr);
		}

		// The bestCombinedSum uses the middle element and the best
		// possible sum from each half.
		int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
		return bestCombinedSum;
	}
}
