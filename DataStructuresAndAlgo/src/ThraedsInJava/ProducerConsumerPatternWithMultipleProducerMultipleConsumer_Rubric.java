package ThraedsInJava;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerPatternWithMultipleProducerMultipleConsumer_Rubric {
	public static void main(String arg[]) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(50);

		ExecutorService producerPoll = Executors.newFixedThreadPool(10);
		ExecutorService consumerPoll = Executors.newFixedThreadPool(1);

		AtomicInteger offset = new AtomicInteger(0); // This need to have single object

		while (true) {
			// System.out.println("Inside while...");
			producerPoll.execute(new Producer_Rubric(queue, offset));
			consumerPoll.execute(new Consumer_Rubric(queue));

		}

	}

}

class Producer_Rubric implements Runnable {
	private BlockingQueue<Integer> queue;
	AtomicInteger offset;

	public Producer_Rubric(BlockingQueue<Integer> queue, AtomicInteger offset) {
		this.queue = queue;
		this.offset = offset;
	}

	@Override
	// Do we need sync here?

	public void run() {
		try {

			Thread.sleep(1000);
			Integer limit = 5;

			// int i = offset.addAndGet(limit);
			// List<Integer> instanceList = Instancegenerator.getInsGen().getInstanceList(i
			// , limit); //
			List<Integer> instanceList = Instancegenerator.getInsGen().getInstanceList(offset, limit);
			offset.addAndGet(limit);
			// queue.addAll(instanceList); --->Not thread safe
			for (Integer each : instanceList) {
				queue.offer(each);
			}

			System.out.println("Producer By Thread " + " " + Thread.currentThread().getName());
			System.out.println("Producer has produced the list and pushed to queue " + instanceList.toString());
			System.out.println("Current State of Queue  " + queue.toString());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer_Rubric implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer_Rubric(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
			System.out.println("Consumed By Thread " + " " + Thread.currentThread().getName() + " " + queue.peek());
			queue.poll();
			// db_update(queue.poll())
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Instancegenerator {

	// This is singelton pattern as if we make multiple object we will lock differnt
	// Instancegenerator object thus will not be thread safe
	private Instancegenerator() {
	}

	private static Instancegenerator inGen = new Instancegenerator();

	public static Instancegenerator getInsGen() {
		return inGen;

	}

	synchronized LinkedList<Integer> getInstanceList(AtomicInteger offset, Integer limit) {
		// This is singelton pattern as if we make multiple object we will lock differnt
		// Instancegenerator object thus will not be thread safe
		LinkedList<Integer> instanceList = new LinkedList<Integer>();
		instanceList.add(offset.intValue());
		int x = 0;
		while (x < limit - 1) {
			instanceList.add(instanceList.getLast() + 1);
			x++;
		}
		// System.out.println(instanceList);
		return instanceList;

	}

	synchronized LinkedList<Integer> getInstanceList(int offset, Integer limit) {

		LinkedList<Integer> instanceList = new LinkedList<Integer>();
		instanceList.add(offset);
		int x = 0;
		while (x < limit - 1) {
			instanceList.add(instanceList.getLast() + 1);
			x++;
		}
		// System.out.println(instanceList);
		return instanceList;

	}
}