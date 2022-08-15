import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Testing {

	public static void main(String[] args) {
		//Testing substring
		String s ="abc";
		System.out.print(s.substring(0));
		
		int count =3;
		System.out.println("Before Method Call");
		System.out.println(count);
		testPrimitiveVariable(count);
		System.out.println("After  Method Call");
		System.out.println(count);
		
		System.out.println("********Testing List object Passed **********");
		List<Integer> list = new ArrayList();
		list.add(1);
		System.out.println("Before Method Call");
		System.out.println(list);
		testPrimitiveVariable(list);
		System.out.println("After  Method Call");
		System.out.println(list);
		
		
		
		
	}
		
	public static void  testPrimitiveVariable (int count) {
		count = count+10;
		System.out.println("Inside Method Call");
		System.out.println(count);
		
	}
	
	public static void  testPrimitiveVariable (List<Integer> list) {
		list.add(2);
		System.out.println("Inside Method Call");
		System.out.println(list);
		
	}
		

}
