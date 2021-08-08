
public class MyClass {

	public static void main(String arg[]) {

		// int[] length = new int[] { 1, 2, 4, 5 };
		// int[] rate = new int[] { 2, 5, 11, 9 };

		int[] Wt = new int[] { 1, 2, 4, 5 };
		int[] value = new int[] { 2, 5, 11, 9 };
		int W = 6;

		int length = value.length;
		System.out.println(profit(Wt, value, length, W));
		// 0/1 Unbounded Knapsack
		// 4 ->11 2-->5 -->16

		int[][] dp = new int[length + 1][W + 1];

		System.out.println(profitWothMemo(Wt, value, length, W, dp));

		int[][] dp_top = new int[length + 1][W + 1];
		System.out.println(profitWithTopDown(Wt, value, length, W, dp_top));
		
		//int[][] dp_top_code = new int[length + 1][W + 1];
		//System.out.println(knapSachTopDownUnbounded(Wt, value, length, W, dp_top_code));

	}
	
	

	private static int profit(int[] length, int[] rate, int n, int l) {
		// Base condition
		if (n == 0 || l == 0) {
			return 0;
		}
		if (length[n - 1] > l) {
			return profit(length, rate, n - 1, l);

		} else {
			int first = rate[n - 1] + profit(length, rate, n, l - length[n - 1]);
			int second = profit(length, rate, n - 1, l);
			return Math.max(first, second);

		}

	}

	private static int profitWothMemo(int[] length, int[] rate, int n, int l, int[][] dp) {

		/// O(n2)

		// Base condition
		if (n == 0 || l == 0) {
			return 0;
		}

		if (dp[n][l] != 0) {
			return dp[n][l];
		} else if (length[n - 1] > l) {
			return dp[n][l] = profit(length, rate, n - 1, l);

		} else {
			int first = rate[n - 1] + profit(length, rate, n, l - length[n - 1]);
			int second = profit(length, rate, n - 1, l);
			return dp[n][l] = Math.max(first, second);
		}
	}

	private static int profitWithTopDown(int[] length, int[] rate, int n, int l, int[][] dp) {
		/// O(n2)
		// l ->y
		// n ->x
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < l + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else if (length[x - 1] > y) {
					 dp[x][y] = dp[x - 1][y];

				} else {
					 dp[x][y] = Math.max(rate[x - 1] + dp[x][y - length[x - 1]], dp[x - 1][y]);
				}

			}
		}
		return dp[n][l];
	}

}