package TaskSecond;

import java.util.concurrent.*;

public class FizzBuzzTest {
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Integer> numbers = new LinkedBlockingQueue<>();

		for (int i = 1; i <= 15; i++) {
			numbers.put(i);
		}

		ProcessThread threadA = new ProcessThread();
		ProcessThread threadB = new ProcessThread();
		ProcessThread threadC = new ProcessThread();
		ProcessThread threadD = new ProcessThread();

		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();

		for (Integer number : numbers) {
			threadA.fizz(number);
			threadB.buzz(number);
			threadC.fizzbuzz(number);
			threadD.numbers(number);
		}
		threadA.join();
		threadB.join();
		threadC.join();
		threadD.join();
	}
}
