class TimerThread extends Thread {
	int n = 0;
	
	public void run() {
		while (true) { // ���ѷ����� �����Ѵ�.
			System.out.println(n);
			n++;
			try {
				sleep(1000); // 1�� ���� ���� �� �� �����.
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		th.start();
	}
}