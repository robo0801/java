
import java.awt.*;
import javax.swing.*;

public class ThreeColorCircle extends JFrame {
	public ThreeColorCircle() {
		super("»ï»ö¿ø");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(120,150);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillArc(10, 10, 100, 100, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(10, 10, 100, 100, 210, 120);
			g.setColor(Color.YELLOW);
			g.fillArc(10, 10, 100, 100, 330, 120);			
		}
	}
	public static void main(String[] args) {
		new ThreeColorCircle();
	}
}