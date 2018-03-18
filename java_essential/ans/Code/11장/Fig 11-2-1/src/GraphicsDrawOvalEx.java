import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsDrawOvalEx extends JFrame {
	GraphicsDrawOvalEx() {
		setTitle("drawOval 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());

		setSize(200, 150);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.drawOval(20, 20, 80, 80);
		}	
	}
	
	public static void main(String [] args) {
		new GraphicsDrawOvalEx();
	}
} 