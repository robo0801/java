import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarAndMessageDialogFrame extends JFrame {
	public ToolBarAndMessageDialogFrame() {
		super("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tBar = new JToolBar();
		tBar.add(new JLabel("학번 : "));
		JTextField tf = new JTextField(8);
		tf.addKeyListener(new MyKeyListener());
		tBar.add(tf);
		add(tBar, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {// 숫자 키 아님
				String k = Character.toString(e.getKeyChar());
				k = k.concat("는 숫자 키가 아닙니다. \r\n숫자를 입력하세요.");
				JOptionPane.showMessageDialog(null, k, "경고", JOptionPane.ERROR_MESSAGE);
				e.consume();
			}
		}
	}

	static public void main(String[] arg) {
		new ToolBarAndMessageDialogFrame();
	}
}
