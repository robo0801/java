import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ToolBarAndOptionPaneFrame extends JFrame {
	public ToolBarAndOptionPaneFrame() {
		super(" 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tBar = new JToolBar();
		JButton btn = new JButton("종료");
		btn.addActionListener(new CloseActionListener());
		tBar.add(btn);
		add(tBar, BorderLayout.NORTH);
		
		setSize(400,400);
		setVisible(true);
	}
	
	class CloseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까", "옵션팬", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				// 사용자가 "예"나 "아니오"의 선택없이 다이얼로그창을닫은 경우
				return; // not exited
			}
			else if(result == JOptionPane.YES_OPTION) {
				// 사용자가 "예"를 선택한 경우
				System.exit(0);
			}
			else {	// 사용자가 "아니오"를 선택한 경우
				return; // not exited
			}
		}
	}
	
	static public void main(String[] arg) {
		new ToolBarAndOptionPaneFrame();
	}
}
