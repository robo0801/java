import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;

public class MenuItemActionListener  extends JFrame {
	JTextArea ta = new JTextArea();
	
	MenuItemActionListener() {
		super("파일 저장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		c.add(new JScrollPane(ta));
		setSize(300,200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenu fileMenu = new JMenu("파일");
		JMenuItem save = new JMenuItem("저장");
		fileMenu.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ta.getText().length() == 0) {
					JOptionPane.showMessageDialog(MenuItemActionListener.this, 
							"입력된 내용이 없습니다.",
							"Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String fileName = JOptionPane.showInputDialog(MenuItemActionListener.this, 
						"저장할 파일명을 입력하세요");
				if(fileName == null) {
					JOptionPane.showMessageDialog(MenuItemActionListener.this,
							"파일을 저장하지 않습니다.",
							"Warning", JOptionPane.WARNING_MESSAGE);
					return;					
				}
				try {
					FileWriter fout = new FileWriter(fileName); // 파일 스트림 열기
					String t = ta.getText(); // 입력된 텍스트를 문자열로 얻어내기
					StringTokenizer st = new StringTokenizer(ta.getText(), "\n"); // 라인 단위로 분리
					while(st.hasMoreTokens()) {
						fout.write(st.nextToken()); // 한 라인 쓰기
						fout.write("\r\n"); // 라인 끝에 다음 줄로 넘어가는 문자 삽입
					}
					fout.close(); // 파일 스트림 닫기
				} catch (IOException e1) {}
			}
		});
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		setJMenuBar(mb);		
	}
	
	public static void main(String[] args) {
		new MenuItemActionListener();

	}

}
