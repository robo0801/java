import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarAndMessageDialogFrame extends JFrame {
	public ToolBarAndMessageDialogFrame() {
		super("���ڰ� �ƴ� Ű�� �ԷµǴ� ��� ���â �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tBar = new JToolBar();
		tBar.add(new JLabel("�й� : "));
		JTextField tf = new JTextField(8);
		tf.addKeyListener(new MyKeyListener());
		tBar.add(tf);
		add(tBar, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {// ���� Ű �ƴ�
				String k = Character.toString(e.getKeyChar());
				k = k.concat("�� ���� Ű�� �ƴմϴ�. \r\n���ڸ� �Է��ϼ���.");
				JOptionPane.showMessageDialog(null, k, "���", JOptionPane.ERROR_MESSAGE);
				e.consume();
			}
		}
	}

	static public void main(String[] arg) {
		new ToolBarAndMessageDialogFrame();
	}
}
