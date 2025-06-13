package TaskFirst;

public class ThreadOne extends Thread{
	long start;
	long during;
	long end;

	public ThreadOne(long start) {
		this.start = start;
		this.end = start + 60 * 1000;
	}

	@Override
	public void run() {
		while (System.currentTimeMillis() < end) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			during = System.currentTimeMillis() - start;
			System.out.println("time = " + during + " milliseconds");
		}
	}
}
