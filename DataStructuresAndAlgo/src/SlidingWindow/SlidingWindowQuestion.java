package SlidingWindow;

import java.util.Arrays;

public class SlidingWindowQuestion {

	public static void main(String[] args) {
		// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
		// Output: [3,3,5,5,6,7]
		// TODO Auto-generated method stub

		int nums[] = { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;
		/// System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));

		int nums2[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k2 = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));

		// To do
		// https://leetcode.com/problems/maximum-subarray/
		// https://leetcode.com/problems/subarray-sum-equals-k/
		// https://leetcode.com/problems/minimum-size-subarray-sum/
		// https://leetcode.com/problems/continuous-subarray-sum/
		// https://leetcode.com/problems/sliding-window-maximum/solution/

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int length = nums.length;
		int i = 0;
		int j = k - 1;
		int sum = 0;
		int z = 1;
		int[] outputArray = new int[length - k + 1];

		// Getting the sum for first window.
		for (int x = 0; x < k; x++) {
			sum = sum + nums[x];
		}
		outputArray[0] = sum;

		while (j != length - 1) {
			sum = sum + nums[j + 1] - nums[i];
			outputArray[z] = sum;
			z++;
			i++;
			j++;

		}

		return outputArray;

	}
	
	public static int[] firstNegativeNumber(int[] nums, int k) {
		int length = nums.length;
		int i = 0;
		int j = k - 1;
		int sum = 0;
		int z = 1;
		int[] outputArray = new int[length - k + 1];

		// Getting the sum for first window.
		outputArray[0] =0;
		for (int x = 0; x < k; x++) {
			if(nums[x] <0) {
				outputArray[0] = nums[x];
				break;
			}
		}
		

		while (j != length - 1) {
			
			if(nums[j + 1]>0 &&  nums[i]>0) {
				
			}
			sum = sum + nums[j + 1] - nums[i];
			outputArray[z] = sum;
			z++;
			i++;
			j++;

		}

		return outputArray;

	}


}
