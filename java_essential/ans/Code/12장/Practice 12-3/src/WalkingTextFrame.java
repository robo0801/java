import java.awt.*;
import javax.swing.*;

public class WalkingTextFrame extends JFrame {
	WalkingTextFrame() {
		super("걸어서 나타나는 텍스트를 가진 레이블");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new WalkingLabel("나는 당신을 사랑합니다."));
		setSize(250,150);
		setVisible(true);
	}
	
	class WalkingLabel extends JLabel implements Runnable {
		String text;
		int count = 1; // 화면에 보일 글자 개수
		WalkingLabel(String text) {
			this.text = text;
			new Thread(this).start(); // 스레드 시작
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { return; }

				// 텍스트의인덱스 0에서 count 개수만큼의 서브 스트링 리턴
				String s = text.substring(0, count); 
				setText(s);
				
				// 카운트가 1~텍스트의 글자수가 되도록 조정
				count %= text.length();
				count++;
			}
		}

	}
	
	public static void main(String[] args) {
		new WalkingTextFrame();
	}

}
