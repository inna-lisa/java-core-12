package TaskSecond;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessQueue {
	private final BlockingQueue<Object> result = new LinkedBlockingQueue<>();
	private final LinkedBlockingQueue<Integer> numbers;
	private volatile int n;
	private final AtomicInteger countIsAllUse;
	private int countIsEmptyResult;

	public ProcessQueue(LinkedBlockingQueue<Integer> numbers) throws InterruptedException {
		this.numbers = numbers;
		countIsAllUse = new AtomicInteger(numbers.size());
		countIsEmptyResult = numbers.size();
		n = numbers.take();
	}

	public synchronized void extractNumber() throws InterruptedException {
		n = numbers.take();
	}

	public void fizz() throws InterruptedException {

		while (countIsAllUse.get() > 0) {
			if (n % 3 == 0 && n % 5 != 0) {
				result.put("fizz");
				countIsAllUse.getAndDecrement();
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void buzz() throws InterruptedException {

		while (countIsAllUse.get() > 0) {
			if (n % 5 == 0 && n % 3 != 0) {
				result.put("buzz");
				countIsAllUse.getAndDecrement();
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void fizzbuzz() throws InterruptedException {

		while (countIsAllUse.get() > 0) {
			if (n % 15 == 0) {
				result.put("fizzbuzz");
				countIsAllUse.getAndDecrement();
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void numbers() throws InterruptedException {

		while (countIsAllUse.get() > 0) {
			if (n % 3 != 0 && n % 5 != 0) {
				result.put(n);
				countIsAllUse.getAndDecrement();

				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
		while (countIsEmptyResult > 0) {
			System.out.println(result.take());
			countIsEmptyResult--;
		}
	}
}

