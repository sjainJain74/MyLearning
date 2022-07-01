package heapsAndPriorityQueue;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapUnderstanding {

	public static void main(String arg[]) {

		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>(new DescComparator());
		tm.put(4, 4);
		tm.put(2, 2);
		tm.put(1, 1);
		tm.put(3, 3);

		for (Integer each : tm.keySet()) {
			// Ordered is maintained in tree map. but not in hashmap
			System.out.println(each);

		}

	}

}

class DescComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 > o2)
			return -1;
		else if (o1 < o2)
			return 1;
		else
			return 0;
	}

}
