package DP;

import java.util.ArrayList;

public class KnapSack01 {

	public static void main(String[] args) {

		// ------------0/1 KNAPSACK--------------------

		int wt[] = new int[] { 1, 3, 4, 5 };
		int val[] = new int[] { 1, 4, 5, 7 };
		int w = 7;
		int n = wt.length;
		
		
		Boolean[] boo = new Boolean [2];
		System.out.print(boo[0]);
		System.out.print(boo[1]);
		
		
// Approach 1 with Recurrsion
		System.out.println("Approach 1 with Recurrsion");
		System.out.println(knapSachRecurrsion(wt, val, w, n));
		
		System.out.println("Approach 1 with Recurrsion and getting the array also");
		ArrayList<Integer> list = new ArrayList();
		System.out.println(isIncluded(wt, val, w, n,list));
		System.out.println(list);
		
		// init the DP with -1 value
		int[][] dp = createDPInitialize(w, n);
		
// Approach 2 with Recurrsion + Moemoziation
		System.out.println("Approach 2 with Recurrsion + Moemoziation");
		System.out.println(knapSachRecurrsionWithMeoziation(wt, val, w, n, dp));
		// Init the DP with 0 value for x,y=0

// Approach 3 with Top Down Apporach Best One
		System.out.println("Approach 3 with Top Down Apporach Best One");
		int[][] dpTopDown = createDPInitializeWithFirstRowAndColumn(w, n);
		System.out.println(knapSachTopDown(wt, val, w, n, dpTopDown));

// -----------SubSet Sum Problem, Do we have a subset with sum = w_subs ------
// ---------- Can we Divide the array into two partition  with sum = w_subs---
// Example equal count (18/2 =9) Answer =Yes

		// Question --> Do we have subset which has sum w_subs (4) -->(3,2) (5)
		int wt_sub[] = new int[] { 1, 5, 3, 2, 7 };
		// int w_subs = 12; //Should Return false
		int w_subs = 5; // Should Return True
		int n_subs = wt_sub.length;

		boolean[][] dpTopDownContainSum = createDPContanSum(w_subs, n_subs);
		System.out.println("Do we have subset which has sum =w_subs");
		System.out.println(knapSachTopDownContainSum(wt_sub, w_subs, n_subs, dpTopDownContainSum));

// -----------Count number of subset which has sum = w_subs ------		
		int[][] dpTopDownCountOfSubsets = createDPCountOfSubset(w_subs, n_subs);
		System.out.println("Count number of subset which has sum = w_subs");
		System.out.println(knapSachTopDownCountOfSubset(wt_sub, w_subs, n_subs, dpTopDownCountOfSubsets));

	}

