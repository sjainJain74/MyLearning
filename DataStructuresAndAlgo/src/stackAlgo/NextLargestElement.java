package stackAlgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextLargestElement {

	public static void main(String arg[]) {

		// Aditya verma Code
		// https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
		int[] input1 = { 1, 3, 4, 2 };
		int[] nextInput1 = { 4,1,2};
		//System.out.println(Arrays.toString(nextLargestArray(input1)));
		//System.err.println("Leet Code");
		System.out.println(Arrays.toString(nextLargestArrayLeetCode(nextInput1, input1)));
		
	

		int[] input2 = { 4, 1, 2 };
	//	System.out.println(Arrays.toString(nextLargestArray(input2)));

		int[] input3 = { 0, 1, 2, 3, 4 };
	//	System.out.println(Arrays.toString(nextLargestArray(input3)));

		int[] input4 = { 4, 3, 2, 1, 0 };
	//	System.out.println(Arrays.toString(nextLargestArray(input4)));

		int[] input5 = { 4 };
	//	System.out.println(Arrays.toString(nextLargestArray(input5)));
		
		int[] input6 = { 1, 2, 3, 4 };
		int[] nextInput6 = {2,4};
		//System.out.println(Arrays.toString(nextLargestArray(input1)));
		//System.err.println("Leet Code");
		System.out.println(Arrays.toString(nextLargestArrayLeetCode(nextInput6, input6)));

	}

	private static int[] nextLargestArray(int[] nums2) {
		Stack<Integer> s = new Stack<Integer>();
		int len = nums2.length;
		int[] output = new int[len];
		int outputCounter = 0;

		for (int i = len - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				output[outputCounter] = -1;
				outputCounter++;
			}

			else if (!s.isEmpty() && nums2[i] <= s.peek()) {
				output[outputCounter] = s.peek();
				outputCounter++;
			}

			else if (!s.isEmpty() && nums2[i] > s.peek()) {
				while (!s.isEmpty() && nums2[i] > s.peek()) {
					s.pop();
				}
				if (s.isEmpty()) {
					output[outputCounter] = -1;
					outputCounter++;
				} else if (!s.isEmpty()) {
					output[outputCounter] = s.peek();
					outputCounter++;
				}
			}
			s.push(nums2[i]);
		}

		int[] outputRev = reverse(output);
		return outputRev;
	}

	private static int[] reverse(int[] output) {
		int len = output.length;
		for (int i = 0; i < output.length / 2; i++) {
			int temp = output[i];
			output[i] = output[len - i - 1];
			output[len - i - 1] = temp;
		}
		return output;

	}

	// https://leetcode.com/problems/next-greater-element-i/solution/

	private static int[] nextLargestArrayLeetCode(int[] nums1, int[] nums2) {
		Stack<Integer> s = new Stack<Integer>();
		int len = nums2.length;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = len - 1; i >= 0; i--) {
			if (s.isEmpty() || i == len - 1) {
				m.put(nums2[i], -1);
			} else if (!s.isEmpty() && nums2[i] <= s.peek()) {
				m.put(nums2[i], s.peek());
			} else if (!s.isEmpty() && nums2[i] > s.peek()) {
				while (!s.isEmpty() && nums2[i] > s.peek()) {
					s.pop();
				}
				if (s.isEmpty()) {
					m.put(nums2[i], -1);
				} else if (!s.isEmpty()) {
					m.put(nums2[i], s.peek());
				}
			}
			// Important Step
			s.push(nums2[i]);
		}
		
		System.out.println("Printing Interim Map");
		System.out.println(m);
		int[] outputLeetCode = new int[nums1.length];
		for (int j=0;j< nums1.length;j++) {
			outputLeetCode[j]= m.get(nums1[j]);
		}
		
		return outputLeetCode;
	}

}
