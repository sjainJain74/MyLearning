package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String arg[]) {
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		groupAnagrams(strs);

		String[] strs2 = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		groupAnagramsforDiscusionOnReturnList(strs2);

		learingAscii(); // This you should know before you try ASCII code for net

		learnStringStringBuilder();

		String[] strs3 = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		groupAnagramsUsingAscii(strs3);

		String[] strs4 = new String[] { "eat", "tea" }; // This code does not work :(
		groupAnagramsUsingAsciiLessCode(strs4);

	}

	private static void learnStringStringBuilder() {
		String s = "abc";
		StringBuilder sb = new StringBuilder("abc");
		// I thought this will return true. But ..
		// String Builder does not have equals and hashcode thus never use in map key.
		// This use equals of object class
		// Since these are 2 difernt class. Thus equals giving false.
		System.out.println(s.equals(sb)); // expected true but false
		System.out.println(sb.equals(s));// expected true but false

		// I can append on Strin builder, but not in String
		System.out.println(sb.append("def"));
		System.out.println(s + "aaa");
		System.out.println(s);

	}

	private static void learingAscii() {
		String s = "abc";

		char[] charArray = s.toCharArray();
		char a = 'a';
		int a_Ascii = (int) a;
		System.out.println("If we want to make a =0, b=1 ???");

		for (int i = 0; i < charArray.length; i++) {
			char alphabet = charArray[i];
			int char_Ascii = (int) alphabet;
			System.out.println("Character is " + alphabet + " ACII Code is " + char_Ascii);
			System.out.println("Character is " + alphabet + " 0 1 2 code is .... " + ""
					+ Integer.toString((char_Ascii - a_Ascii)));

		}

	}

	// Very weird solution let' discuss with Diplav

	public static List<List<String>> groupAnagramsUsingAscii(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			int[] keyInt = new int[26];
			for (char c : s.toCharArray()) {
				keyInt[c - 'a']++;
			}

			// keyInt.toString() we cannot use as [1,1,0 , ,,..] = [11,1,1] -->try this out

			// Discuss with diplav
			// String key =""; String is immutable, Thus once creatd we cannot append
			// anything.
			// If we have to do that we need to assign to new string. Which we do not want

			// String s1 = new String(); //String literal (3 objects without refrence) +
			// Heap (1 object)
			// Can cause out of memory.
			// for (int number : keyInt) {
			// s1.concat(""+number);
			// s1.concat("#");
			// }

			// for (int number : keyInt) { //String literal (3 objects without refrence)
			// Can cause out of memory.
			// String s3 = "";
			// s3.concat("" + number);
			// s3.concat("#");
			// }

			// String Builder does not have hashcode and equals .
			StringBuilder key = new StringBuilder();
			for (int number : keyInt) {
				key.append(number);
				key.append("#");
			}

			String keyString = key.toString();
			if (!map.containsKey(keyString)) {
				List<String> l = new ArrayList<String>();
				l.add(s);
				map.put(keyString, l);
			} else {
				map.get(keyString).add(s);
			}
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagramsUsingAsciiLessCode(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			int[] keyInt = new int[26];
			for (char c : s.toCharArray()) {
				keyInt[c - 'a']++;
			}

			// keyInt.toString() we cannot use as [1,1,0 , ,,..] = [11,1,1] -->try this
			// out..

			// This does not work as we are using object toString method.

			// Discuss with diplav
			// String key =""; String is immutable, Thus once creatd we cannot append
			// anything.
			// If we have to do that we need to assign to new string. Which we do not want

			/*
			 * StringBuilder key = new StringBuilder(); for (int number : keyInt) {
			 * key.append(number); key.append("#"); }
			 */

			String keyString = keyInt.toString();
			System.out.println(keyString);
			if (!map.containsKey(keyString)) {
				List<String> l = new ArrayList<String>();
				l.add(s);
				map.put(keyString, l);
			} else {
				map.get(keyString).add(s);
			}
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagramsUsingAsciiVeryComplex(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = new char[26];
			for (char c : s.toCharArray()) {
				ca[c - 'a']++;
				  //char c = 'a' ;  97
				  //System.out.println(c++);  -->B
				
			}
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<>());
			map.get(keyStr).add(s);
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagramsforDiscusionOnReturnList(String[] strs) {

		Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			// This sorting need to be done using char array, As no direct sorting for
			// Need to keep Seperate string onc sorted else it will change string in array.

			char[] c = strs[i].toCharArray();
			Arrays.sort(c); //DualPivotSort is used. In place sort. This is advantage over merge sort.
			String sortedStringKey = String.valueOf(c);

			if (!m.containsKey(sortedStringKey)) {
				ArrayList<String> l = new ArrayList<String>();
				l.add(strs[i]);
				m.put(sortedStringKey, l);
			} else {
				List<String> l = m.get(sortedStringKey);
				l.add(strs[i]);

			}

		}

		System.out.println(m.values());
		return new ArrayList<>(m.values()); // This is working fine.
		// return new ArrayList<String>(m.values()); Why is this giving error?
		// return ArrayList<String> (m.values()); // Why cant we cast??

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> m = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			// This sorting need to be done using char array, As no direct sorting for
			// Need to keep Seperate string onc sorted else it will change string in array.

			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String sortedStringKey = String.valueOf(c);

			if (!m.containsKey(sortedStringKey)) {
				List<String> l = new ArrayList<String>();
				l.add(strs[i]);
				m.put(sortedStringKey, l);
			} else {
				List<String> l = m.get(sortedStringKey);
				l.add(strs[i]);

			}

		}

		// return (List<List<String>>) m.values();
		// Since we are returning the values from map, That is List<String>. We cannot
		// cast that to arrayList
		// let' discuss with Diplav

		List<List<String>> l = new ArrayList<List<String>>();
		l.addAll(m.values());
		System.out.println(l);
		// return l;
		// Alternative for adding values in arraylist
		return new ArrayList<>(m.values());

	}

}