	private static int[][] createDPInitializeWithFirstRowAndColumn(int w, int n) {
		int[][] dp = new int[n + 1][w + 1];

		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				}

			}
		}
		return dp;
	}

	private static boolean[][] createDPContanSum(int w, int n) {
		boolean[][] dp = new boolean[n + 1][w + 1];

		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 & y == 0) {
					dp[x][y] = true;
				}
				if (y == 0) {
					dp[x][y] = true;
				}
				if (x == 0 && y != 0) {
					dp[x][y] = false;
				}
			}
		}
		return dp;
	}

	private static int[][] createDPCountOfSubset(int w, int n) {
		int[][] dp = new int[n + 1][w + 1];

		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 & y == 0) {
					dp[x][y] = 1;
				}
				if (y == 0) {
					dp[x][y] = 1;
				}
				if (x == 0 && y != 0) {
					dp[x][y] = 0;
				}
			}
		}
		return dp;
	}

	private static int knapSachTopDown(int[] wt, int[] val, int w, int n, int[][] dp) {
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				if (x == 0 || y == 0) {
					dp[x][y] = 0;
				} else if (wt[x - 1] <= y) {
					dp[x][y] = Math.max((val[x - 1] + dp[x - 1][y - wt[x - 1]]), dp[x - 1][y]);

				} else {
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];
	}

	private static boolean knapSachTopDownContainSum(int[] wt_sub, int w, int n, boolean[][] dp) {

		for (int x = 1; x < n + 1; x++) {
			for (int y = 1; y < w + 1; y++) {

				if (wt_sub[x - 1] <= y) {
					dp[x][y] = (dp[x - 1][y - wt_sub[x - 1]]) || (dp[x - 1][y]);

				} else {
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];
	}

	private static int knapSachTopDownCountOfSubset(int[] wt_sub, int w, int n, int[][] dp) {

		for (int x = 1; x < n + 1; x++) {
			for (int y = 1; y < w + 1; y++) {

				if (wt_sub[x - 1] <= y) {
					dp[x][y] = (dp[x - 1][y - wt_sub[x - 1]]) + (dp[x - 1][y]);

				} else {
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n][w];
	}

	private static int knapSachRecurrsionWithMeoziation(int[] wt, int[] val, int w, int n, int[][] dp) {
		if (w == 0 || n == 0) {
			return 0;
		} else if (dp[n][w] != -1) {
			return dp[n][w];

		} else if (wt[n - 1] > w) {
			dp[n][w] = knapSachRecurrsionWithMeoziation(wt, val, w, n - 1, dp);
			return dp[n][w];
		}
		// (wt[n - 1] <= w)
		else {
			return dp[n][w] = Math.max(
					(val[n - 1] + knapSachRecurrsionWithMeoziation(wt, val, w - wt[n - 1], n - 1, dp)),
					(knapSachRecurrsionWithMeoziation(wt, val, w, n - 1, dp)));
		}

		// TODO Auto-generated method stub

	}

	private static int knapSachRecurrsion(int[] wt, int[] val, int w, int n) {

		if (w == 0 || n == 0) {
			return 0;
		} else if (wt[n - 1] > w) {
			return knapSachRecurrsion(wt, val, w, n - 1);
		}
		// (wt[n - 1] <= w)
		else {
			return Math.max((val[n - 1] + knapSachRecurrsion(wt, val, w - wt[n - 1], n - 1)),
					(knapSachRecurrsion(wt, val, w, n - 1)));
		}
	}

	
	private static int isIncluded(int[] wt, int[] val, int w, int n, ArrayList<Integer> output) {	
		if (w == 0 || n == 0) {
			return 0;
		} else if (wt[n - 1] > w) {
			ArrayList<Integer> subOptimal = new ArrayList();
			//No need to include in outout:)
			subOptimal.addAll(output);
			return isIncluded(wt, val, w, n - 1,subOptimal);
		}
		// (wt[n - 1] <= w)
		else {
			        ArrayList<Integer> subOptimal2 = new ArrayList();
			        ArrayList<Integer> subOptimal3 = new ArrayList();
			        subOptimal2.addAll(output);
			        subOptimal3.addAll(output);
					int take =  isIncluded(wt, val, w - wt[n - 1], n - 1,subOptimal2);
					subOptimal2.add(wt[n - 1]);
					
					int notake= isIncluded(wt, val, w, n - 1,subOptimal3);
					
					if(val[n - 1] +take >notake) {
						return val[n - 1] +take;
					}
					else {
						
						return notake;
					}
		}
	}
		
	
//1 3 4 5
     
//	              0 
	
//	     1                  ~1
	     
//	   3     ~3          3      ~3
	
//	4  ~4   4  ~4     4  ~4   4  ~4 
	
	
	
	private static int[][] createDPInitialize(int w, int n) {
		int[][] dp = new int[n + 1][w + 1];
		for (int x = 0; x < n + 1; x++) {
			for (int y = 0; y < w + 1; y++) {
				// if (x == 0 || y == 0) {
				dp[x][y] = -1;
				// }

			}
		}
		return dp;
	}

}
