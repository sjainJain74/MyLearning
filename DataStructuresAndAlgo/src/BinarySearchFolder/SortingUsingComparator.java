package BinarySearchFolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUsingComparator {

	public static void main(String arg[]) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(0);
		list.add(4);
		list.add(-1);
		
		
		System.out.println("Before Sorting");
			System.out.println(list);

		System.out.println("Ascending   Sorting");
		sortAsce(list);
		System.out.println(list);
		
		
		System.out.println("Desc   Sorting");
		sortADesc(list);
		System.out.println(list);

	}

	private static void sortAsce(List<Integer> list) {
		Collections.sort(list,new AscComparator());

	}
	private static void sortADesc(List<Integer> list) {
		Collections.sort(list,new DescComparator());

	}

}

class AscComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		// +ve means swap
		// -ve means no swap
		// 0 means nothing

		if (o1 > o2) {
			return 1;
		}

		if (o1 < o2) {
			return -1;
		}

		return 0;

	}

}


class DescComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		// +ve means swap
		// -ve means no swap
		// 0 means nothing

		if (o1 > o2) {
			return -1;
		}

		if (o1 < o2) {
			return 1;
		}

		return 0;

	}

}