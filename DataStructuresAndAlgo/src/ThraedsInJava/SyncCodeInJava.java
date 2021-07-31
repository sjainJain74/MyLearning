package ThraedsInJava;

public class SyncCodeInJava {
	static volatile int x;

//https://www.youtube.com/watch?v=LCSqZyjBwWA&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=3
	public static void main(String arg[]) {
		Runnable myRunnable = new MyRunnableClass();
		Runnable myRunnable2 = new MyRunnableClass();

		Thread thread1 = new Thread(myRunnable);
		
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
		thread1.start();

		

	}
}

class MyRunnableClass implements Runnable {
	private int count = 0;

	@Override
	 public void run() {
		for (int i = 0; i < 1000000; i++) {
			count++;
		}
		System.out.println(Thread.currentThread().getName() + " " + count);

	}

}



class ReEntrance {
	Object obj;
	int counter = 0;
	private Runnable myRunnableReentrant;

	 public ReEntrance(Runnable myRunnableReentrant) {
		this.myRunnableReentrant=myRunnableReentrant;
	}

	public void incrCounter() {
		for (int i = 0; i < 100000; i++) {
			counter++;
		}
	}

	 public int getAndIncrCounter() {
		incrCounter();
		return counter;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
