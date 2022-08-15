package BitManipulation;

public class BitManipulationCode {

	public static void main(String arg[]) {

		// LearningBasics();
		int n = 00000000000000010001011;
		// System.out.println(hammingWeight(n));

		// int n1 = 0000010100101000001111010011100;

		System.out.println(leetcode_7_reverse(31));

	}

	public static int leetcode_7_reverse(int x) {
		int res = 0;
		int rem = 0;
		while (x > 0) {
			rem = x % 10;
			
			res = 10 * rem + res;
			x = x / 10;
		}

		return res;
	}

	public int reverseBits_from_Discussion(int n) {

		if (n == 0)
			return 0;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			if ((n & 1) == 1)
				result++;
			n >>= 1;
		}
		return result;
	}

	public int reverseBits(int n) {

		int output = 0;

		for (int i = 0; i < 32 & n != 0; i++) {
			output = output + (n & 1);
			output = output << 1;
			n = n >>> 1;
		}
		return output;

	}

	public static int leetcode_190(int n) {

		int output = 0;
		for (int i = 0; i < 32 & n != 0; i++) {
			output = output + (output & 1);
			output = output << 1;
			i = i >>> 1;
			// output = output + (output & 1);
			// output <<< 1;
			// input >>> 1;
		}
		return output;

	}

	public static int leetcode_190_second_attempt(int n) {
		int output = 0;

		for (int i = 0; i < 32 & n != 0; i++) {

			output = output + (n & 1);
			output = output << 1;
			n = n >>> 1;
		}
		return output;

	}

	public static int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			// Foing
			if ((n & 1) == 1) {
				res++;
			}
			n = n >> 1;
		}
		return res;

	}

	private static void LearningBasics() {
		/*
		 * int i = 10; int j = -10;
		 * 
		 * System.out.println(Integer.toBinaryString(i));
		 * System.out.println(Integer.toBinaryString(j));
		 * 
		 * System.out.println(i >> 1); // 5 System.out.println(i >>> 1); // 5
		 * 
		 * System.out.println(j); System.out.println(Integer.toBinaryString(j));
		 * System.out.println(Integer.toBinaryString(j >> 1)); System.out.println(j >>
		 * 1);
		 * 
		 * System.out.println(Integer.toBinaryString(j >>> 1)); System.out.println(j >>>
		 * 1);
		 */

		int x = 10;
		int y = -3;

		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));

		System.out.println(x << 1); // 5
		System.out.println(y << 1); // 5
		// System.out.println(y <<< 1); // 5

		/*
		 * System.out.println(y); System.out.println(Integer.toBinaryString(y));
		 * System.out.println(Integer.toBinaryString(y << 1)); System.out.println(j <<
		 * 1);
		 * 
		 * System.out.println(Integer.toBinaryString(y << 1));
		 * System.out.println(Integer.toBinaryString(x << 1));
		 */

	}

}
