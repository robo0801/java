import javax.swing.*;
import java.awt.*;

public class ContainerComponentEx extends JFrame {
	ContainerComponentEx() {
		setTitle("Container & Component");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		LeftPanel p1 = new LeftPanel();
		p1.setSize(150,150);
		p1.setLocation(10,10);
		contentPane.add(p1);
		RightPanel p2 = new RightPanel();
		p2.setSize(150,150);
		p2.setLocation(170,10);
		contentPane.add(p2);
		
		JButton btn = new JButton("OK");
		btn.setLocation(130, 170);
		btn.setSize(70, 30);
		contentPane.add(btn);
		setSize(350, 250);
		setVisible(true);
	}
	
	class LeftPanel extends JPanel {
		LeftPanel() {
			setBackground(Color.YELLOW);
			add(new JLabel("Type ID"));
			add(new JTextField(10));
			add(new JLabel("Type Password"));
			add(new JTextField(10));						
		}
	}
	
	class RightPanel extends JPanel {
		RightPanel() {
			setBackground(Color.GREEN);
			add(new JLabel("좋아하는 프로그램"));
			add(new JCheckBox("Java 프로그램"));
			add(new JCheckBox("C++ 프로그램"));			
		}
	}
	
	public static void main(String[] args) {
		new ContainerComponentEx();
	}
}
