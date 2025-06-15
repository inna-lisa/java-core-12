package TaskSecond;

import java.util.concurrent.*;

public class FizzBuzzTest {
	public static void main(String[] args) throws InterruptedException {

		LinkedBlockingQueue<Integer> numbers = new LinkedBlockingQueue<>();

		for (int i = 1; i <= 33; i++) {
			numbers.put(i);
		}

		ProcessQueue processQueue= new ProcessQueue(numbers);


		Thread threadA = new Thread(() ->
		{
				try {
					processQueue.fizz();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
		});

		Thread threadB = new Thread(() ->
		{
			try {
				processQueue.buzz();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		Thread threadC = new Thread(() ->
		{
			try {
				processQueue.fizzbuzz();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		Thread threadD = new Thread(() ->
		{
			try {
				processQueue.numbers();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();

		threadA.join();
		threadB.join();
		threadC.join();
		threadD.join();

		System.out.println("The End");
	}
}
