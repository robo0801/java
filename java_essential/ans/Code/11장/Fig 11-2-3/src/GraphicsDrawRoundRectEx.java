import javax.swing.*;
import java.awt.*;

public class GraphicsDrawRoundRectEx extends JFrame {
	Container contentPane;
	GraphicsDrawRoundRectEx() {
		setTitle("drawRoundRect ���  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());

		setSize(200, 150);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRoundRect(20, 20, 120, 80, 40, 60);
		}	
	}
	
	public static void main(String [] args) {
		new GraphicsDrawRoundRectEx();
	}
} 