package stringQuestions;

import java.util.Arrays;

public class ProductOfArrayExcludingTheNumber {

	public static void main(String arg[]) {

		/*
		 * int[] nums = {-10, 5, 2, 8};
		 * 
		 * 
		 * // each element is the product of all numss except // for the nums element
		 * with the same index int[] expectedOutput = {5*2*8, -10*2*8, -10*5*8,
		 * -10*5*2}; // {80, -160, -400, -100}
		 * 
		 * //(0,1,2,3) --> (6,0,0,0)
		 * 
		 * 
		 * BigInteger mult = new BigInteger(); if(nums[i] !=0){ mult = -10 *5*2*8
		 * -->-800}
		 * 
		 * Array {-800/10,-800/5.....}
		 * 
		 * 
		 * BigInteger mult = new BigInteger(); mult = 0--> mult (6).
		 */

		int[] nums = { 0, 0,0,0};
		System.out.println(Arrays.toString(multiplyAllButMySelf(nums)));

		
		//{80,-160,-400,-100}
		//{6,0,0,0}
	}

	private static int[] multiplyAllButMySelf(int[] nums) {

		int mult = 1;
		boolean anyZeroValue = false;
		int countOfZero =0;
		int[] out = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				mult = mult * nums[i];
			} else {
				anyZeroValue = true;
				countOfZero++;

			}
		}

		if (!anyZeroValue) {
			for (int j = 0; j < nums.length; j++) {
				// Fraction...
				out[j] = (mult / nums[j]);
			}
		}

		// When one value is zero

		else if(countOfZero==1 && anyZeroValue ==true){
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == 0) {
					out[j] = mult;
				} else {
					out[j] = 0;
				}

			}
		}
		//when multiple values are zero
		else {
			return new int[nums.length];
		}
		return out;

	}

}
