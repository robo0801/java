import javax.swing.*;

import java.awt.*;

public class GraphicsDrawRectEx extends JFrame {
	GraphicsDrawRectEx() {
		setTitle("drawRect 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());

		setSize(200, 150);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRect(20, 20, 80, 80);
		}	
	}
	
	public static void main(String [] args) {
		new GraphicsDrawRectEx();
	}
} 