package hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (m.containsKey(diff) && m.get(diff) != i) {
				return new int[] { i, m.get(diff) };
			}

		}
		return new int[] { -1, -1 };
	}
}