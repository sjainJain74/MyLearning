package ThraedsInJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ProducerConsumerPatternWithMultipleProducerMultipleConsumer {
	public static void main(String arg[]) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

		ExecutorService producerPoll = Executors.newFixedThreadPool(2);
		ExecutorService consumerPoll = Executors.newFixedThreadPool(2);

		while (true) {
			// System.out.println("Inside while...");
			producerPoll.execute(new Producer_Rubric(queue));
			consumerPoll.execute(new Consumer2(queue));

		}

	}

}

class Producer2 implements Runnable {
	private BlockingQueue queue;
	AtomicLong offset;

	public Producer2(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	// Do we need sync here?

	public void run() {
		try {
			
			double random = Math.random();
			Thread.sleep(500);
			queue.put(random);
			
			//offset.addAndGet(limit);
			//queue.addAll(getList( offset,10))
		
		
			System.out.println("Produced by thread " + " " + Thread.currentThread().getName() + " Item Produced is"
					+ " " + random);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer2 implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Consumed By Thread " + " " + Thread.currentThread().getName() + " " + queue.peek());
			queue.poll();
			//db_update(queue.poll())
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
