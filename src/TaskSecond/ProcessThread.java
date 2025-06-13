package TaskSecond;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessThread extends Thread {

	public static BlockingQueue<Object> result = new LinkedBlockingQueue<>();

	public void fizz(int n) throws InterruptedException {
		if (n % 3 == 0 && n % 5 != 0) {
			result.put("fizz");
		}
	}

	public void buzz(int n) throws InterruptedException {
		if (n % 5 == 0 && n % 3 != 0) {
			result.put("buzz");
		}
	}

	public void fizzbuzz(int n) throws InterruptedException {
		if (n % 15 == 0) {
			result.put("fizzbuzz");
		}
	}

	public void numbers(int n) throws InterruptedException {
		if (n % 3 != 0 && n % 5 != 0) {
			result.put(n);
		}
		if (!result.isEmpty()) {
			System.out.println(result.take());
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
