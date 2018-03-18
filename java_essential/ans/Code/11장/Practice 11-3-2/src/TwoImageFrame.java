import java.awt.*;
import javax.swing.*;

public class TwoImageFrame extends JFrame {
	public TwoImageFrame() {
		setTitle("두 이미지 밑으로 나란히 보이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		Image imgA = new ImageIcon("images/a.jpg").getImage();
		Image imgB = new ImageIcon("images/b.jpg").getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgA, 0, 0, getWidth(), getHeight()/2, this);
			g.drawImage(imgB, 0, getHeight()/2, getWidth(), getHeight()/2, this);			
		}
	}
	public static void main(String[] args) {
		new TwoImageFrame();
	}
}