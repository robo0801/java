import java.awt.*;
import javax.swing.*;

public class LineApplet extends JApplet {
	int x1, y1, x2, y2;
	boolean bValid = false;
	public void init() {
		try {
			x1 = Integer.parseInt(getParameter("x1"));
			y1 = Integer.parseInt(getParameter("y1"));
			x2 = Integer.parseInt(getParameter("x2"));
			y2 = Integer.parseInt(getParameter("y2"));
			bValid = true;
		}
		catch(NumberFormatException e) {
			bValid = false;
		}
		setContentPane(new MyPanel());
	}
	public void start() { }
	public void stop() { }
	public void destroy() { }
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(bValid) {
				g.setColor(Color.BLUE);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
