import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MonsterGameFrame extends JFrame {	
	// �ƹ�Ÿ�� ����� ���ڿ��� "@", ������ ����� ���ڿ��� "M", ����Ű�� 'q', ������ 200ms �ֱ�� �����δ�
	JPanel gamePanel = new GamePanel("@", "M", 'q', 200); // ���� �г�, ����Ʈ������ ����Ѵ�.

	public MonsterGameFrame() {
		setTitle("Open Challenge 12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(gamePanel); // GamePanel�� ����Ʈ������ ����Ѵ�.
	
		setSize(300,300);
		setVisible(true);
	
		gamePanel.requestFocus(); // GamePanel�� Ű�� �Է¹��� �� �ֵ��� ��Ŀ���� �����Ѵ�.
	}

	// ������ ����Ǵ� �г�. ��ġ�����ڸ� null�� ����
	class GamePanel extends JPanel {
		String avatarChar;
		String monsterChar;
		char quitChar;
		long monsterDelay;
		JLabel avatar;// �ƹ�Ÿ�� ���� ���̺�
		JLabel monster; // ������ ���� ���̺�
		final int AVATAR_MOVE = 10; // �ƹ�Ÿ�� �ѹ��� �����̴� �ȼ� ��

		public GamePanel(String avatarChar, String monsterChar, char quitChar, long monsterDelay) {
			this.avatarChar = avatarChar;
			this.monsterChar = monsterChar;
			this.quitChar = quitChar;
			this.monsterDelay = monsterDelay;
			
			// �ƹ�Ÿ�� ���� ���̺� ����
			avatar = new JLabel(avatarChar); 
			monster = new JLabel(monsterChar);
			
			setLayout(null); // ��Ÿ�� ���̺�� ���� ���̺��� ��ġ�� ������� ������ �� �ֵ��� null�� ����
			addKeyListener(new MyKeyListener()); // Ű ������ ���
			
			// �ƹ�Ÿ ���̺��� ��ġ�� ũ�� ���� �� �ҿ� ����
			avatar.setLocation(50,150);
			avatar.setSize(15,15);
			avatar.setForeground(Color.RED);
			add(avatar);
			
			// ���� ���̺��� ��ġ�� ũ�� ���� �� �ҿ� ����
			monster.setLocation(200,5);
			monster.setSize(15,15);
			add(monster);
			
			// ������ �����̴� ������ ���� �� ���� 
			MonsterThread th = new MonsterThread(monster, avatar, monsterDelay);
			th.start();

		}
		
		// GamePanel�� ��ϵ� Ű ������. ��, ��, ��, �� Ű�� 'q' Ű ó��
		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == quitChar) // ���� Ű�� �����ڵ� Ű
					System.exit(0); // ���� Ű�� �ԷµǸ� ���α׷� ����
				
				int keyCode = e.getKeyCode(); // ��, ��, ��, �� Ű�� �����ڵ� Ű�� �ƴ�
				
				// Ű�� ���� �ƹ�Ÿ ���̺��� AVATAR_MOVE �ȼ� ��ŭ �����δ�.
				switch(keyCode) {
				case KeyEvent.VK_UP: 
					avatar.setLocation(avatar.getX(), avatar.getY()-AVATAR_MOVE); 
					break;
				case KeyEvent.VK_DOWN: 
					avatar.setLocation(avatar.getX(), avatar.getY()+AVATAR_MOVE); 
					break;
				case KeyEvent.VK_LEFT: 
					avatar.setLocation(avatar.getX()-AVATAR_MOVE, avatar.getY()); 
					break;
				case KeyEvent.VK_RIGHT: 
					avatar.setLocation(avatar.getX()+AVATAR_MOVE, avatar.getY()); 
					break;
				}
				
				avatar.getParent().repaint(); // �ƹ�Ÿ�� ��ġ�� ����Ǿ����Ƿ� �ٽ� �׸���
				// �ƹ�Ÿ�� �ִ� �гο��� ������ ��ġ�� �־��� �ƹ�Ÿ�� ������ �ϱ� ������
				// �ƹ�Ÿ�� �θ� �гο��� �ٽñ׸��⸦ ������
			}
		}
	}

	// ���� ���̺��� �����̴� 200ms �� 5 �ȼ��� �����̸鼭 ���Ӿ��� �ƹ�Ÿ�� �����ϴ� ������
	// �����ڴ� �� ���� ���̺� ������Ʈ�� ���޹޴´�. ù��° from�� �ι�° to ���̺��� �����Ѵ�.
	class MonsterThread extends Thread {
		JLabel from; // ���ư��� ���̺�. ���� ���̺�
		JLabel to; // �������� ���̺�. �ƹ�Ÿ ���̺�
		long monsterDelay;
		final int MONSTER_MOVE = 5; // from ���̺��� �ѹ��� �̵��ϴ� �Ÿ�
		
		MonsterThread(JLabel from, JLabel to, long monsterDelay) {
			this.from = from;
			this.to = to;
			this.monsterDelay = monsterDelay;
		}
		
		public void run() {
			int x=from.getX(),y=from.getY(); // ���� ������ ��ġ
			
			while(true) {
				if(to.getX() < from.getX()) // �ƹ�Ÿ�� ������ ������ �ִ� ��� 
					x = from.getX() - MONSTER_MOVE;
				else 						// �ƹ�Ÿ�� ������ �������� �ִ� ���
					x = from.getX() + MONSTER_MOVE;
				
				if(to.getY() < from.getY()) // �ƹ�Ÿ�� ������ ������ �ִ� ���
					y = from.getY() - MONSTER_MOVE;
				else 						// �ƹ�Ÿ�� ������ �Ʒ����� �ִ� ���
					y = from.getY() + MONSTER_MOVE;			
				
				// ������ ��ġ ����
				from.setLocation(x, y);
				
				// ������ ��ġ�� ����Ǿ��� ������ ������ �����ϴ� �г��� �ٽ� �׸����� ��
				from.getParent().repaint();
				
				// 200ms ���� ���� �ܴ�.
				try {
					sleep(monsterDelay);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	
	public static void main(String [] args) {
		new MonsterGameFrame();
	}
} 