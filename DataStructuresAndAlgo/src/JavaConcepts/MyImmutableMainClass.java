package JavaConcepts;

public class MyImmutableMainClass {

	public static void main(String arg[]) {
		MyImmutable m1 = new MyImmutable("First String");
		System.out.println(m1.getName());
		// No setter so we cannot change state of object m1

		

	}

}

// Make class final so that no one can extend this class and overwrite any method/variable
// No Setter methods defined.

final class MyImmutable {

	final private String name;

	MyImmutable(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

}
