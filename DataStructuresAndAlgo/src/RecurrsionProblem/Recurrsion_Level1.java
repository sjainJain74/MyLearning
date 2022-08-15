package RecurrsionProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		// System.out.println(Arrays.toString(input));
		reverse(input, 0, input.length - 1);
		// System.out.println(Arrays.toString(input));

		char[] input_iterative = new char[] { 'a', 'b', 'c', 'd' };
		// System.out.println(Arrays.toString(input_iterative));
		// reverse_Iterative(input_iterative);
		// System.out.println(Arrays.toString(input_iterative));

		char[] input_iterative2 = new char[] { 'a', 'b', 'c', 'd', 'e' };
		// System.out.println(Arrays.toString(input_iterative2));
		// reverse_Iterative(input_iterative2);
		// System.out.println(Arrays.toString(input_iterative2));

		// Print 4,3,2,1 ..1,2.3,4
		int n = 2;
		// backAndForth(n);
		// pzz(n);
		int[] arr = new int[] { 10, 20, 130 };
		// printRev(arr);
		int[] arrOccOfk = new int[] { 10, 20, 30, 40, 50 };
		// System.out.println("firstOccurance Of K");
		// System.out.println(firstOccuranceOfK(arrOccOfk,0,50));
		// System.out.println(firstOccuranceOfK(arrOccOfk,0,10));
		/*
		 * System.out.println(firstOccuranceOfK(arrOccOfk, 0, 10));
		 * System.out.println(firstOccuranceOfK(arrOccOfk, 0, 20));
		 * System.out.println(firstOccuranceOfK(arrOccOfk, 0, 30));
		 * System.out.println(firstOccuranceOfK(arrOccOfk, 0, 40));
		 * System.out.println(firstOccuranceOfK(arrOccOfk, 0, 50));
		 * 
		 * System.out.println(firstOccuranceOfKNotOptimized(arrOccOfk, 0, 10));
		 * System.out.println(firstOccuranceOfKNotOptimized(arrOccOfk, 0, 20));
		 * System.out.println(firstOccuranceOfKNotOptimized(arrOccOfk, 0, 30));
		 * System.out.println(firstOccuranceOfKNotOptimized(arrOccOfk, 0, 40));
		 * System.out.println(firstOccuranceOfKNotOptimized(arrOccOfk, 0, 50));
		 */

		// System.out.println(firstOccuranceOfK(arrOccOfk,0,10));
		// System.out.println(firstOccuranceOfK(arrOccOfk,0,100));
		// System.out.println(firstOccuranceOfK(arrOccOfk,0,1000));

		// public static int[] findAllOccOfK(int[] input, int k,int occur,int index)

		int[] inputFindAllOcc1 = new int[] { 1, 3 };
		int[] inputFindAllOcc2 = new int[] { 1, 3, 3 };
		int[] inputFindAllOcc3 = new int[] { 3, 0, 3 };
		int[] inputFindAllOcc4 = new int[] { 3 };
		int[] inputFindAllOcc5 = new int[] { 1 };
		int[] inputFindAllOcc6 = new int[] {};

		System.out.println("******findAllOccOfK*******");
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc1, 3, 0, 0)));
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc2, 3, 0, 0)));
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc3, 3, 0, 0)));
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc4, 3, 0, 0)));
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc5, 3, 0, 0)));
		System.out.println(Arrays.toString(findAllOccOfK(inputFindAllOcc6, 3, 0, 0)));

		System.out.println("****** findAllOccOfKUsingList *******");
		// int[] input, int k, int index , List<Integer> list

		List<Integer> list1 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc1, 3, 0, list1);
		System.out.println(list1);

		List<Integer> list2 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc2, 3, 0, list2);
		System.out.println(list2);

		List<Integer> list3 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc3, 3, 0, list3);
		System.out.println(list3);

		List<Integer> list4 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc4, 3, 0, list4);
		System.out.println(list4);

		List<Integer> list5 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc5, 3, 0, list5);
		System.out.println(list5);

		List<Integer> list6 = new ArrayList();
		findAllOccOfKUsingList(inputFindAllOcc5, 3, 0, list6);
		System.out.println(list6);

		System.out.println("****** findAllOccOfKUsingListReturn *******");
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc1, 3, 0)));
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc2, 3, 0)));
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc3, 3, 0)));
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc4, 3, 0)));
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc5, 3, 0)));
		System.out.println((findAllOccOfKUsingListReturn(inputFindAllOcc6, 3, 0)));

		System.out.println("****** getAllSubSeq *******");
		//System.out.println(getAllSubSeq("abc", 0));

		System.out.println("****** getAllSubSeqVoidReturn *******");
		List<String> list = new ArrayList<String>();
		getAllSubSeqVoidReturn("abc", 0, list);
		System.out.println(list);

		int countOfWays = 0;
		climbStrairHelper(2, countOfWays);

		int count = 3;
		System.out.println("Before Method Call");
		System.out.println(count);
		testPrimitiveVariable(count);
		System.out.println("After  Method Call");
		System.out.println(count);

		System.out.println("********Testing List object Passed **********");
		List<Integer> l = new ArrayList();
		l.add(1);
		System.out.println("Before Method Call");
		System.out.println(l);
		testPrimitiveVariable(l);
		System.out.println("After  Method Call");
		System.out.println(l);
		
		//public static void climbStairsAndCaptureInlist(int n, List<String> list, String pathSoFar) {
		List<String> listPath = new ArrayList();
		climbStairsAndCaptureInlist(4,listPath,"");
		System.out.println(listPath);
		
		
		System.out.println(climbStairsAndReturnList(4));
		
		System.out.println("Print Starin path ");
		
		climbStairsAndCapturePrint(4,"");

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

	// https://www.youtube.com/watch?v=BWr4zBiRtJY&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=4
	private static void backAndForth(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		backAndForth(n - 1);
		System.out.println(n);
	}

	public static void pzz(int n) {
		if (n == 0)
			return;
		System.out.println("Pre" + n);
		pzz(n - 1);
		System.out.println("In" + n);
		pzz(n - 1);
		System.out.println("Post" + n);

		// 2pre 1 pre 1iIn 1post 2In 1pre 1in 1 post 2 post
	}

	public static void printRev(int[] arr) {
		printRevHelper(arr, arr.length - 1);
	}

	private static void printRevHelper(int[] arr, int n) {
		if (n < 0)
			return;
		System.out.println(arr[n]);
		printRevHelper(arr, n - 1);
	}

	// {100,10,30,10,50};
	// This is raw code.
	private static int firstOccuranceOfK(int[] arr, int n, int k) {
		// Base case
		if (n == arr.length)
			return -1;

		if (arr[n] == k) {
			return n;
		} else {

			int temp = firstOccuranceOfK(arr, n + 1, k);
			if (temp != -1)
				return temp;
			else
				return -1;

		}
	}

	private static int firstOccuranceOfKNotOptimized(int[] arr, int n, int k) {
		// Base case
		if (n == arr.length)
			return -1;

		int temp = firstOccuranceOfKNotOptimized(arr, n + 1, k);

		if (arr[n] == k)
			return n;
		else
			return temp;

	}

	// We cannot create a ArrayList , We need to play with int[].
	// And in recurrsion we need to find how many occur we have.

	// index 0 we are starting
	public static int[] findAllOccOfK(int[] input, int k, int occur, int index) {

		// it's base case we reached just after length array, Till now we have counted
		// the occr
		if (index == input.length) {
			return new int[occur];
		}

		// first element is K, Matching. we increase count and also k
		if (input[index] == k) {
			int[] temp1 = findAllOccOfK(input, k, occur + 1, index + 1);
			// While returning in rec we have empty array of size occur caught in temp1
			// variable

			// This temp1 is filling while returning in stack.
			// Think here when you will return we will have old value of occur thus...
			temp1[occur] = index;
			return temp1;
		}

		else {
			int[] temp1 = findAllOccOfK(input, k, occur, index + 1);
			return temp1;
		}

	}

	// Solve using High level thinking and analyse stack trace.
	public static void findAllOccOfKUsingList(int[] input, int k, int index, List<Integer> list) {

		if (index == input.length) {
			return;
		}

		if (input[index] == k) {
			list.add(index);
			findAllOccOfKUsingList(input, k, index + 1, list);
		}

		else {
			findAllOccOfKUsingList(input, k, index + 1, list);
		}

	}

	// Solve using High level thinking and analyse stack trace.
	public static List<Integer> findAllOccOfKUsingListReturn(int[] input, int k, int index) {

		if (index == input.length) {
			return new ArrayList<Integer>();
		}

		if (input[index] == k) {
			// List<Integer> list = new ArrayList<Integer>();
			// list.add(index);

			List<Integer> listSmall = findAllOccOfKUsingListReturn(input, k, index + 1);
			listSmall.add(index);
			// list.addAll(listSmall);
			// return list;
			return listSmall;
		} else {
			List<Integer> listSmall = findAllOccOfKUsingListReturn(input, k, index + 1);
			return listSmall;

		}
	}

	

	public static void getAllSubSeqVoidReturn(String s, int startIndex, List<String> list) {

		if (startIndex == s.length()) {
			list.add("");
			return;
		}

		// abc --> "",b,c,bc and 4 more after appending a

		getAllSubSeqVoidReturn(s, startIndex + 1, list);
		List<String> outputList = new ArrayList<String>();
		for (String each : list) {
			// Do not try to modify same list while iterating ,
			// You will get concurrent modification
			outputList.add(s.substring(startIndex, startIndex + 1).concat(each));
		}
		list.addAll(outputList);
	}

	public static int climbStairs(int n) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int lastStepsWay = climbStairs(n - 1);
		int lastSecondStepsWay = climbStairs(n - 2);
		return lastStepsWay + lastSecondStepsWay;
	}

	public static void climbStairsAndCaptureInlist(int n, List<String> list, String pathSoFar) {
		if (n == 0) {
			list.add(pathSoFar);
			return ;
		}
		if (n < 0) {
			return;
		}
		  String pathSoFarViaOne = pathSoFar+1;
		  String pathSoFarViaTwo = pathSoFar+2;
		  
		 climbStairsAndCaptureInlist(n - 1,list,pathSoFarViaOne);
		 climbStairsAndCaptureInlist(n - 2,list,pathSoFarViaTwo);
		
	}
	
	//https://www.youtube.com/watch?v=NEuYcztalew&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=37
	
	public static void climbStairsAndCapturePrint(int n, String pathSoFar) {
		if (n == 0) {
			System.out.println(pathSoFar);
			return ;
		}
		if (n < 0) {
			return;
		}
		  String pathSoFarViaOne = pathSoFar+1;
		  String pathSoFarViaTwo = pathSoFar+2;
		  
		  climbStairsAndCapturePrint(n - 1,pathSoFarViaOne);
		  climbStairsAndCapturePrint(n - 2,pathSoFarViaTwo);
		
	}
	
	public static List<String> climbStairsAndReturnList(int n) {
		if (n == 0) {
			List<String> list= new ArrayList<String>();
			list.add("");
			return list;
		}
		
		if (n < 0) {
			return new ArrayList<String>();
		}
		  
		  List<String> listViaOne = climbStairsAndReturnList(n - 1);
		  List<String> listViaTwo = climbStairsAndReturnList(n - 2);
		  
		
		  List<String> output = new ArrayList<String>();
		  for(String each:listViaOne) {
			  output.add(1+each);
		  }
		  for(String each:listViaTwo) {
			  output.add(2+each);
		  }
		  
		  return output;
		  
	}

	// Revise this code. what ever is value of countOfWays in this method.
	// You cannot get that value in the method which made a call to this method.
	// You should create countOfWays as class variable and not to pass that in
	// arguments
	// Test testPrimitiveVariable is must to revise
	// Test testPrimitiveVariable is must to revise

	public static void climbStrairHelper(int n, int countOfWays) {
		System.out.println(countOfWays);
		// in base case when we reach zero we have to return 1 so that it can contribute
		// to path
		if (n == 0) {
			countOfWays++;
			// System.out.println(countOfWays);
			return;
		}
		// in base case when we reach zero we have to return 1 so that it can contribute
		// to path
		if (n < 0) {
			// countOfWays =0;
			return;
		}

		int countOfWaySofar = countOfWays;

		climbStrairHelper(n - 1, countOfWays);
		climbStrairHelper(n - 2, countOfWays);
	}

	public static void testPrimitiveVariable(int count) {
		count = count + 10;
		System.out.println("Inside Method Call");
		System.out.println(count);

	}

	public static void testPrimitiveVariable(List<Integer> list) {
		list.add(2);
		System.out.println("Inside Method Call");
		System.out.println(list);

	}
}
