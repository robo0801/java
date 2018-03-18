import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 1~100���� ���ڸ� ������Ű�鼭 �ϴ� 369����
public class Game369DoubleFrame extends JFrame{
	public Game369DoubleFrame() {
		setTitle("369 ���� ���� �ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class GamePanel extends JPanel {
		TimerThread th;
		JLabel [] card = new JLabel [2]; // �� ���� �����ڿ��� ���ڰ� ��µǴ� ����
		JButton startBtn = new JButton("start");
		int n = 1; // ���� ���� ����
		char key; // ����ڰ� ���� Ű ����
		boolean isKeyPressed = false; // Ű�� �ԷµǾ������� ��Ÿ���� �Ҹ� ��. Ű�� �������� true�� ����. �ʱ⿡�� � Ű�� �������� ���� ����
		User [] user = new User [2]; // ���ӿ� �����ϴ� �����
		
		GamePanel() {
			user[0] = new User("������, Ű:AS", 'a', 's'); // 369�� ���ڿ� �Է��ϴ� Ű�� a, 369�� �� ���� ���ڿ� ���� �Է��ϴ� Ű�� s
			user[1] = new User("��û��, Ű:KL", 'k', 'l'); // 369�� ���ڿ� �Է��ϴ� Ű�� k, 369�� �� ���� ���ڿ� ���� �Է��ϴ� Ű�� l
			
			setLayout(null); // ��ġ������ ����
			this.addKeyListener(new KeyHandler());

			// name ���̺� ���� �� ���̱�
			for(int i=0; i<card.length; i++) {
				JLabel name = new JLabel(user[i].getName());
				name.setFont(new Font("���", Font.PLAIN, 15));
				name.setHorizontalAlignment(JLabel.CENTER);
				name.setSize(100, 50);
				name.setLocation(50+110*i,50);
				add(name);
			}
			
			// card ���� �� ���̱�
			for(int i=0; i<card.length; i++) {				
				card[i] = new JLabel();
				card[i].setOpaque(true);
				card[i].setBackground(Color.ORANGE);
				card[i].setFont(new Font("���", Font.ITALIC, 30)); // ���� ũ�� 30 �ȼ�, �ѱ��� ����Ϸ��� �ѱ��� �����ϴ� ���ü ���� ��� �Ѵ�.
				card[i].setHorizontalAlignment(JLabel.CENTER); // ���ڸ� ���̺��� �߾ӿ� ��ġ
				card[i].setSize(100, 50);
				card[i].setLocation(50+110*i,100);
				add(card[i]);
			}
			
			//startBtn
			startBtn.setLocation(100, 200);
			startBtn.setSize(100, 30);
			
			// ���� ��ư�� Ŭ���Ǹ� �����带 ���� ��Ű���� �̺�Ʈ ������ �ޱ�
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ī���� �ؽ�Ʈ�� ��� �����.
					card[0].setText("");
					card[1].setText("");
					
					// �ʱ�ȭ
					n = 1;
					isKeyPressed = false;
					card[(n+1)%2].setText(Integer.toString(n)); // ���ڸ� ���ڿ��� ��ȯ�Ͽ� ���
					card[(n+1)%2].requestFocus(); // Ű �Է��� ���� �� �ֵ��� ��Ŀ���� �ش�.
					th = new TimerThread();
					th.start(); // ������ ����
					
					// ��ư ��Ȱ��ȭ
					JButton b = (JButton)e.getSource();
					b.setEnabled(false); // ��ư�� �ٽ� �������� �ʵ��� ��Ȱ��ȭ ��Ŵ
					
					// ����Ʈ ���� Ű �Է��� ���� �� �ֵ��� Ű ��Ŀ�� ��ȯ
					b.getParent().requestFocus();
				}
			});
			add(startBtn);
		}
		
		class TimerThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(700); // 300 �и��� �Ŀ� ��ȣ ����

						// 1�� �Ŀ��� Ŭ���� �ȵǸ� ���ӿ��� ���Ե�
						int x = n%10; // �Ʒ� �ڸ� ��
						int y = n/10; // ���� �ڸ� ��		
	
						int turn = (n+1)%2; // �̹� ������ ����� �ε���
						int next = (turn+1)%2; // ���� ������ ����� �ε���
						
						if((x == 3 || x == 6 || x == 9) && (y == 3 || y == 6 || y == 9)) { // �� �ڸ��� ��� 3, 6, 9 �� ��� �Ǻ�
							if(isKeyPressed == true && user[turn].isDoubleKey(key)) { // turn ����
								isKeyPressed = false; 
							}
							else if(isKeyPressed == true && user[(turn+1)%2].isKey(key)){ // turn �� ����� �Ǽ�, ����
								msg(next, "Fail");
								break;
							}
							else { 							
								msg(turn, "Fail"); // turn�� ����
								break;
							}
						}
						else if(x == 3 || x == 6 || x == 9 || y == 3 || y == 6 || y == 9) { // �� �ڸ��� �� �� �ڸ��� 3,6,9�� ��� �Ǻ�
							if(isKeyPressed == true && user[turn].isSingleKey(key)) { // turn ����
								isKeyPressed = false; 
							}
							else if(isKeyPressed == true && user[next].isKey(key)){ // turn �� ����� �Ǽ�, ����
								msg(next, "Fail");
								break;
							}
							else { 							
								msg(turn, "Fail"); // turn�� ����
								break;
							}
						}
						else { // 3,6,9�� � ��Ȳ�� �ƴ� ���
							if(isKeyPressed == true && user[turn].isKey(key)) { // turn�� Ű�� ���� ���
								msg(turn, "Fail"); // turn�� ���ӿ��� ��
								break;
							}
							else if(isKeyPressed == true && user[next].isKey(key)){ // turn �� ����� Ű�� ���� ���
								msg(next, "Fail"); // turn �� ����� ���ӿ��� ��								
								break;
							}
							isKeyPressed = false; // Ű�� �������� ���� ������ ����							
						}
						n++; // ���� ����
						if(n==100) { // ��� �¸���
							msg(0, "Win!!");
							msg(1, "Win!!");
							break; // ������ �����ϰ� �ٽ� �����ϵ��� �Ѵ�.
						}
						else
							card[next].setText(Integer.toString(n)); // ������ ���ڸ� ���ڿ��� ��ȯ�Ͽ� ���
					} catch (InterruptedException e) {
						return;	// ���α׷� ����					
					}
				}
				startBtn.setEnabled(true); // ���� ��ư Ȱ��ȭ
			}
			
			void msg(int id, String s) { // id�� ī���� �ε���
				card[id].setText(s); // ���ڸ� ���ڿ��� ��ȯ�Ͽ� ���		
			}
		}
		
		class KeyHandler extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				key = e.getKeyChar();
				isKeyPressed = true;
				int turn = (n+1)%2; // ������ ����� �ε���
				card[turn].setBackground(Color.GREEN);				
			}
			public void keyReleased(KeyEvent e) {
				int turn = (n+1)%2; // ������ ����� �ε���
				card[turn].setBackground(Color.ORANGE);				
			}			
			
		}
		
		// ���ӿ� �����ϴ� ����ڸ� �����ϴ� Ŭ����
		class User {
			String name; // ������� �̸�
			char singleKey; // Ű ��. 369 �� ���ڸ� �ϳ� ���� ��� �����Ͽ� �Է��ؾ��ϴ� Ű
			char doubleKey; // Ű ��. 369 �� ���ڸ� �ΰ� ���� ��� �����Ͽ� �Է��ؾ��ϴ� Ű
			User(String name, char singleKey, char doubleKey) {
				this.name = name;
				this.singleKey = singleKey;
				this.doubleKey = doubleKey;				
			}
			String getName(){return name;}
			boolean isKey(char key) {
				return singleKey == key || doubleKey == key;
			}
			boolean isSingleKey(char key) {
				return singleKey == key;
			}
			boolean isDoubleKey(char key) {
				return doubleKey == key;
			}
		}
	}

	public static void main(String[] args) {
		new Game369DoubleFrame();
	}
}
