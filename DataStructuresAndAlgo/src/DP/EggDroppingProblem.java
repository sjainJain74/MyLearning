package DP;

public class EggDroppingProblem {

	public static void main(String arg[]) {
		int e = 3;
		int f = 10;

		System.out.println("Egg dropping with Regression, Still giving Time Out");
		System.out.println(superEggDropWithRegression(e, f));

		System.out.println("Egg dropping Top Down DP, Still giving Time Out");
		System.out.println(superEggDropWithTopDown(e, f));

		System.out.println("Egg dropping BottomUP DP with Binary Search");
		System.out.println(superEggDrop(e, f));
		
		System.out.println("Egg dropping TopUP DP with Binary Search");
		System.out.println(superEggDropWithTopDown_withBinarySearch(e, f));

	}

	public static int superEggDrop(int e, int f) {
		int[][] dp = createInitialDP(e, f);
		return superEggDropWithMemoziationWithBinarySearch(e, f, dp);

	}

	private static int[][] createInitialDP(int e, int f) {
		int[][] dp = new int[e + 1][f + 1];
		for (int x = 0; x < e + 1; x++) {
			for (int y = 0; y < f + 1; y++) {
				dp[x][y] = -1;
			}
		}
		return dp;
	}

	// Using Regression
	public static int superEggDropWithRegression(int k, int n) {
		// Base Condition
		// If we have 1 egg we need n attempts. Start from lowest floor (1.2.3....n)
		if (k == 1) {
			return n;
		}
		// If number of floor is zero or one we will need zero or one attempt
		else if (n == 0 || n == 1) {
			return n;
		} else {
			int minAttempt = Integer.MAX_VALUE;

			for (int i = 1; i <= n; i++) {
				int tempMin = 1
						+ Math.max(superEggDropWithRegression(k - 1, i - 1), superEggDropWithRegression(k, n - i));
				minAttempt = Math.min(tempMin, minAttempt);
			}
			return minAttempt;
		}

	}

	public static int superEggDropWithMemoziationWithBinarySearch(int k, int n, int[][] dp) {
		// Base Condition If we have 1 egg we need n attempts. Start from lowest floor
		// (1.2.3....n)
		if (k == 1) {
			return n;
		}
		// If number of floor is zero or one we will need zero or one attempt
		else if (n == 0 || n == 1) {
			return n;
		} else if (dp[k][n] != -1) {
			return dp[k][n];
		}

		else {
			int low = 0;
			int high = n;
			int breakCount;
			int nonBreaKCount;
			while (low < high) {
				int mid = low + (high - low) / 2;
				breakCount = dp[k - 1][mid - 1] != -1 ? dp[k - 1][mid - 1]
						: superEggDropWithMemoziationWithBinarySearch(k - 1, mid - 1, dp);
				nonBreaKCount = dp[k][n - mid] != -1 ? dp[k][n - mid]
						: superEggDropWithMemoziationWithBinarySearch(k, n - mid, dp);

				if (breakCount == nonBreaKCount) {
					dp[k][n] = 1 + Math.max(breakCount, nonBreaKCount);
					break;
				} else if (breakCount < nonBreaKCount) {
					low = mid + 1;
				} else {
					high = mid;
				}
				dp[k][n] = 1 + Math.max(breakCount, nonBreaKCount);

			}

		}
		return dp[k][n];

	}

	public static int superEggDropWithTopDown(int e, int n) {

		int[][] dp = new int[e + 1][n + 1];

		for (int i = 1; i <= e; i++) { // number of eggs
			for (int j = 1; j <= n; j++) { // number of floors

				// Base condition
				if (j == 1) {
					dp[i][j] = 1;
				}

				else if (i == 1) {
					dp[i][j] = j;
				}

				else {

					int minAttempt = Integer.MAX_VALUE;

					for (int g = 2; g <= j; g++) {
						int floorMax = 1 + Math.max(dp[i - 1][g - 1], dp[i][j - g]);
						minAttempt = Math.min(floorMax, minAttempt);
						dp[i][j] = minAttempt;
					}

				}
			}

		}
		return dp[e][n];

	}

	public static int superEggDropWithTopDown_withBinarySearch(int e, int n) {

		int[][] dp = new int[e + 1][n + 1];

		for (int i = 1; i <= e; i++) { // number of eggs
			for (int j = 1; j <= n; j++) { // number of floors

				// Base condition
				if (j == 1) {
					dp[i][j] = 1;
				}

				else if (i == 1) {
					dp[i][j] = j;
				}

				else {
					int mid = 0;
					int low = 0;
					int high = j;
					while (low < high) {
						// for (int g = 2; g <= j; g++) {
						mid = low + (high - low) / 2;
						int breaks = dp[i - 1][mid - 1]; //
						int doNotBreak = dp[i][j - mid];

						if (breaks == doNotBreak) {
							dp[e][n] = 1 + Math.max(breaks, doNotBreak);
							break;
						}
						if (breaks > doNotBreak) {
							low = mid + 1;
						}
						else {
							high = mid - 1;
						}
						/*
						 * int floorMax = 1 + Math.max(a, b); minAttempt = Math.min(floorMax,
						 * minAttempt); dp[i][j] = minAttempt;
						 */
					}
					dp[e][n] = 1 + Math.max(dp[i - 1][mid - 1], dp[i][j - mid]);

				}
			}
		}
		return dp[e][n];
	}
}