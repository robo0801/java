import java.awt.Color;
import javax.swing.*;

public class TenSecondsFrame extends JFrame {
	TenSecondsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,150);
		setVisible(true);
		TenSecondsThread th = new TenSecondsThread();
		th.start();
	}
	
	class TenSecondsThread extends Thread {
		public void run() {
			setTitle("실행 시작");
			getContentPane().setBackground(Color.YELLOW);
			try {
				sleep(10000);
			} catch (InterruptedException e) { return; }
			setTitle("실행 종료");
			getContentPane().setBackground(Color.BLUE);
		}
	}

	public static void main(String[] args) {
		new TenSecondsFrame();
	}

}
