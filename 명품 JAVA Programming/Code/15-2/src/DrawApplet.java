import java.awt.*;
import javax.swing.*;

public class DrawApplet extends JApplet {
	String shape;
	Color color;
	int a, b, c, d;
	boolean bValid = false;
	public void init() {
		try {
			shape = getParameter("shape");
			color = new Color(Integer.parseInt(getParameter("color"), 16));			
			a = Integer.parseInt(getParameter("a"));
			b = Integer.parseInt(getParameter("b"));
			c = Integer.parseInt(getParameter("c"));
			d = Integer.parseInt(getParameter("d"));
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
			if(!bValid) return;
			g.setColor(color);
			
			if(shape.equals("line"))
				g.drawLine(a,b,c,d);
			else if(shape.equals("rect"))
				g.drawRect(a,b,c,d);
			else if(shape.equals("oval"))
				g.drawOval(a,b,c,d);
			
		}
	}
}
