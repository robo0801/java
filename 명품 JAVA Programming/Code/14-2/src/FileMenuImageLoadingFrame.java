import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileMenuImageLoadingFrame extends JFrame {
	public FileMenuImageLoadingFrame() {
		super("�޴��� ��� �̹��� �ε��ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		createMenu();
		
		setSize(400,400);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenu fileMenu = new JMenu("����");
		JMenuItem openItem = new JMenuItem("����");
		openItem.addActionListener(new OpenActionListener());	
		fileMenu.add(openItem);
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		setJMenuBar(mb);		
	}

	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		OpenActionListener() {
			chooser= new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG Images", "jpg");
		    chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", 
							"���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			MyPanel p = (MyPanel)getContentPane();
			ImageIcon icon = new ImageIcon(filePath);
			p.setBgImage(icon.getImage());
		}
	}

	class MyPanel extends JPanel {
		private Image bgImg = null;
		
		public void setBgImage(Image bgImg) {
			this.bgImg = bgImg;
			repaint();
		}
		public void paintComponent(Graphics g) {
			if(bgImg == null) // initially bgImg is null
				return;
			g.drawImage(bgImg, 0,0,this.getWidth(), this.getHeight(), this);
		}
	}
	
	static public void main(String[] arg) {
		new FileMenuImageLoadingFrame();
	}
}
