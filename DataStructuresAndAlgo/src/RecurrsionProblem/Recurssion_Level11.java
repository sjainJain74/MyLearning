package RecurrsionProblem;

import java.util.ArrayList;
import java.util.List;

public class Recurssion_Level11 {

	public static void main(String arg[]) {
		// We are having 3X3 matrix
		int n = 2;
		// System.out.println(getPath(0, 0, n, n));

		ArrayList<String> list = new ArrayList<String>();
		getPath(0, 0, n, n, list, "");
		// System.out.println(list);

		// System.out.println(subString("abcd", 0));

		// getAllSubSeq(String s, int startIndex)

		// System.out.println(getAllSubSeq("abc", 0));

		// getPathOnlyPrint(0,0,n,n,"");
		
		String per = "abc";

		printStringPermutaion(per, "");
		ArrayList<Character> psf = new ArrayList();
		printStringPermutaionUsingList(per,psf);
		
		ArrayList<Character> psfBT = new ArrayList();
		printStringPermutaionUsingBackTra(per,psfBT);

		//printEncoding("123", "");
		// printEncoding("12", "");
		// public static void printSubset(int arr[],int index, String set,int sos,int
		// tar) {
		int arr[] = { 10, 20, 30, 40, 50 };
		//printSubset(arr, 0, "", 0, 70);
		
		//printSubsetUsingArrayList(arr, 0,new ArrayList<Integer>(), 0, 70);
		
		//printSubsetUsingBT(arr, 0,new ArrayList<Integer>(), 0, 70);
		
		
		
	}

	// https://www.youtube.com/watch?v=K5xJXbnYMBc&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=42

	// a -->Per(bc) b-->

	public static void printStringPermutaion(String S, String permutationSoFar) {
		if (S.length() == 0) {
			System.out.println(permutationSoFar);
			return;
		}
		for (int i = 0; i < S.length(); i++) {
			String stringBeforeIndex = S.substring(0, i);
			String stringAfterIndex = S.substring(i + 1);
			String smallString = stringBeforeIndex.concat(stringAfterIndex);

			String permutationSoSmall = S.charAt(i) + permutationSoFar;
			printStringPermutaion(smallString, permutationSoSmall);
		}
	}
	
	
	public static void printStringPermutaionUsingList(String S, ArrayList<Character> permutationSoFar) {
		if (S.length() == 0) {
			System.out.println(permutationSoFar);
			return;
		}
		for (int i = 0; i < S.length(); i++) {
			String stringBeforeIndex = S.substring(0, i);
			String stringAfterIndex = S.substring(i + 1);
			String smallString = stringBeforeIndex.concat(stringAfterIndex);

			ArrayList<Character> permutationInShort = new ArrayList();
			permutationInShort.addAll(permutationSoFar);
			permutationInShort.add(S.charAt(i));
			printStringPermutaionUsingList(smallString, permutationInShort);
		}
	}
	
	
	public static void printStringPermutaionUsingBackTra(String S, ArrayList<Character> permutationSoFar) {
		if (S.length() == 0) {
			System.out.println(permutationSoFar);
			return;
		}
		for (int i = 0; i < S.length(); i++) {
			String stringBeforeIndex = S.substring(0, i);
			String stringAfterIndex = S.substring(i + 1);
			String smallString = stringBeforeIndex.concat(stringAfterIndex);

			permutationSoFar.add(S.charAt(i));
			printStringPermutaionUsingBackTra(smallString, permutationSoFar);
			//permutationSoFar.remove(permutationSoFar.size()-1);
			
		}
	}


	public static void getPath(int startx, int starty, int endx, int endy, ArrayList<String> list, String pathSoFar) {

		if (startx == endx || starty == endy) {
			return;
		}

		if (startx == endx - 1 && starty == endy - 1) {
			list.add(pathSoFar);
		}

		getPath(startx + 1, starty, endx, endy, list, "h" + pathSoFar);
		getPath(startx, starty + 1, endx, endy, list, "v" + pathSoFar);

	}

//https://www.youtube.com/watch?v=MHtAA5UE-6Y&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=39
	public static void getPathOnlyPrint(int startx, int starty, int endx, int endy, String pathSoFar) {

		if (startx == endx || starty == endy) {
			return;
		}

		if (startx == endx - 1 && starty == endy - 1) {
			System.out.println((pathSoFar));
		}

		getPathOnlyPrint(startx + 1, starty, endx, endy, "h" + pathSoFar);
		getPathOnlyPrint(startx, starty + 1, endx, endy, "v" + pathSoFar);

	}

