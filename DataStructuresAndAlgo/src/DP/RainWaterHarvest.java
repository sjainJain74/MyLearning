package DP;

public class RainWaterHarvest {

	public static void main(String arg[]) {

		int[] height = { 4, 2, 0, 3, 2, 5 };
		System.out.println(trap(height));

		int[] height2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height2));

	}

	

	private static int trap(int[] height) {

		int left = 0;
		int right = 0;
		int water = 0;

		for (int i = 0; i < height.length; i++) {
			right = maxBarToRight(height, i);
			left = maxBarToLeft(height, i);
			if (Math.min(right, left) - height[i] > 0) {
				water = water + Math.min(right, left) - height[i];
			}
		}
		return water;

	}



	private static int maxBarToLeft(int[] height, int i) {
		int max = 0;
		for (int j = 0; j < i; j++) {
			if (height[j] > max) {
				max = height[j];
			}
		}
		return max;
	}

	private static int maxBarToRight(int[] height, int i) {
		int max = 0;
		for (int j = height.length - 1; j > i; j--) {
			if (height[j] > max) {
				max = height[j];
			}
		}
		return max;
	}

}
