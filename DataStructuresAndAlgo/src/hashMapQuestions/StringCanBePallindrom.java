package hashMapQuestions;

import java.util.HashSet;

public class StringCanBePallindrom {

	public static void main(String arg[]) {

		String S = "aabbbccc";

		System.out.println(canWeCreatePallindrome(S));
	}

	private static boolean canWeCreatePallindrome(String S) {
		// TODO Auto-generated method stub

		HashSet<Character> s = new HashSet<Character>();
		char[] charArray = S.toCharArray();

		for (int x = 0; x < S.toCharArray().length; x++) {
			if(s.contains(charArray[x])) {
				s.remove(charArray[x]);
			}
			else {
				s.add(charArray[x]);
			}

		}
		
		if(s.size()>1) {
			return false;
		}
		else {
			return true;
		}

	}

}