	// https://www.youtube.com/watch?v=7i41gZLXe5k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=31
	public static ArrayList<String> getPath(int startx, int starty, int endx, int endy) {

		if (startx == endx || starty == endy) {
			return new ArrayList<String>();
		}

		if (startx == endx - 1 && starty == endy - 1) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}
		ArrayList<String> fromOneStepX = getPath(startx + 1, starty, endx, endy);
		ArrayList<String> fromOneStepY = getPath(startx, starty + 1, endx, endy);
		ArrayList<String> output = new ArrayList<String>();
		for (String each : fromOneStepX) {
			output.add("h" + each);
		}
		for (String each : fromOneStepY) {
			output.add("v" + each);
		}
		return output;
	}

	public static List<String> getAllSubSeq(String s, int startIndex) {
		// This base case also gives correct result.

		/*
		 * if(startIndex ==s.length()-1) { List<String> list = new ArrayList();
		 * list.add(""); list.add(s.substring(startIndex,startIndex+1)); return list;
		 * 
		 * }
		 */

		// This base case is expected in interview.

		if (startIndex == s.length()) {
			List<String> list = new ArrayList();
			list.add("");
			return list;
		}

		List<String> listSmall = getAllSubSeq(s, startIndex + 1);
		List<String> outputList = new ArrayList<String>();
		for (String each : listSmall) {
			// Do not try to modify same list while iterating ,
			// You will get concurrent modification
			outputList.add(s.substring(startIndex, startIndex + 1).concat(each));
		}
		outputList.addAll(listSmall);
		return outputList;
	}

	// THIS IS PENDING TO CODE!!!

	public static void getAllSubSeqUsingListAsArgu(String s, int startIndex, String stringSoFar) {

		// This base case is expected in interview.

		if (startIndex == s.length()) {
			System.out.println(stringSoFar);
			return;
		}
		getAllSubSeqUsingListAsArgu(s, startIndex + 1, stringSoFar);

	}

	public static ArrayList<String> subString(String S, int startIndex) {
		// Think Euler you will get to understand this.
		if (startIndex == S.length()) {
			ArrayList<String> list = new ArrayList();
			list.add("");
			return list;
		}
		ArrayList<String> list_witOut = subString(S, startIndex + 1);
		ArrayList<String> output = new ArrayList();

		for (String each : list_witOut) {
			output.add(each);
		}
		for (String each : list_witOut) {
			output.add(S.substring(startIndex, startIndex + 1).concat(each));
		}
		return output;
	}

	// 123-->abc & aw
	// 'c' - 'a' ==2

	// Code a 97
	// Code b 98

	public static void printEncoding(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		if (str.length() == 1) {
			// this can be 1,2,3
			// We need to add a,b,c
			char ch = str.charAt(0);
			// Liker we minus 'a' for character...we can minus zero for numeric
			int chI = ch - '0';
			if (ch == 0)
				return;
			else {
				// Let's say 3 ==> 97+3 =100
				int mycode = 'a' + chI - 1;
				char myChar = (char) mycode;
				System.out.println(asf + myChar);
				return;
				// This is alternative
				// printEncoding("", asf + myChar);
			}

		} else {
			// Taking first character
			char ch = str.charAt(0);
			int chI = ch - '0';
			String roq = str.substring(1);

			if (ch == 0)
				return;
			else {
				// Let's say 3 ==> 97+3 =100
				int mycode = (int) 'a' + chI - 1;
				char myChar = (char) mycode;
				printEncoding(roq, asf + myChar);
			}

			// Taking first two character
			String ch12 = str.substring(0, 2);
			String roq12 = str.substring(2);

			int ch12v = Integer.parseInt(ch12);
			if (ch12v <= 26) {
				int mycode = (int) 'a' + ch12v - 1;
				char myChar = (char) mycode;
				printEncoding(roq12, asf + myChar);
			}
		}

	}

	public static void printSubset(int arr[], int index, String set, int sos, int tar) {

		if (index == arr.length) {
			if (sos == tar) {
				System.out.println(set);
			}
			return;
		}

		// Take
		printSubset(arr, index + 1, set + arr[index]+",", sos + arr[index], tar);
		
		//No take 
		printSubset(arr, index + 1, set, sos, tar);

	}
	
	public static void printSubsetUsingArrayList(int arr[], int index, ArrayList<Integer> listSoFar, int sos, int tar) {

		if (index == arr.length) {
			if (sos == tar) {
				System.out.println(listSoFar);
			}
			return;
		}
		
		ArrayList<Integer> takeList = new ArrayList();
		takeList.addAll(listSoFar);
		
		ArrayList<Integer> noTakeList = new ArrayList();
		noTakeList.addAll(listSoFar);

		// Take
		takeList.add(arr[index]);
		printSubsetUsingArrayList(arr, index + 1, takeList, sos + arr[index], tar);
		
		//No take 
		printSubsetUsingArrayList(arr, index + 1, noTakeList, sos, tar);

	}
	
	//This uses only one list in both the recurrsion call
	
	public static void printSubsetUsingBT(int arr[], int index, ArrayList<Integer> listSoFar, int sos, int tar) {

		if (index == arr.length) {
			if (sos == tar) {
				System.out.println(listSoFar);
			}
			return;
		}

		// Take
		listSoFar.add(arr[index]);
		printSubsetUsingBT(arr, index + 1, listSoFar, sos + arr[index], tar);
		
		listSoFar.remove(listSoFar.size()-1);
		//No take 
		printSubsetUsingBT(arr, index + 1, listSoFar, sos, tar);

	}

}
