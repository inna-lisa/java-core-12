package TaskSecond;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessQueue {
	private final BlockingQueue<Object> result = new LinkedBlockingQueue<>();
	private final LinkedBlockingQueue<Integer> numbers;
	private int n;
	private int countIsAllUse;
	private int countIsEmptyResult;

	public ProcessQueue(LinkedBlockingQueue<Integer> numbers) throws InterruptedException {
		this.numbers = numbers;
		countIsAllUse = numbers.size();
		countIsEmptyResult = numbers.size();
		n = numbers.take();
	}

	public synchronized void extractNumber() throws InterruptedException {
		n = numbers.take();
		countIsAllUse--;
	}

	public synchronized int getN() {
		return n;
	}

	public void fizz() throws InterruptedException {

		while (countIsAllUse > 1) {
			int n = getN();
			if (n % 3 == 0 && n % 5 != 0) {
				result.put("fizz");
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void buzz() throws InterruptedException {

		while (countIsAllUse > 1) {
			int n = getN();
			if (n % 5 == 0 && n % 3 != 0) {
				result.put("buzz");
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void fizzbuzz() throws InterruptedException {

		while (countIsAllUse > 1) {
			int n = getN();
			if (n % 15 == 0) {
				result.put("fizzbuzz");
				if (!numbers.isEmpty()) {
					extractNumber();
				}
			}
		}
	}

	public void numbers() throws InterruptedException {

		while (countIsAllUse > 1) {
			int n = getN();
			if (n % 3 != 0 && n % 5 != 0) {
				result.put(n);
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

