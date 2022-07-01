package ThraedsInJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService {

	public static void main(String arg[]) {

		ExecutorService pool = Executors.newFixedThreadPool(2); // Create Thread poll with 5 threads.

		//Create 5 differnt task
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		Task task4 = new Task();
		Task task5 = new Task();

		//Execute 5 differnt task
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.execute(task5);
		
		pool.shutdown();

	}

}

class Task implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.err.println(Thread.currentThread().getName() + " " + i);
		}
	}
}