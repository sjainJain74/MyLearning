import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelavergeQuestion {

	public static void main(String arg[]) {

		int i = 100;
		int n = 4;
		System.out.println("Printing the list which has sum = "+i);

		Random rand = new Random();

		List<Integer> outPutList = new ArrayList<Integer>();

		for (int k = 0; k < n - 1; k++) {
			int random = rand.nextInt(i);
			outPutList.add(random);
			i = i - random;

		}

		outPutList.add(i);
		
		System.out.println(outPutList);
		//System.out.println(i);

	}

}
