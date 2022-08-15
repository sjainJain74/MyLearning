package Stack;

import java.util.Arrays;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class Stack_LeetCode {
	// https://www.youtube.com/watch?v=HUfUzA9Ekgo&t=628s
	// https://leetcode.com/problems/basic-calculator/

	public static void main(String arg[]) {
//		String s1 = "(7)";
//		System.out.println(calc(s1));
//		
//		String s2 = "(7+1-1-1-1)";
//		System.out.println(calc(s2));
//		
//		
//		String s3 = "(-7+2+2)";
//		System.out.println(calc(s3));
//		
//		
//		String s4 = "(-7)"
//		System.out.println(calc(s4));
//		
//		
//		String s5 = "(-7 +(-2))";
//		System.out.println(calc(s5));
//		
//		// This is failing
//		String s6 = "(-7 -(-2))";
//		System.out.println(calc(s6));
//		
//		String s7 = "-1+1";
//		System.out.println(calc(s7));

//		
		/*
		 * String s8 = "(1+(4+5+2)-3)+(6+8)"; //23 is expected
		 * System.out.println(calc(s8));
		 * 
		 * //1 String s10 = "(1-(4+5+2)-3)+(6+8)"; System.out.println(calc(s10));
		 * 
		 * //String s9 = " 2-1 + 2 "; //System.out.println(calc(s9));
		 */
		String s11 = "(13-(4+3)-2)";
		// 1 is expected
		// System.out.println(cacOptimize(s11));

		int[] nums = new int[] { 1, 2, 3, 4, 3 };
		// Output: [2,3,4,-1,4]
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
		
		int[] nums1 = new int[] { 1, 2, 3, 4, 3 };
		// Output: [2,3,4,-1,4]
		System.out.println(Arrays.toString(leetocode_503(nums1)));


	}

	/*
	 * Input: nums = [1,2,3,4,3] Output: [2,3,4,-1,4] Input: nums = [5,4,3,2,1]
	 * Output: [-1,-1,-1,-1,5]
	 */
		public static int[] nextGreaterElements(int[] input) {
			// Sumit malik eplanation is good and also Striver explained well for circular
	
			// 1. Iterate from back .
			// Algo
			// If Stack has smaller ..Pop them..Throw smaller out
			// If stack has bigger just namaste karo and unhe apna answer maan k..Stack mein
			// baith jao..As tum next aur k answer ho sakte
			// Write the all code assuming that no circular array
			// Run the loop from n-1 -->2n-1 and change i --> i%len
	
			int len = input.length;
	
			int output[] = new int[len];
			Stack<Integer> st = new Stack();
			// st.push(input[l - 1]);
			// output[l - 1] = -1; // For now
	
			for (int i = 2 * len - 1; i >= 0; i--) {
	
				if (st.size() > 0 && input[i % len] < st.peek()) {
					output[i % len] = st.peek();
					st.push(input[i % len]);
	
				} else {
	
					while (st.size() > 0 && input[i % len] >= st.peek()) {
						st.pop();
					}
					if (st.empty()) {
						output[i % len] = -1;
						st.push(input[i % len]);
					} else {
						output[i % len] = st.peek();
						st.push(input[i % len]);
					}
	
				}
	
			}

		/*
		 * // Filing for last element and all -1 as this is circular array
		 * 
		 * while (st.size() > 0 && input[l - 1] >= st.peek()) { st.pop(); } if
		 * (st.size() > 0) { output[l - 1] = st.peek(); }
		 */

		return output;

	}

	public static int[] leetocode_503(int[] input) {
		
		//[5,4,3,2,1 --> 5,4,3,2,1]
		
		/*
		 * This approch fails for Input [5,4,3,2,1]
		 *  Output with my approch for 2 loops [-1,-1,-1,-1,5] 
		 *  Expected
		 * [-1,5,5,5,5]
		 */

		int len = input.length;

		int output[] = new int[len];
		Stack<Integer> st = new Stack();
		// st.push(input[l - 1]);
		// output[l - 1] = -1; // For now

		for (int i = len - 1; i >= 0; i--) {

			if (st.size() > 0 && input[i] < st.peek()) {
				output[i] = st.peek();
				st.push(input[i]);

			} else {

				while (st.size() > 0 && input[i] >= st.peek()) {
					st.pop();
				}
				if (st.empty()) {
					output[i] = -1;
					st.push(input[i]);
				} else {
					output[i] = st.peek();
					st.push(input[i]);
				}

			}

		}

		// Filing for last element and all -1 as this is circular array

		while (st.size() > 0 && input[len - 1] >= st.peek()) {
			st.pop();
		}
		if (st.size() > 0) {
			output[len - 1] = st.peek();
		}

		return output;

	}

	public static int cacOptimize(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] charArray = s.toCharArray();
		int sign = 1;
		int result = 0;
		int sum = 0;

		for (int i = 0; i < charArray.length; i++) {
			// Logic to convert 2 or 3 digits in string array to Int value.

			if (Character.isDigit(charArray[i])) {
				sum = Character.getNumericValue(charArray[i]);
				while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
					sum = sum * 10 + Character.getNumericValue(charArray[i + 1]);
					i++;
				}
				result = result + sign * sum;
			}

			else if (charArray[i] == '+') {
				sign = 1;

			}

			else if (charArray[i] == '-') {
				sign = -1;
			}

			else if (charArray[i] == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;

			}

			else if (charArray[i] == ')') {
				result = result * stack.pop() + stack.pop();
			}
		}

		return result;

	}

}