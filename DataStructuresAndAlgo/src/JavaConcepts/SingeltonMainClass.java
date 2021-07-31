package JavaConcepts;

public class SingeltonMainClass {
	public static void main(String[] args) {

		MySingelton single1 = MySingelton.getInstance();
		MySingelton single2 = MySingelton.getInstance();
		MySingelton single3 = MySingelton.getInstance();

		System.out.println(single1.S);
		System.out.println(single2.S);
		System.out.println(single3.S);

		single1.S = single1.S.toUpperCase();

		System.out.println(single1.S);
		System.out.println(single2.S);
		System.out.println(single3.S);

	}
}

class MySingelton {

	/// javarevisited.blogspot.com/2011/03/10-interview-questions-on-singleton.html#ixzz6zWlVDafC

	// 1. Make constructor private so that ,
	// If any one has to create a object he need to do so using static getInstance()
	// method

	// 2.java.lang.Runtime which provides getRuntime() method to get access of it
	// and used to get free memory and total memory in Java.

	// 3. override clone method

	private static MySingelton mySingelton;
	String S;

	private MySingelton() {
		S = " Dummy String As varaible to test singelton behaviour";

	};

	// This was prior to Java 5 when we do not had Enums

	/*
	 * static MySingelton getInstance() { if (mySingelton == null) { mySingelton =
	 * new MySingelton(); }
	 * 
	 * return mySingelton; }
	 */

	public MySingelton clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone Not Supported , As this is singelton class");
	}

	// Double null check, Thread safe , Lazy initialized singleton.
	// Lazy loading consume resources when required
	static MySingelton getInstance() {
		if (mySingelton == null)
			synchronized (MySingelton.class) {
				if (mySingelton == null) {
					mySingelton = new MySingelton();
				}

			}

		return mySingelton;
	}
}

//Easy Singelton
enum EnumSingelton {
	INSTANCE;
}
