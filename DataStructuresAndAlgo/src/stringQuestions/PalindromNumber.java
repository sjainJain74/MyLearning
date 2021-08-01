package stringQuestions;

public class PalindromNumber {

	public static void main(String arg[]) {

		/*
		 * int[] input = {-10, 5, 2, 8};
		 * 
		 * 
		 * // each element is the product of all inputs except // for the input element
		 * with the same index int[] expectedOutput = {5*2*8, -10*2*8, -10*5*8,
		 * -10*5*2}; // {80, -160, -400, -100}
		 * 
		 * //(0,1,2,3) --> (6,0,0,0)
		 * 
		 * 
		 * BigInteger mult = new BigInteger(); if(input[i] !=0){ mult = -10 *5*2*8
		 * -->-800}
		 * 
		 * Array {-800/10,-800/5.....}
		 * 
		 * 
		 * BigInteger mult = new BigInteger(); mult = 0--> mult (6).
		 */

		int[] input = { 0, 1, 2, 3 };
		multiplyAllButMySelf(input);

		
		//{80,-160,-400,-100}
		//{6,0,0,0}
	}

	private static int[] multiplyAllButMySelf(int[] input) {

		int mult = 1;
		boolean anyZeroValue = false;
		int[] out = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			if (input[i] != 0) {
				mult = mult * input[i];
			} else {
				anyZeroValue = true;

			}
		}

		if (!anyZeroValue) {
			for (int j = 0; j < input.length; j++) {
				// Fraction...
				out[j] = (mult / input[j]);
			}
		}

		// When one value is zero

		else {
			for (int j = 0; j < input.length; j++) {
				if (input[j] == 0) {
					out[j] = mult;
				} else {
					out[j] = 0;
				}

			}
		}
		return out;

	}

}
