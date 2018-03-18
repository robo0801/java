import java.awt.*;
import javax.swing.*;

public class FourImageFrame extends JFrame {
	FourImageFrame() {
		super("4 Images");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,4,10,10));
		
		ImageIcon img [] = new ImageIcon [4];
		img[0] = new ImageIcon("images/img1.jpg");
		img[1] = new ImageIcon("images/img2.jpg");
		img[2] = new ImageIcon("images/img3.jpg");
		img[3] = new ImageIcon("images/img4.jpg");
		
		for(int i=0; i<img.length; i++)
			c.add(new JLabel(img[i]));
		
		setSize(500, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FourImageFrame();
	}

}
