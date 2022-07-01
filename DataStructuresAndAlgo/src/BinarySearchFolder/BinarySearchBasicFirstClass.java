package BinarySearchFolder;

public class BinarySearchBasicFirstClass {

	public static void main(String arg[]) {

		// int[] myArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int[] myArray = new int[] { 1 };
		int[] myArray0 = new int[] { 0, 0, 0 };
		int[] myArray1 = new int[] { 1, 0, 0 };
		int[] myArray2 = new int[] { 1, 1, 0 };
		int[] myArray3 = new int[] { 1, 1, 1 };

		// System.out.println(binarySearchWithDublicateFirstOccurance(myArray));

		/*
		 * System.out.println(bs(myArray0, 0, myArray0.length - 1)); //0
		 * System.out.println(bs(myArray1, 0, myArray1.length - 1)); //1
		 * System.out.println(bs(myArray2, 0, myArray2.length - 1)); //2
		 * System.out.println(bs(myArray3, 0, myArray3.length - 1)); //3
		 * 
		 * 
		 * System.out.println();
		 * System.out.println(binarySearchWithDublicateFirstOccurance(myArray0));
		 * System.out.println(binarySearchWithDublicateFirstOccurance(myArray1));
		 * System.out.println(binarySearchWithDublicateFirstOccurance(myArray2));
		 * System.out.println(binarySearchWithDublicateFirstOccurance(myArray3));
		 */
		System.out.println(bs_2022(myArray0 ));
		System.out.println(bs_2022(myArray1));
		System.out.println(bs_2022(myArray2));
		System.out.println(bs_2022(myArray3));
		
		System.out.println("By Leet code");
		System.out.println(binarySearch(myArray0 ));
		System.out.println(binarySearch(myArray1));
		System.out.println(binarySearch(myArray2));
		System.out.println(binarySearch(myArray3));
		

	}
	
	 private  static int binarySearch(int[] row) {
	        int low = 0;
	        int high = row.length; // this is not till len-1 to handle scenario like [1,1] we should get output as 2 ( when is first zero ? or number of 1 ?)
	        while (low < high) {
	            int mid = low + (high - low) / 2;
	            if (row[mid] == 1) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        return low;
	    }

	
	private static int bs_2022(int[] singleRow) {
        int start =0;
        int end = singleRow.length-1;
		/*
		 * [0]-->0 which position is first zero?
		 * [1]-->1 which position is first zero? (We did not find zero)
		 * 
		 * 
		 * 
		 * [0,0]-->0 which position is first zero? 
		 * [1,0]-->1which position is first zero? 
		 * [1,1]-->2 which position is first zero? ( We did not find zero)
		 * 
		 * 
		 * [0,0,0]-->0 which position is first zero? 
		 * [1,0,0]-->1 which position is first zero?
		 * [1,1,0]-->2 which position is first zero? 
		 * [1,1,1]-->3 which position is first zero? ( We did not find zero)
		 * 
		 */

		while (start < end) {
			int mid = (end - start) / 2 + start;
			if (singleRow[mid] == 0)
				end = mid ; 
			// If we do mid -1 that we will miss last zero. [1,1,0,0,0] => start =0 end =4 mid =2, Now we want to search in [1,1,0] 
			//But if we do mid -1 we will search in [1,1] thus return 5
			else
				start = mid + 1;

		}

		// We will reach here only when we have start=end
		if (singleRow[end] == 1) {
			//[1]~1 , [1,1]~2 ,[1,1,1] ~3,[1,1,1,1]~4
			return singleRow.length;
		}
		return start;

	}
	// https://leetcode.com/problems/binary-search/submissions/
	private static int bs(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		// this case when we will not find 1, [0,0,0,0,0] , Thus we have 0 as output.
		if (start > end)
			return 0;
		// When we have only one element
		//[0] -->Zero
		//[1] -->Start+1 ~1 in this case
		else if (start == end &&nums[start]==0)
			return start;
		else if (start == end &&nums[start]==1)
			return start+1;
		
		else if (nums[mid] == 0)
			return bs(nums, 0, mid);
		else
			return bs(nums, mid + 1, end);

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
