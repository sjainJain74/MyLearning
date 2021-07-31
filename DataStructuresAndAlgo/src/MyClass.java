
public class MyClass {

	public static void main(String arg[]) {

		/*
		 * int[] height = { 4, 2, 0, 3, 2, 5 }; System.out.println(trap(height));
		 * 
		 * int[] height2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		 * System.out.println(trap(height2));
		 */

		/*
		 * Given a rod of length n meters and price of various sizes, write an algorithm
		 * to yield maximum profit by cutting down the rod. For ex: 1m rod costs 2$, 2m
		 * costs 5$, 4m cost 11$ & 5m costs 9$ and you have 6m length rod available in
		 * your inventory.
		 */

		// [1,2,4,5] ->Length
		// [2,5,11,9] ->Rate

		//

		// 6 Meter --> 2*6 =12 -->Maximise!

		// MaxProfit =

		// Profit(l,n) = Max (rate[n-1] + Profit(n-1,l-length[n-1]) , Profit(n-1,l))

		int[] length = new int[] { 1, 2, 4, 5 };
		int[] rate = new int[] { 2, 5, 11, 9 };
		int l = 6;

		System.out.println(profit(length, rate, rate.length, l));

		// 4 ->11 2-->5 -->16
		// 222 -->15
		/// 111111-->12
		///

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
		// Base condition

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < l; y++) {
				
				if (length[n - 1] > l) {
					return dp[x][y] = profitWothMemo(length, rate, n - 1, l, dp);

				} else {
					int first = rate[n - 1] + profitWothMemo(length, rate, n, l - length[n - 1], dp);
					int second = profitWothMemo(length, rate, n -1 , l, dp);
					return dp[x][y] = Math.max(first, second);

				}
			}
		}
		return l;

	}
}
