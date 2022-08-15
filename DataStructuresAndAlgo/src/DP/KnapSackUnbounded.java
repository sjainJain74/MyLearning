package DP;

public class KnapSackUnbounded {
	public static void main(String[] args) {
// -------------KNAPSACK 0/1 UNBOUNDED (Max profit in cutting the ROD)-------------
		int wt_u[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int val_u[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int w_u = 8;
		int n_u = wt_u.length;

		System.out.println("KNAPSACK 0/1 UNBOUNDED (Max profit in cutting the ROD using recurrsion");
		System.out.println(knapSachRecurrsion_Unbounded(wt_u, val_u, w_u, n_u));
		int[][] dpTopDown_unbounded = createDPInitializeWithFirstRowAndColumn(w_u, n_u);
		System.out.println("KNAPSACK 0/1 UNBOUNDED (Max profit in cutting the ROD using topDown");
		System.out.println(knapSachTopDownUnbounded(wt_u, val_u, w_u, n_u, dpTopDown_unbounded));

//-------------KNAPSACK 0/1 UNBOUNDED (How many combination do I have to create sum =w_c =5)
		// (1,1,1,1,1) and (1,2,2) and (2,3) (3,1,1) (5) ==> 5 possible combination

		int wt_c[] = new int[] { 1, 2, 3 };
		int w_c = 5;
		int n_c = wt_c.length;
		int[][] dpTopDown_unboundedCoin = createDPInitializeWithFirstRowAndColumn(n_c, w_c);
		System.out.println("KNAPSACK 0/1 UNBOUNDED How many combination do I have to create sum =w_c =5");
		System.out.println(knapSachTopDownUnboundedCoinCountOptions(wt_c, w_c, n_c, dpTopDown_unboundedCoin));

//-------------KNAPSACK 0/1 UNBOUNDED (How minimum coins required for getting  sum =w_c =5)
		int wt_c_min[] = new int[] { 3, 2, 1 };
		int w_c_min = 5;
		int n_c_min = wt_c_min.length;
		int[][] dpTopDown_unboundedCoin_min = createDPInitializeWithFirstRowAndColumn(n_c_min, w_c_min);
		System.out.println("KNAPSACK 0/1 UNBOUNDED , Minimum coin to get sum w_c_min (5)");
		System.out.println(knapSachTopDownUnboundedCoinMin(wt_c_min, w_c_min, n_c_min, dpTopDown_unboundedCoin_min));

	}

	private static int[][] createDPInitializeWithFirstRowAndColumn(int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		return dp;
	}

	private static int knapSachTopDownUnbounded(int[] wt, int[] val, int w, int n, int[][] dp) {
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else if (wt[x - 1] <= y) {
					dp[x][y] = Math.max((val[x - 1] + dp[x][y - wt[x - 1]]), dp[x - 1][y]);

				} else {
					// System.out.println("OMG Code is going here???");
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];
	}

	private static int knapSachTopDownUnboundedCoinMin(int[] wt, int w, int n, int[][] dp) {
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0) {
					dp[x][y] = Integer.sum(Integer.MAX_VALUE, -1);
				} else if (y == 0 && x != 0) {
					dp[x][y] = 0;
				} else if (y == 0 && x == 1) {
					dp[x][y] = 0;
				} else if (x == 1 && y != 0) {
					if (y % wt[0] == 0) {
						dp[x][y] = y / wt[0];
					} else {
						dp[x][y] = Integer.sum(Integer.MAX_VALUE, -1);
					}
				} else if (wt[x - 1] <= y) {
					dp[x][y] = Math.min((1 + dp[x][y - wt[x - 1]]), (dp[x - 1][y]));
				} else {
					// System.out.println("OMG Code is going here???");
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];
	}

	private static int knapSachTopDownUnboundedCoinCountOptions(int[] wt, int w, int n, int[][] dp) {
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (y == 0) {
					dp[x][y] = 1;
				} else if (x == 0 && y != 0) {
					dp[x][y] = 0;
				} else if (wt[x - 1] <= y) {
					dp[x][y] = (dp[x][y - wt[x - 1]]) + (dp[x - 1][y]);
				} else {
					// System.out.println("OMG Code is going here???");
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];

	}

	private static int knapSachRecurrsion_Unbounded(int[] wt, int[] val, int w, int n) {
		if (w == 0 || n == 0) {
			return 0;
		} else if (wt[n - 1] > w) {
			return knapSachRecurrsion_Unbounded(wt, val, w, n - 1);
		}
		// (wt[n - 1] <= w)
		else {
			// In Unbounded very small change in code, We have only made n instead of n-1
			return Math.max((val[n - 1] + knapSachRecurrsion_Unbounded(wt, val, w - wt[n - 1], n)),
					(knapSachRecurrsion_Unbounded(wt, val, w, n - 1)));
		}

	}

}
