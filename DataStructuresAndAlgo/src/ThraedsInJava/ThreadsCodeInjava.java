package ThraedsInJava;

public class ThreadsCodeInjava {
	public static void main(String arg[]) {
		// Using Standard Java 7
		MyRunnable runnable = new MyRunnable();
		MyNewRunnable newRunnable = new MyNewRunnable();
		Thread myThread = new Thread(runnable);
		Thread myNewThread = new Thread(newRunnable);
		// myThread.start();
		// myNewThread.start();
		// Using Standard Java 7

		// Using Anonms class
		Runnable runnableAnonamysClass = new MyRunnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " " + "Printing i " + i);
					// System.out.println(Thread.currentThread().getName());
				}
			}
		};
		Thread myNewThreadFromAnonomys = new Thread(runnableAnonamysClass);
		// myNewThreadFromAnonomys.start();
		// Using Anonms class

		// Using Java 8 lambda
		Runnable runnableJava8 = () -> {
			for (int j = 0; j < 10; j++) {
				// System.out.println("From Java8 class " + i);
				System.out.println(Thread.currentThread().getName() + " " + "Printing j " + j);
			}
		};
		Thread myNewThreadFromJava8 = new Thread(runnableJava8);
		// myNewThreadFromJava8.start();

		// Using Java 8 lambda
		Counter counter = new Counter();
		SyncronizedCounter syncronizedCounter = new SyncronizedCounter();
		Runnable runnableJava8Counter = () -> {

			for (int j = 0; j < 10; j++) {
				counter.add(1);
				syncronizedCounter.add(1);
				// System.out.println("From Java8 class " + i);
				System.out.println("Printing counter.conunt " + counter.count);
				System.out.println("Printing syncronizedCounter.conunt " + syncronizedCounter.count);
			}
		};
		Thread myNewThreadFromJava8Counter = new Thread(runnableJava8Counter);
		myNewThreadFromJava8Counter.start();

		Runnable runnableJava8Counter2 = () -> {
			for (int j = 0; j < 10; j++) {
				counter.add(1);
				syncronizedCounter.add(1);
				System.out.println("Printing counter.counter2 " + counter.count);
				System.out.println("Printing syncronizedCounter.conunt2 " + syncronizedCounter.count);
			}
		};
		Thread myNewThreadFromJava8Counter2 = new Thread(runnableJava8Counter2);
		myNewThreadFromJava8Counter2.start();

	}

}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

	}
}

class MyNewRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello");
		}

	}

}

class Counter {

	public int count = 0;

	public void add(int value) {
		count = count + value;

	}
}

class SyncronizedCounter {

	public int count = 0;

	synchronized public void add(int value) {
		count = count + value;

	}

}
