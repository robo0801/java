import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AudioFrame extends JFrame {
	AudioClip clip = null;
	JLabel msg = new JLabel("오디오 파일을 로딩하세요");
	public AudioFrame() {
		super("오디오 파일을 찾아 연주/종료 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		msg.setHorizontalAlignment(JLabel.CENTER);
		add(msg);
		setSize(400,150);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenu fileMenu = new JMenu("파일");
		JMenuItem openItem = new JMenuItem("열기");
		openItem.addActionListener(new OpenActionListener());	
		fileMenu.add(openItem);
		
		JMenu audioMenu = new JMenu("오디오");
		JMenuItem playItem = new JMenuItem("연주");
		audioMenu.add(playItem);
		playItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clip != null) {
					msg.setText("오디오를 연주합니다.");
					clip.play();
				}
			}
		});
		JMenuItem stopItem = new JMenuItem("종료");
		audioMenu.add(stopItem);
		stopItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clip != null) {
					msg.setText("연주를 중단합니다.");					
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
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", 
							"경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			URL audioURL = null;
			try {
				audioURL = new URL("file:///"+ filePath);
			}catch(MalformedURLException ex) {}
			clip  = Applet.newAudioClip(audioURL);
			msg.setText("오디오 파일 로딩이 완료되었습니다");
		}
	}

	static public void main(String[] arg) {
		new AudioFrame();
	}
}
