import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoRadioFrame extends JFrame {
	JRadioButton red = new JRadioButton("Red");
	JRadioButton blue = new JRadioButton("Blue");

	TwoRadioFrame() {
		super("Two Radio Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ButtonGroup g = new ButtonGroup();
		g.add(red);
		g.add(blue);
		
		c.add(red);
		c.add(blue);
		MyItemListener listener = new MyItemListener();
		red.addItemListener(listener);
		blue.addItemListener(listener);
		
		setSize(250, 100);
		setVisible(true);
		
	}

	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() != ItemEvent.SELECTED)
				return;
			if(e.getItem() == red) {
				getContentPane().setBackground(Color.RED);
			}
			else if(e.getItem() == blue) {
				getContentPane().setBackground(Color.BLUE);
			}
		}
	}
	
	public static void main(String[] args) {
		new TwoRadioFrame();

	}
}
