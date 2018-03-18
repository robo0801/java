import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AudioFrame extends JFrame {
	AudioClip clip = null;
	JLabel msg = new JLabel("����� ������ �ε��ϼ���");
	public AudioFrame() {
		super("����� ������ ã�� ����/���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		msg.setHorizontalAlignment(JLabel.CENTER);
		add(msg);
		setSize(400,150);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenu fileMenu = new JMenu("����");
		JMenuItem openItem = new JMenuItem("����");
		openItem.addActionListener(new OpenActionListener());	
		fileMenu.add(openItem);
		
		JMenu audioMenu = new JMenu("�����");
		JMenuItem playItem = new JMenuItem("����");
		audioMenu.add(playItem);
		playItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clip != null) {
					msg.setText("������� �����մϴ�.");
					clip.play();
				}
			}
		});
		JMenuItem stopItem = new JMenuItem("����");
		audioMenu.add(stopItem);
		stopItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clip != null) {
					msg.setText("���ָ� �ߴ��մϴ�.");					
					clip.stop();
				}
			}
		});
		
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		mb.add(audioMenu);
		setJMenuBar(mb);		
	}

	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		OpenActionListener() {
			chooser= new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Audio Files(wav,au, mid, rmf)", "wav", "au", "mid",  "rmf");
		    chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", 
							"���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			URL audioURL = null;
			try {
				audioURL = new URL("file:///"+ filePath);
			}catch(MalformedURLException ex) {}
			clip  = Applet.newAudioClip(audioURL);
			msg.setText("����� ���� �ε��� �Ϸ�Ǿ����ϴ�");
		}
	}

	static public void main(String[] arg) {
		new AudioFrame();
	}
}
