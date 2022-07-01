package hashMapQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HastSetLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		learnHashSet();

	}
	
	private static void learnHashSet() {
		int[] input = new int[] { -1, 0, -1 }; // () not required

		// int[] input = new int[] { 7, 6 };

		System.out.println("Before ThreeSum" + Arrays.toString(input));
		System.out.println("After sortingColors_75" + Arrays.toString(input));

		Set<int[]> s = new HashSet<int[]>();
		s.add(new int[] { 1, 2 });
		s.add(new int[] { 1, 2 });
		s.add(new int[] { 3, 2 });
		// We can add dublicates as int[] do not have equals and hash code.
		System.out.println(s);

		Set<Integer> s2 = new HashSet<Integer>();
		s2.add(1);
		s2.add(2);
		s2.add(2);
		System.out.println(s2);

		Set<List<Integer>> s3 = new HashSet<List<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(2);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(2);
		a3.add(1);

		s3.add(a1);
		s3.add(a2);
		s3.add(a3);
		// We can not add dublicates as List<Integer> do have equals and hash code.
			
	}

}
