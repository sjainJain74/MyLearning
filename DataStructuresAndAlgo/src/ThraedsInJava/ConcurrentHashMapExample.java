package ThraedsInJava;

import java.util.concurrent.ConcurrentHashMap;
//https://www.youtube.com/watch?v=RMR75VzYoos&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=9

public class ConcurrentHashMapExample {

	public static void main(String arg[]) {

		ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
		RunnableConcurrentHashMap run = new RunnableConcurrentHashMap(map);

		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);

		t1.start();
		t2.start();

	}

}

class RunnableConcurrentHashMap implements Runnable {
	ConcurrentHashMap<String, String> map;

	public RunnableConcurrentHashMap(ConcurrentHashMap<String, String> map) {
		this.map = map;
	}

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			synchronized (map) {
				if (map.containsKey("key")) {
					String val = map.remove("key");
					if (val == null) {
						System.out.println("Iteration " + i + " value is null");
					}
				} else {
					map.put("key", "value");
				}
			}
		}

	}

//	@Override
//	public void run() {
//
//		for (int i = 0; i < 1000; i++) {
//
//			if (map.containsKey("key")) {
//				String val = map.remove("key");
//				if (val == null) {
//					System.out.println("Iteration " + i + " value is null");
//				}
//			} else {
//				map.put("key", "value");
//
//			}
//		}
//
//	}

}
