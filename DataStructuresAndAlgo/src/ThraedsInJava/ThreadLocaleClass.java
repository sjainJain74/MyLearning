package ThraedsInJava;

public class ThreadLocaleClass {

	public static void main(String arg[]) {

		ThreadLocal<String> threadLocal = new ThreadLocal<String>();

		Runnable myRun = new MyRunnableThreadLocal1(threadLocal);
			

		Thread t1 = new Thread(myRun);
		Thread t2 = new Thread(myRun);
		t1.start();
		t2.start();

	}

}

class MyRunnableThreadLocal1 implements Runnable {
	private ThreadLocal<String> threadLocal;

	public MyRunnableThreadLocal1(ThreadLocal<String> threadLocal) {
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		threadLocal.set("abc");
		System.out.println(threadLocal.get());

	}

}

class MyRunnableThreadLocal2 implements Runnable {
	private ThreadLocal<String> threadLocal;

	public MyRunnableThreadLocal2(ThreadLocal<String> threadLocal) {
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		threadLocal.set("def");

		System.out.println(threadLocal.get());

	}

}