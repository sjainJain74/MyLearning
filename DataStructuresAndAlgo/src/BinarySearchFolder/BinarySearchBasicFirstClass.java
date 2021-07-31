package BinarySearchFolder;

public class BinarySearchBasicFirstClass {

	public static void main(String arg[]) {

		// int[] myArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int[] myArray = new int[] { 1 };
		int[] myArray = new int[] { 1,1,1,0,0,0 };

		System.out.println(binarySearchWithDublicateFirstOccurance(myArray));

	}

	private static int binarySearchWithDublicateFirstOccurance(int[] myArray) {
		int start = 0;
		int end = myArray.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (myArray[mid] == 0) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return end;

	}

	private static void binarySearch(int[] myArray, int k) {

		int start = 0;
		int end = myArray.length - 1;
		boolean elementExist = false;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (myArray[mid] > k) {
				end = mid - 1;
			} else if (myArray[mid] < k) {
				start = mid + 1;
			} else {
				// myArray[mid] == k
				System.out.println(mid);
				elementExist = true;
				break;
			}

		}

		if (!elementExist) {
			System.out.println("Elemnt Does not Exist");
		}

	}
}
