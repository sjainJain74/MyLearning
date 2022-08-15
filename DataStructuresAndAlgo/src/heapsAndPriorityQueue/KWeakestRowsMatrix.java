
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/submissions/
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
//1337. The K Weakest Rows in a Matrix
package heapsAndPriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KWeakestRowsMatrix {
	public static void main(String arg[]) {
		//int[][] mat = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },{ 1, 1, 1, 1, 1 } };
		//int[][] mat = new int[][] { { 1, 1, 1,1,1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 },{ 1, 1, 1, 1, 1 } };
		int[][] mat = new int[][] { { 1,0 }, { 1, 0 }, { 1, 0 }, { 1, 1} };
	    //int[][] mat = new int[][] { { 1, 0 }, { 1,0 }, { 1, 0 }, { 1, 1 }};
		int k = 4;
		/*
		 * System.out.println(Arrays.toString(kWeakestRows(mat, k))); Map<Integer,
		 * List<Integer>> sol_arrayIndex = kWeakestRows_using_TreeMap(mat, k);
		 * 
		 * 
		 * List<Integer> outputList = new ArrayList<Integer>(k);
		 * 
		 * for (Integer each: sol_arrayIndex.keySet()) {
		 * outputList.addAll(sol_arrayIndex.get(each)); if(outputList.size()>=k) break;
		 * } System.out.println(outputList);
		 */
			System.out.println(Arrays.toString(kWeakestUsingVerticalIteration(mat,k)));
		
	}
	
		public static int[] kWeakestUsingVerticalIteration(int[][] mat, int k) {
	
			int C = mat[0].length;
			int R = mat.length;
	
			int[] output = new int[k];
			int size = 0;
	
			for (int i = 0; i < C && size < k; i++) {
				for (int j = 0; j < R && size < k; j++) {
					// When anything except first column is zero  and previous column is non zero
					if (mat[j][i] == 0 && i != 0 && mat[j][i - 1] == 1) {
						output[size] = j;
						size++;
						// When anything except first column is zero 
					} else if (mat[j][i] == 0 && i == 0) {
						output[size] = j;
						size++;
	
					}
				}
	
			}
			
			
	// K is not filled and we have few columns with all 1 eg [1,1,1,1]
			if (size < k) {
				for (int x =0;x<R && k>size;x++) {
					if(mat[x][C-1]==1) {
						output[size] = x;
						size++;
					}
				}
				return output;
			}
	
			else // when output.length ==k
			return output;
		}
	

	
	public static Map<Integer, List<Integer>> kWeakestRows_using_TreeMap(int[][] mat, int k) {
		Map<Integer, List<Integer>> tm = new TreeMap<Integer,List<Integer>>();
		for (int i = 0; i < mat.length; i++) {
			int solCount = bs(mat[i], 0, mat[i].length - 1);
			if(tm.containsKey(solCount)) {
				List<Integer> list = tm.get(solCount);
				list.add(i);
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				tm.put(solCount, list);
			}
		}
		System.out.println(tm);
		return tm;

		//{1=[2], 2=[0, 3], 4=[1], 5=[4]}
		
	}
	
	
	public static int[] kWeakestRows(int[][] mat, int k) {

		/*
		 * Algo: Get the number of soldier in each row, using the binary search 0,1 1,4
		 * 2,2 3,3
		 * 
		 * Push this list into priority queue and fecth first K elemnt ( first 3
		 * example)
		 * 
		 * 0,1 2,2 3,3 1,4
		 * 
		 * Return first k [0,2,3]
		 */
		PriorityQueue<int[]> myQueueWIthKElement = getTheNumberOfSoldiersUsingBS(mat, k);
		int[] output = new int[k];
		for (int i = 0; i < k; i++) {
			output[i] = myQueueWIthKElement.poll()[0];
		}
		return output;

	}

	private static PriorityQueue<int[]> getTheNumberOfSoldiersUsingBS(int[][] mat, int k) {
		int[][] index_sol = new int[mat.length][2];
		PriorityQueue<int[]> myQueueWIthKElement = new PriorityQueue<>(k, new MyComparatorForTuple());

		for (int i = 0; i < mat.length; i++) {
			index_sol[i] = new int[] { i, bs(mat[i], 0, mat[i].length - 1) };
			myQueueWIthKElement.add(index_sol[i]);
		}

		for (int i = 0; i < index_sol.length; i++) {
			System.out.println(Arrays.toString(index_sol[i]));
		}
		return myQueueWIthKElement;
	}

	private static int bs(int[] singleRow, int start, int end) {

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

}

class MyComparatorForTuple implements Comparator<int[]> {
	public int compare(int[] o1, int[] o2) {
		//Priority Queue with minimum at starting, Means sort asec [0,1,2] T
		if (o1[1] > o2[1]) //First elemt bigger ? swap ==>return 1	
			return 1;
		else if (o1[1] < o2[1])
			return -1;
		else if(o1[1] == o2[1] && o1[0] > o2[0])  
			return 1;
        else if  (o1[1] == o2[1] && o1[0] < o2[0])
            return-1;
        else return 0;
	}

}