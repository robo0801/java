import java.awt.*;
import javax.swing.*;

// �������� NORTH ������ �����Ǵ� �г� Ŭ����
class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY); // ���� ����
		setLayout(new FlowLayout());
		add(new JButton("Open")); // ���� �гο� ��ư ����
		add(new JButton("Read")); // ���� �гο� ��ư ����
		add(new JButton("Close")); // ���� �гο� ��ư ����	 
	}
}

// �������� CENTER ������ �����Ǵ� �г� Ŭ����
class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(null); // ��ġ������ ����, ���� ��ġ�� ������Ʈ ����
		
		JLabel a = new JLabel("Java"); // "Java" ���ڿ��� ���̺� ��ü�� ����
		a.setSize(100,20);
		a.setLocation(120, 50); // ���ڿ��� ��ġ ����
		add(a); // // ���� �гο� "Java" ���ڿ� ����
	}		
}

public class SimpleSwingFrame extends JFrame {
	public SimpleSwingFrame() {
		super("Open Challenge 8"); // Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �� ���� �г��� ���δ�.
		add(new NorthPanel(), BorderLayout.NORTH); // NorthPanel�� �������� NORTH ������ �����Ѵ�.
		add(new CenterPanel(), BorderLayout.CENTER); // CenterPanel�� �������� CENTER ������ �����Ѵ�.
		setSize(300,200);
		setVisible(true);
	}
		
	static public void main(String[] arg) {
		new SimpleSwingFrame();
	}
}
