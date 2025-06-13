package TaskFirst;

public class ThreadTwo extends Thread{
	long start;
	long end;

	public ThreadTwo(long start) {
		this.start = start;
		this.end = start + 60 * 1000;
	}

	@Override
	public void run() {
		while (System.currentTimeMillis() < end) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println("5 seconds have passed");
		}
	}
}
