package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
		// System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));

		// To do
		// https://leetcode.com/problems/maximum-subarray/
		// https://leetcode.com/problems/subarray-sum-equals-k/
		// https://leetcode.com/problems/minimum-size-subarray-sum/
		// https://leetcode.com/problems/continuous-subarray-sum/
		// https://leetcode.com/problems/sliding-window-maximum/solution/

		// int input[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int input[] = { -1, -1, -7, -15, -15, 0 };
		int k3 = 3;
		// System.out.println(firstNegativeNumber_usingList(input, k2));

		// int input_ll[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		long input_ll[] = { -1, -1, -7, -15, -15, 0 };
		int k_ll = 3;
		// System.out.println(firstNegativeNumber_usingLinkedList(input_ll, k_ll,
		// input_ll.length));

		long input_l_geek[] = { -8, 2, 3, -6, 10 };
		int k_geek = 2;
		/*
		 * System.out.println(
		 * Arrays.toString(firstNegativeNumber_usingLinkedList(input_l_geek,
		 * input_l_geek.length, k_geek)));
		 */

		int arr[] = { -1, -1, 0, 3 };
		int n = arr.length;
		int k1 = 0;
		// System.out.printf("Length = %d", lenOfLongSubarr(arr, n, k1));

		String s1 = "ab";
		String s2 = "eiabc";
		// System.out.println(checkInclusion_Leetcode_567(s1, s2));

		System.out.println(checkInclusion_Leetcode_567_opti(s1, s2));

	}

	public static boolean checkInclusion_Leetcode_567(String s1, String s2) {
		// s1="ab"
		// s2="eiaabc"
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int[] frequeny_ch1 = new int[26];

		// Creating frequency array for small String
		for (int f = 0; f < ch1.length; f++) {
			frequeny_ch1[(int) ch1[f] - (int) 'a']++;
		}

		int i = 0;
		while (i < ch2.length- ch1.length + 1) {
			// Itr for one window 0-2, 1-3
			int[] frequeny_ch2 = new int[26];
			for (int x = i; x < i + ch1.length; x++) {
				frequeny_ch2[(int) ch2[x] - (int) 'a']++;
			}

			if (Arrays.equals(frequeny_ch1, frequeny_ch2)) {
				return true;
			} else {
				i++;
			}

		}

		
		return false;

	}

	public static boolean checkInclusion_Leetcode_567_opti(String s1, String s2) {
		// s1="ab"
		// s2="eiabc"
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int[] frequeny_ch1 = new int[26];
		int[] frequeny_ch2 = new int[26];
		

		// Creating frequency array for small String
		for (int f = 0; f < ch1.length; f++) {
			frequeny_ch1[ch1[f] - 'a']++;
			frequeny_ch2[ch2[x] - 'a']++;

		}

		for (int x = ch1.l < ch2.length; x++) {
			frequeny_ch2[ch2[x - 1] - 'a']--;
			frequeny_ch2[ch2[x] - 'a']++;
			if (Arrays.equals(frequeny_ch1, frequeny_ch2)) {
				return true;
			}
		}

		return false;

	}

	public static List<Integer> firstNegativeNumber_usingList(int[] input, int k) {
		int N = input.length;
		int i = 0;
		int j = 0;
		List<Integer> allNegative = new ArrayList();
		List<Integer> output = new ArrayList();

		while (j < N - 1) {

			// We are yet to get a window
			if (j - i < k - 1) {
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}
				j++;
			}
			// We get a window
			else if (j - i == k - 1) {
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}
				if (input[i] < 0) {
					allNegative.remove(0);
				}
				if (allNegative.size() != 0) {
					// In Array list we have method for get(Index)
					output.add(allNegative.get(0));

				} else {
					output.add(0);
				}

				j++;
				i++;
			}
		}
		return output;
	}

	// Working solution for leetcode
	public static long[] firstNegativeNumber_usingLinkedList(long[] input, int N, int k) {
		int i = 0;
		int j = 0;
		int outputIndex = 0;
		long[] outPutArray = new long[N - k + 1];
		Deque<Long> allNegative = new LinkedList<Long>();

		while (j < N) {

			// We are yet to get a window This will only run K times initially
			if (j - i < k - 1) {
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}
				j++;
			}
			// Once we get a window, We will always move i and j so that we maintain the
			// size of 3
			else if (j - i == k - 1) {
				// Add that number if that is negative we need to add first , So that we can add
				// that to output.
				// [-8,1] -->K=2 we should add -8 so that we can get that in answer.
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}

				if (allNegative.size() != 0) {
					// In Array list we have method for get(Index)
					outPutArray[outputIndex] = allNegative.getFirst();
					outputIndex++;

				} else {
					outPutArray[outputIndex] = 0;
					outputIndex++;
				}

				if (input[i] < 0) {
					allNegative.removeFirst();
				}

				i++;
				j++;
			}
		}
		return outPutArray;
	}

	public long[] printFirstNegativeInteger_diplav(long A[], int N, int K) {
		List<Long> list = new ArrayList<>();
		Deque<Long> deque = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (A[i] < 0) {
				deque.addLast(A[i]);
			}
		}
		if (!deque.isEmpty()) {
			list.add(deque.peekFirst());
		} else {
			list.add(0l);
		}
		for (int i = K; i < A.length; i++) {
			// Add at the end of Queue
			if (A[i] < 0) {
				deque.addLast(A[i]);
			}
			// Remove from Front,if the sliding window element(the last leement after the
			// window has slided) matches the
			// array element , then remove it as it will not be a part of new slide
			if (!deque.isEmpty() && A[i - K] == deque.peekFirst()) {
				deque.removeFirst();
			}
			if (!deque.isEmpty()) {
				list.add(deque.peekFirst());
			} else {
				list.add(0l);
			}
		}
		long[] res = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static long[] firstNegativeNumber_usingLinkedList_As_Queue(long[] input, int N, int k) {
		int i = 0;
		int j = 0;
		int outputIndex = 0;
		long[] outPutArray = new long[N - k + 1];
		Deque<Long> allNegative = new LinkedList<Long>();

		// LinkedList is implemented over Deque
		// pollFirst() return null do not throw exception, getFirst throws no such
		// element exeption

		while (j < N) {

			// We are yet to get a window This will only run K times initially
			if (j - i < k - 1) {
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}
				j++;
			}
			// Once we get a window, We will always move i and j so that we maintain the
			// size of 3
			else if (j - i == k - 1) {
				// Add that number if that is negative
				if (input[j] < 0) {
					allNegative.add(input[j]);
				}

				if (allNegative.size() != 0) {
					// In Array list we have method for get(Index)
					outPutArray[outputIndex] = allNegative.pollFirst();
					outputIndex++;

				} else {
					outPutArray[outputIndex] = 0;
					outputIndex++;
				}

				if (input[i] < 0) {
					allNegative.pollFirst();
				}

				i++;
				j++;
			}
		}
		return outPutArray;
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
		outputArray[0] = 0;
		for (int x = 0; x < k; x++) {
			if (nums[x] < 0) {
				outputArray[0] = nums[x];
				break;
			}
		}

		while (j != length - 1) {

			if (nums[j + 1] > 0 && nums[i] > 0) {

			}
			sum = sum + nums[j + 1] - nums[i];
			outputArray[z] = sum;
			z++;
			i++;
			j++;

		}

		return outputArray;

	}

	static int lenOfLongSubarr(int A[], int N, int K) {

		int i = 0, j = 0, sum = 0;
		int maxLen = Integer.MIN_VALUE;

		while (j < N) {
			sum += A[j];
			if (sum < K) {
				j++;
			} else if (sum == K) {
				maxLen = Math.max(maxLen, j - i + 1);
				j++;
			} else if (sum > K) {
				while (sum > K) {
					sum -= A[i];
					i++;
				}
				if (sum == K) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
				j++;
			}
		}
		return maxLen;
	}

	// Variable window
	public static int lengthOfLongestSubstring_LeetCode_3(String s) {
		// abcabcbb -->3 abc
		// abcad -->4 bcad
		// "" ->0
		// "a" -->a 1
		// abc-->3
		int max = 0;
		int i = 0;
		int j = 0;
		char[] ch = s.toCharArray();
		int N = ch.length;
		Set<Character> set = new HashSet<Character>();

		while (j < N) {
			if (!set.contains(ch[j])) {
				set.add(ch[j]);
				max = Math.max(j - i + 1, max); // This is required for abc or a input
				j++;
			} else {
				// max = Math.max(j - i, max);
				set.remove(ch[i]);
				i++;
				// Not doing j++ as we have variable window.

			}
		}

		return max;

	}

	// Variable window
	public static int lengthOfLongestSubstring_LeetCode_3_secondWay(String s) {
		// abcabcbb -->3 abc
		// abcad -->4 bcad
		// "" ->0
		// "a" -->a 1
		// abc-->3
		int max = 0;
		int i = 0;
		int j = 0;
		char[] ch = s.toCharArray();
		int N = ch.length;
		// Set<Character> set = new HashSet<Character>();
		int[] frequencyArray = new int[256];
		// By default int array takes zero
		Arrays.toString(frequencyArray);

		while (j < N) {
			// This is the way to get the ascii code for any character.
			int ascii = (int) ch[j];
			if (!(frequencyArray[ascii] == 1)) {
				frequencyArray[ascii] = 1;
				max = Math.max(j - i + 1, max); // This is required for abc or a input
				j++;
			} else {
				// max = Math.max(j - i, max);
				ascii = (int) ch[i];
				frequencyArray[ascii] = 0;
				i++;
				// Not doing j++ as we have variable window.

			}
		}

		return max;

	}

}
