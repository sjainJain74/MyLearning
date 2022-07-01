package DP;

public class MyClass {

	public static void main(String arg[]) {
		int[] myArray = new int[] { 1, 2, 3 };
		int N = myArray.length;
		
		System.out.println(N);

		for (int i = 0; i < N - 1; i++) {
			for (int j = N - 1; j != i; j--) {
				System.out.println(i + "  " + j);

			}
		}
		
		System.out.println("***********************");
		
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = N - 1; j>=0; j--) {
				System.out.println(i + "  " + j);

			}
		}

	}

}
