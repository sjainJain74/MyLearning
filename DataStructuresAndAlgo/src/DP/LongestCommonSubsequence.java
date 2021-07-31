package DP;

public class LongestCommonSubsequence {

	public static void main(String arg[]) {
//LCS using Recursive way 		
		String S1 = "abcdaf";
		String S2 = "acbcf";
		System.out.println("LCS using Recursive way");
		System.out.println(LCS_Recurrion(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length()));

//LCS using recurrsive + memory
		System.out.println("LCS using recurrsive + memory");
		int[][] dp_mem = createDPInitialize_mem(S1.length(), S2.length());
		System.out.println(LCS_DP(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length(), dp_mem));

//LCS using Real DP Approach 
		System.out.println("LCS using Real DP Approch");
		int[][] dp = createDPInitialize(S1.length(), S2.length());
		System.out.println(LCS_DP(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length(), dp));

//LCS using Real DP Approach -->Print
		System.out.println("LCS using Real DP Approch --> Print");
		int[][] dp_print = createDPInitialize(S1.length(), S2.length());
		String lcs = "";
		System.out.println(LCS_DP_Print(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length(), dp_print, lcs));

	}

	private static int[][] createDPInitialize(int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		return dp;
	}

	private static int[][] createDPInitialize_mem(int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else
					dp[x][y] = -1;
			}

		}
		return dp;
	}

	public static int LCS_Recurrion(char[] S1, char[] S2, int n, int w) {
		if (n == 0 || w == 0) {
			return 0;
		} else if (S1[n - 1] == S2[w - 1]) {
			return 1 + LCS_Recurrion(S1, S2, n - 1, w - 1);
		} else {
			return Math.max((LCS_Recurrion(S1, S2, n, w - 1)), (LCS_Recurrion(S1, S2, n - 1, w)));
		}
	}

	public static int LCS_with_memory(char[] S1, char[] S2, int n, int w, int[][] dp) {
		if (n == 0 || w == 0) {
			return dp[n][w] = 0;
		} else if (dp[n][w] == -1) {
			return dp[n][w];
		} else if (S1[n - 1] == S2[w - 1]) {
			return dp[n][w] = 1 + LCS_with_memory(S1, S2, n - 1, w - 1, dp);
		} else {
			return dp[n][w] = Math.max((LCS_with_memory(S1, S2, n, w - 1, dp)),
					(LCS_with_memory(S1, S2, n - 1, w, dp)));
		}

	}

	public static int LCS_DP(char[] S1, char[] S2, int n, int w, int[][] dp) {
		createDP(S1, S2, n, w, dp);
		return dp[n][w];
	}

	public static String LCS_DP_Print(char[] S1, char[] S2, int n, int w, int[][] dp, String lcs) {
		createDP(S1, S2, n, w, dp);
		lcs = printLCSAfterDP(S1, S2, n, w, dp, lcs);
		return lcs;
	}

	private static void createDP(char[] S1, char[] S2, int n, int w, int[][] dp) {
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else if (S1[x - 1] == S2[y - 1]) {
					dp[x][y] = 1 + dp[x - 1][y - 1];

				} else {
					dp[x][y] = Math.max((dp[x][y - 1]), (dp[x - 1][y]));
				}

			}

		}
	}

	private static String printLCSAfterDP(char[] S1, char[] S2, int n, int w, int[][] dp, String lcs) {
		int i = n;
		int j = w;
		while (i > 0 && j > 0) {
			if (S1[i - 1] == S2[j - 1]) {
				lcs = lcs + S2[j - 1];
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					j--;
				} else {
					i--;

				}
			}
		}
		return lcs;
	}
}
