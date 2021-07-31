package DP;

public class LongestCommonSubstring {

	public static void main(String arg[]) {
//LCS using Recursive way 		
		String S1 = "abcde";
		String S2 = "abed";
		System.out.println("LCSubs using Recursive way Yet to write ????");

//LCS using Real DP Approach 
		System.out.println("LCSubstring using Real DP Approch");
		int[][] dp = createDPInitialize(S1.length(), S2.length());
		System.out.println(LCS_Substring_DP(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length(), dp));

	}

	private static int[][] createDPInitialize(int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		return dp;
	}

	public static int LCS_Substring_DP(char[] S1, char[] S2, int n, int w, int[][] dp) {
		int maxDP = 0;
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else if (S1[x - 1] == S2[y - 1]) {
					dp[x][y] = 1 + dp[x - 1][y - 1];
					if (maxDP < dp[x][y]) {
						maxDP = dp[x][y];
					}
				} else {
					dp[x][y] = 0;
				}

			}

		}
		return maxDP;
	}
}
