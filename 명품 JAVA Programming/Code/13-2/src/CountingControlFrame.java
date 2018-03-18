import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CountingControlFrame extends JFrame {
	CountingControlFrame() {
		setTitle("타이머 스레드 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new MyLabel(0));
		setSize(300,300);
		setVisible(true);
	}
	
	class MyLabel extends JLabel implements Runnable {
		boolean bPaused = true;
		int value;
		Thread timerThread = null;
		public MyLabel(int value) {
			super(Integer.toString(value));
			this.value = value;
			this.setFont(new Font("TimesRoman", Font.ITALIC, 50));
			this.setHorizontalAlignment(JLabel.CENTER);
	
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(timerThread == null) {
						timerThread = new Thread(MyLabel.this);
						timerThread.start();
					}
					else if(timerThread.isAlive())
						timerThread.interrupt();
					else {
						timerThread = new Thread(MyLabel.this);
						timerThread.start();
					}
				}
			});
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException e){
					value = 0;
					setText(Integer.toString(value));
					return;
				}
				value++;
				setText(Integer.toString(value));
			}
		}
	}
	
	public static void main(String [] args) {
		new CountingControlFrame();
	}
} 
