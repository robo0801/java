import javax.swing.*;
import java.awt.*;

public class JButtonJLabelEx extends JFrame {
	JButtonJLabelEx() {
		setTitle("잠깐! JButton과 JLabel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane(); // 컨텐트팬 알아내기
		contentPane.setLayout(new FlowLayout());
		
		JButton b = new JButton("버튼");
		b.setBackground(Color.orange); // 버턴의 배경색을 RED로 설정
		contentPane.add(b); // 컨텐트팬에 버턴 달기

		contentPane.add(new JLabel("안녕하세요")); // 컨텐트팬에 문자열 달기
	
		setSize(230, 100); // 프레임 크기 230x100 설정
		setVisible(true); // 화면에 프레임 출력
	}
	public static void main(String[] args) {
		new JButtonJLabelEx();
	}
}
