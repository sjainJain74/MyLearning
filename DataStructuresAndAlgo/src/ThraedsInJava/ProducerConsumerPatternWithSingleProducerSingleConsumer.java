package ThraedsInJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPatternWithSingleProducerSingleConsumer {
	public static void main(String arg[]) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(7);
		Thread producerThread = new Thread(new Producer(queue),"My Producer");
		Thread consumerThread = new Thread(new Consumer(queue),"My Consumer");

	    
		consumerThread.start();
		producerThread.start();

	}

}

class Producer implements Runnable {
	private BlockingQueue queue;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			double random = Math.random();
			try {
				queue.put(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produced by thread " + " " +Thread.currentThread().getName() + " Item Produced is"+" " + random);

		}

	}

}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumed By Thread " + " " + Thread.currentThread().getName() + " " + queue.peek());
			queue.poll();

		}
	}

}
