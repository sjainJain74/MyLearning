package stringQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringBasics {

	public static void main(String arg[]) {
		char ascii_256 = (char) 256;
		char ascii_257 = (char) 257;
		char ascii_258 = (char) 258;

		System.out.println(ascii_256);
		System.out.println(ascii_257);
		System.out.println(ascii_258);

		List<String> l = new ArrayList<String>();
		l.add("Hi");
		l.add("Shashank");
		l.add("Jain");
		// System.out.println(encode(l));

		//System.out.println(decode(encode(l)));

		String s = "Very Long String Having many words";
		int lineLength = 10;
		//System.out.println(s);
		//System.out.println("breakIntoLines");
		System.out.println(breakIntoLines(s,lineLength));
		
		String s1 ="abcde";
		System.out.println("Check for substring");
		System.out.println(s1.substring(0,0));

	}

	//Discus with Diplav
	private static Map<Integer, String> breakIntoLines(String s, int k) {
		String[] myStringArray = s.split(" ");
		int lineNumber = 0;
		int currrentCharInLine = 0;
		String S = "";
		Map<Integer, String> map = new HashMap();

		for (int i = 0; i < myStringArray.length; i++) {
			if (currrentCharInLine < k) {
				currrentCharInLine = currrentCharInLine + myStringArray[i].toCharArray().length;
				S = S + myStringArray[i];
			} else {
				map.put(lineNumber, S);
				lineNumber++;
				S = "";
				currrentCharInLine=0;
			}

		}
		return map;

	}

	public static String encode(List<String> strs) {
		// [I am good]

		if(strs.size()==0) {
			return Character.toString((char) 258);
		}
		// String delimiter = "|";
		String delimiter = Character.toString((char) 257);
		StringBuilder sb = new StringBuilder();
		int size = strs.size();

		for (int i = 0; i < size; i++) {
			sb.append(strs.get(i));
			sb.append(delimiter);
		}
		// This is required to remove delimiter in end.
		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
		return sb.toString();

	}

	public static List<String> decode(String s) {
		
		if(s.equals(Character.toString((char)258))){
			return new ArrayList();
		}

		String delimiter = Character.toString((char) 257);
		// We get String array ..This is nice
		String[] split = s.split(delimiter);
		// Converting the String[] to List<String>
		return Arrays.asList(split);

	}

}
