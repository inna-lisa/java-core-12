package TaskFirst;

public class ProgramRunTimeTest {
	/*
	Напишіть програму, яка кожну секунду відображає на екрані дані про час,
	що пройшов від моменту запуску програми.
	Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Пройшло 5 секунд.
	*/

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		new ThreadOne(start).start();
		new ThreadTwo(start).start();

	}
}
