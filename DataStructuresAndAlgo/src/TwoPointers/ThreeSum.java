package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String arg[]) {
		// learnHashSet();
		int[] input = new int[] { 2, -1, -1 };
		System.out.println("Input to 3 Sum" + Arrays.toString(input));
		// System.out.println("OutPut to 3 Sum" + threeSum(input));

		System.out.println();

		// https://leetcode.com/problems/3sum/solution/
		// O(nlogn+n2)
		int[] input2 = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println("Input to 3 Sum" + Arrays.toString(input2));
		System.out.println("OutPut to 3 Sum" + threeSum_leetcode(input2));

		int[] input3 = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println("Input to 3 Sum" + Arrays.toString(input3));
		System.out.println("OutPut to 3 Sum" + threeSum_leetcode(input3));
		threeSumUsingHashSet(input3);
		
		
		int[] input4 = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println("Input to 3 Sum" + Arrays.toString(input4));
		System.out.println("OutPut to 3 Sum " + threeSumMulti(input4));

	}

	private static List<List<Integer>> threeSum_leetcode(int[] input) {
		Arrays.sort(input); // Step 1: Sort the Array

		// We cannot store this in set as [2 -1 -1] input will hav output expected as [2
		// -1 -1]. But if we store input as set We will loose this case.
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < input.length - 2; i++) {
			// Avoid dubli number call [-4,-4,-1,-1,-1,2,3,4,4,4] for -4 we shoud do only
			// one call , skip next call for -4
			if (i == 0 || (input[i] != input[i - 1])) {
				// If you do input[i] != input[i+1] than you will miss [-1,-1,2]
				int target = input[i];
				twosumForAllComExceptDub(output, input, i, target);
			}
		}
		return output;
	}

	private static List<List<Integer>> threeSumUsingHashSet(int[] input) {
		Arrays.sort(input); // Step 1: Sort the Array

		Set<List<Integer>> output = new HashSet<List<Integer>>();
		for (int i = 0; i < input.length - 2; i++) {
			twosum(output, input, i, input[i]);
		}

		// This is way to convert Set into List
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		l.addAll(output);
		return l;
		// alternative and small way new ArrayList<>(output);
	}
	
	
	private static int threeSumMulti(int[] input) {
		Arrays.sort(input); // Step 1: Sort the Array

		int output = 0;;
		for (int i = 0; i < input.length - 2; i++) {
			output = output + twosumForCount( input, i, input[i]);
		}

		// This is way to convert Set into List
		return output;
		// alternative and small way new ArrayList<>(output);
	}

	private static void twosum(Set<List<Integer>> output, int[] input, int i, int target) {

		int start = i + 1;
		int end = input.length - 1;
		while (start < end) {

			if (target + input[start] + input[end] == 0) {
				// List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
				// Good Syntax to add multiple elements in arraylist
				/*
				 * This is long approach List<Integer> l = new ArrayList<Integer>();
				 * l.add(target); l.add(input[start]); l.add(input[end]);
				 */
				output.add(Arrays.asList(target, input[start], input[end])); // Maintain this sequence please.

				start++;
				end--;
			}

			else if (input[start] + input[end] + target > 0) {
				end--;
			} else
				start++;

		}

	}
	
	private static int  twosumForCount( int[] input, int i, int target) {
        int output=0;
		int start = i + 1;
		int end = input.length - 1;
		while (start < end) {

			if (target + input[start] + input[end] == 0) {
				// List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
				// Good Syntax to add multiple elements in arraylist
				/*
				 * This is long approach List<Integer> l = new ArrayList<Integer>();
				 * l.add(target); l.add(input[start]); l.add(input[end]);
				 */
				output++; // Maintain this sequence please.
				start++;
				end--;
			}

			else if (input[start] + input[end] + target > 0) {
				end--;
			} else
				start++;

		}

		return output;
	}

	private static void twosumForAllComExceptDub(List<List<Integer>> output, int[] input, int i, int target) {

		int start = i + 1;
		int end = input.length - 1;
		while (start < end) {

			if (target + input[start] + input[end] == 0) {
				// List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
				// Good Syntax to add multiple elements in arraylist
				/*
				 * This is long approach List<Integer> l = new ArrayList<Integer>();
				 * l.add(target); l.add(input[start]); l.add(input[end]);
				 */
				output.add(Arrays.asList(target, input[start], input[end]));

				// Below code avoids scenario for dubli to be added.
				// [-4,-4,-1,-1,-1,0,0,1,1,3,3,4,4,4]
				// In this scenario we skip 1 coming dubli
				while (start < end && input[start] == input[start + 1]) {
					start++;
				}
				// In this scenario we skip 3 coming dubli
				while (start < end && input[end] == input[end - 1]) {
					end--;
				}

				start++;
				end--;
			}

			else if (input[start] + input[end] + target > 0) {
				end--;
			} else
				start++;

		}

	}

	private static List<List<Integer>> threeSumFirstAttempt_Not_good(int[] input) {
		int N = input.length;

		// Add all numbers as key and value as index
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(input[i])) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(input[i], l);
			} else {
				map.get(input[i]).add(i);
			}

		}

		Map<Integer, LinkedList<int[]>> mapSum = new HashMap<>();

		for (int x = 0; x < N; x++) {
			for (int y = x + 1; y < N; y++) {

				int sum = input[x] + input[y];
				if (!mapSum.containsKey(sum)) {
					LinkedList<int[]> listOftuple = new LinkedList<int[]>();
					listOftuple.add(new int[] { input[x], input[y] });
					mapSum.put(sum, listOftuple);
				}

				else {
					LinkedList<int[]> linkedList = mapSum.get(sum);
					linkedList.add(new int[] { input[x], input[y] });
				}

			}
		}
		return null;

		// This approach need one more loop and this will be complex. Not worth it.

	}

	private static void learnHashSet() {
		int[] input = new int[] { -1, 0, -1 }; // () not required

		// int[] input = new int[] { 7, 6 };

		System.out.println("Before ThreeSum" + Arrays.toString(input));
		System.out.println(threeSumFirstAttempt_Not_good(input));
		System.out.println("After sortingColors_75" + Arrays.toString(input));

		Set<int[]> s = new HashSet<int[]>();
		s.add(new int[] { 1, 2 });
		s.add(new int[] { 1, 2 });
		s.add(new int[] { 3, 2 });
		// We can add dublicates as int[] do not have equals and hash code.
		System.out.println(s);

		Set<Integer> s2 = new HashSet<Integer>();
		s2.add(1);
		s2.add(2);
		s2.add(2);
		System.out.println(s2);

		Set<List<Integer>> s3 = new HashSet<List<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(2);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(2);
		a3.add(1);

		s3.add(a1);
		s3.add(a2);
		s3.add(a3);
		// We can not add dublicates as List<Integer> do have equals and hash code.
		System.out.println(s3);
	}
}
