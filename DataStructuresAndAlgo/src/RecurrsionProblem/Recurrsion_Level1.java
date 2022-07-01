package RecurrsionProblem;

import java.util.Arrays;

public class Recurrsion_Level1 {

	public static void main(String arg[]) {
		/*
		 * System.out.println(myPow(1, 1)); System.out.println(myPow(2, -3));
		 * System.out.println(myPow(3, -4)); System.out.println(myPow(-3, -3));
		 * System.out.println(myPow(-3, 1)); System.out.println(myPow(-3, 0));
		 * System.out.println(myPow(-3, -5));
		 */

		// System.out.println(myPow_first_Attempt_recurrsion(0.01, 10));
		// System.out.println(myPow(1, 3));
		// System.out.println(myPow(-2, -3));

		// System.out.println(myPow(2.00000, -2147483647));
		// System.out.println(myPow_first_Attempt_recurrsion(2, 10));
		char[] input = new char[] { 'a', 'b', 'c', 'd' };
		System.out.println(Arrays.toString(input));
		reverse(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
		
		char[] input_iterative = new char[] { 'a', 'b', 'c', 'd' };
		System.out.println(Arrays.toString(input_iterative));
		reverse_Iterative(input_iterative);
		System.out.println(Arrays.toString(input_iterative));
		

		char[] input_iterative2 = new char[] { 'a', 'b', 'c', 'd' ,'e'};
		System.out.println(Arrays.toString(input_iterative2));
		reverse_Iterative(input_iterative2);
		System.out.println(Arrays.toString(input_iterative2));

	}

	public static void reverse(char[] input, int i, int j) {
		if (i >= j) {
			return;
		} else {
			// swap
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			reverse(input, i + 1, j - 1);
		}
	}

	public static void reverse_Iterative(char[] input) {
		int i = 0;
		int j = input.length - 1;
		while (i <= j) {
			// swap
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;

		}
	}

	// this is failing as x is integer. it ranges from 2^32 to -2^32 -1.
	// Thus blindly converting x --> -x will backfire in case of corner case when x
	// = 2^32 , Thus we can take long
	// Thus convert to long.

	// int 4 byte
	// long 8 byte
	// float 4 byte
	// double 8 byte

	// Solution is highly optimized.

	public static double myPow_first_Attempt_recurrsion(double x, long n) {
		if (x == 1 || n == 0 || x == 1) {
			return 1;
		} else if (n < 0) {
			long N = -n;
			return (1 / x) * myPow_first_Attempt_recurrsion((1 / x), N - 1);
		}

		else {
			return x * myPow_first_Attempt_recurrsion(x, n - 1);
		}

	}

	// TLE exception.
	public static double myPow_Iterative(double x, int n) {
		double result = 1;
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			for (int i = 0; i < n; i++) {
				result = result * x;
			}
		} else {
			long N = -n;
			for (int j = 0; j < N; j++) {
				result = result * 1 / x;
			}
		}
		return result;

	}

	public static double myPow(double x, int n) {
		return myShashankPow(x, n);
	}

	public static double myShashankPow(double x, long n) {
		if (x == 1 || n == 0 || x == 0) {
			return 1;
		}
		long N = n;
		;
		if (N < 0) {
			N = -n;
			x = 1 / x;
		}
		if (n % 2 == 0) {
			// return myShashankPow(x*x,N/2);
			double y = myShashankPow(x, N / 2);
			return y * y;
		} else {
			double z = myShashankPow(x, N / 2);
			return z * z * x;
			// return x*myShashankPow(x*x,N/2);

		}
	}

}
