import javax.swing.*;
import java.awt.*;

public class GridLayoutSample extends JFrame {
	GridLayoutSample() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4, 3);
		grid.setVgap(5);
		grid.setHgap(5);
		setLayout(grid);
		for(int i=1; i<=9; i++)
			add(new JButton(Integer.toString(i)));

		add(new JButton("*"));
		add(new JButton("0"));
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutSample();
	}
}
