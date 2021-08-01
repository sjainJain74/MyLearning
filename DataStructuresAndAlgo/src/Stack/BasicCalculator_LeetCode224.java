package Stack;

import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class BasicCalculator_LeetCode224 {
	//https://www.youtube.com/watch?v=HUfUzA9Ekgo&t=628s
	//https://leetcode.com/problems/basic-calculator/

	public static void main(String arg[]) {
//		String s1 = "(7)";
//		System.out.println(calc(s1));
//		
//		String s2 = "(7+1-1-1-1)";
//		System.out.println(calc(s2));
//		
//		
//		String s3 = "(-7+2+2)";
//		System.out.println(calc(s3));
//		
//		
//		String s4 = "(-7)";
//		System.out.println(calc(s4));
//		
//		
//		String s5 = "(-7 +(-2))";
//		System.out.println(calc(s5));
//		
//		// This is failing
//		String s6 = "(-7 -(-2))";
//		System.out.println(calc(s6));
//		
//		String s7 = "-1+1";
//		System.out.println(calc(s7));

//		
		/*
		 * String s8 = "(1+(4+5+2)-3)+(6+8)"; //23 is expected
		 * System.out.println(calc(s8));
		 * 
		 * //1 String s10 = "(1-(4+5+2)-3)+(6+8)";
		 * System.out.println(calc(s10));
		 * 
		 * //String s9 = " 2-1 + 2 "; //System.out.println(calc(s9));
		 */
		String s11 = "(13-(4+3)-2)";
		// 1 is expected
		System.out.println(cacOptimize(s11));

	}

	

	public static int cacOptimize(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] charArray = s.toCharArray();
		int sign = 1;
		int result = 0;
		int sum = 0;

		for (int i = 0; i < charArray.length; i++) {
			// Logic to convert 2 or 3 digits in string array to Int value.

			if (Character.isDigit(charArray[i])) {
				sum = Character.getNumericValue( charArray[i]);
				while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
					sum = sum * 10 +Character.getNumericValue( charArray[i+1]);
					i++;
				}
				result = result + sign * sum;
			}

			else if (charArray[i] == '+') {
				sign = 1;

			}

			else if (charArray[i] == '-') {
				sign = -1;
			}

			else if (charArray[i] == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;

			}
			
			else if (charArray[i] == ')') {
				result = result * stack.pop() + stack.pop();
			}
		}

		return result;

	}

}