import java.awt.*;
import javax.swing.*;

// 프레임의 NORTH 영역에 부착되는 패널 클래스
class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY); // 배경색 설정
		setLayout(new FlowLayout());
		add(new JButton("Open")); // 현재 패널에 버튼 부착
		add(new JButton("Read")); // 현재 패널에 버튼 부착
		add(new JButton("Close")); // 현재 패널에 버튼 부착	 
	}
}

// 프레임의 CENTER 영역에 부착되는 패널 클래스
class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(null); // 배치관리자 삭제, 절대 위치에 컴포넌트 삽입
		
		JLabel a = new JLabel("Java"); // "Java" 문자열을 레이블 객체로 생성
		a.setSize(100,20);
		a.setLocation(120, 50); // 문자열의 위치 지정
		add(a); // // 현재 패널에 "Java" 문자열 부착
	}		
}

public class SimpleSwingFrame extends JFrame {
	public SimpleSwingFrame() {
		super("Open Challenge 8"); // 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 두 개의 패널을 붙인다.
		add(new NorthPanel(), BorderLayout.NORTH); // NorthPanel을 프레임의 NORTH 영역에 부착한다.
		add(new CenterPanel(), BorderLayout.CENTER); // CenterPanel을 프레임의 CENTER 영역에 부착한다.
		setSize(300,200);
		setVisible(true);
	}
		
	static public void main(String[] arg) {
		new SimpleSwingFrame();
	}
}
