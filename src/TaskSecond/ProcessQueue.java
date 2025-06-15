package TaskSecond;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessQueue {
	private final BlockingQueue<Object> result = new LinkedBlockingQueue<>();
	private final LinkedBlockingQueue<Integer> numbers;
	private Boolean flag = true;
	private int n;
	private int count;
	private final int maxCount;

	public ProcessQueue(LinkedBlockingQueue<Integer> numbers) throws InterruptedException {
		this.numbers = numbers;
		maxCount = numbers.size();
		count = 1;
		n = numbers.take();
	}

	public void extractNumber() throws InterruptedException {
		n = numbers.take();
		flag = true;
	}

	public void fizz() throws InterruptedException {

		while (count <= maxCount) {
			if (flag) {
				if (n % 3 == 0 && n % 5 != 0) {
					result.put("fizz");
					flag = false;
					count++;
					if (!numbers.isEmpty()) {
						extractNumber();
					}
				}
			}
		}
	}

	public void buzz() throws InterruptedException {

		while (count <= maxCount) {
			if (flag) {
				if (n % 5 == 0 && n % 3 != 0) {
					result.put("buzz");
					flag = false;
					count++;
					if (!numbers.isEmpty()) {
						extractNumber();
					}
				}
			}
		}
	}

	public void fizzbuzz() throws InterruptedException {

		while (count <= maxCount) {
			if (flag) {
				if (n % 15 == 0) {
					result.put("fizzbuzz");
					flag = false;
					count++;
					if (!numbers.isEmpty()) {
						extractNumber();
					}
				}
			}
		}
	}

	public void numbers() throws InterruptedException {

		while (count <= maxCount) {
			if (flag) {
				if (n % 3 != 0 && n % 5 != 0) {
					result.put(n);
					flag = false;
					count++;
					if (!numbers.isEmpty()) {
						extractNumber();
					}
				}
			}
		}
		while (!result.isEmpty()) {
			System.out.println(result.take());
		}
	}
}

