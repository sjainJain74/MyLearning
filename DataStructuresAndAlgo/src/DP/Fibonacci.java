package DP;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		// 0,1,1,2,3,5,8,13,21,34 ....
		// F0 =0
		// F1 =1
		// F(n) = F(n-1)+F(n-2)
		// 2^n is the Time Complexity
		// O(n) considering the stack call
		System.out.println(fibRecussive(6));
		System.out.println(fibDpOtimized(6));
		System.out.println(fibDp(6));
	}

	public static int fibDpOtimized(int n) {
		// 0,1,1,2,3,5,8,13,21,34 ....
		// F0 =0
		// F1 =1
		// F(n) = F(n-1)+F(n-2)
		int fibCurr = 0 ;
		int fib_last =1;
		int fib_second_last =0;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		for (int x = 2; x <= n; x++) {
			fibCurr = fib_last + fib_second_last;
			fib_second_last = fib_last;
			fib_last = fibCurr;
		}
		return fibCurr;
	}

	public static int fibDp(int n) {
		// 0,1,1,2,3,5,8,13,21,34 ....
		// F0 =0
		// F1 =1
		// F(n) = F(n-1)+F(n-2)
		int[] fi = new int[n + 2];
		fi[0] = 0;
		fi[1] = 1;

		if (n == 0) {
			return fi[0];
		}
		if (n == 1) {
			return fi[1];
		}

		for (int x = 2; x <= n; x++) {
			fi[x] = fi[x - 1] + fi[x - 2];

		}
		return fi[n];
	}

	public static int fibRecussive(int n) {
		// 0,1,1,2,3,5,8,13,21,34 ....
		// F0 =0
		// F1 =1
		// F(n) = F(n-1)+F(n-2)
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		else {
			return fibRecussive(n - 1) + fibRecussive(n - 2);
		}

	}
}