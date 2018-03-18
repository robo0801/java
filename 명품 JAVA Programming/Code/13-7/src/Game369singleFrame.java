import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 1~100까지 숫자를 증가시키면서 하는 369게임
public class Game369singleFrame extends JFrame{
	public Game369singleFrame() {
		setTitle("369 게임 혼자 하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		setSize(300,300);
		setVisible(true);	
	}
	
	class GamePanel extends JPanel {
		TimerThread th; // 게임을 진행하는 스레드.
		JLabel card = new JLabel(); // 진행되는 수를 출력하는 카드
		JButton startBtn = new JButton("start");
		int n = 1; // 게임 시작 숫자
		boolean singleClicked=false; // 마우스 싱글 클릭이 발생하면 true 
		boolean doubleClicked=false; // 마우스 더블 클릭이 발생하면 true
		
		GamePanel() {
			setLayout(null); // 배치관리자 삭제

			// card
			card.setOpaque(true);
			card.setBackground(Color.ORANGE);
			card.setFont(new Font("Arial", Font.ITALIC, 30)); // 글자 크기 30 픽셀
			card.setHorizontalAlignment(JLabel.CENTER); // 숫자를 레이블의 중앙에 배치
			card.setText(Integer.toString(n)); // 숫자를 문자열로 변환하여 출력
			card.setSize(100, 50);
			card.setLocation(100,100);
			card.addMouseListener(new MouseHandler()); // 마우스 핸들러 달기
			add(card);
					
			//startBtn
			startBtn.setLocation(100, 200);
			startBtn.setSize(100, 30);
			
			// 시작 버튼이 클릭되면 스레드를 시작 시키도록 이벤트 리스너 달기
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					n = 1;
					card.setText(Integer.toString(n)); // 숫자를 문자열로 변환하여 출력
					singleClicked = false;
					doubleClicked = false; 
					th = new TimerThread();
					th.start(); // 스레드 시작
					
					// 버튼 비활성화
					JButton b = (JButton)e.getSource();
					b.setEnabled(false); // 버튼이 다시 눌러지지 않도록 비활성화 시킴
				}
			});
			add(startBtn);
		}
		
		synchronized void setSingleClicked(boolean b) {
			singleClicked = b;
		}
		
		synchronized void setDoubleClicked(boolean b) {
			doubleClicked = b;
		}
		
		class TimerThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(700); // 300 밀리초 후에 번호 갱신

//						System.out.println(n+"-------");
//						System.out.println("singleClicked"+singleClicked);
//						System.out.println("doubleClicked"+doubleClicked+"\n");

						// 1초 후에도 클릭이 안되면 게임에서 지게됨
						int x = n%10; // 아래 자리 수
						int y = n/10; // 높은 자리 수
						
						if((x == 3 || x == 6 || x == 9) && (y == 3 || y == 6 || y == 9)) { // 두 자리수 모두 3, 6, 9 인 경우 판별
							if(doubleClicked == true) { // 더블 클릭이 눌러진 정상적인 경우
								setDoubleClicked(false); // 눌러진 더블 클릭 마우스 정보 해제								
							}
							else {
								msg("Fail^^");
								break;							
							}
						}
						else if(x == 3 || x == 6 || x == 9 || y == 3 || y == 6 || y == 9) { // 두 자리수 중 한 자리만 3,,6,9인 경우 판별
							if(singleClicked == true) {
								setSingleClicked(false); // 눌러진 마우스 정보 해제								
							}
							else {
								msg("Fail^");
								break;
							}
						}
						else {
							if(singleClicked == true || doubleClicked == true) { // 마우스가 눌러 졌다면 실패
								msg("Fail^");
								break;
							}
						}
						
						n++; // 숫자 증가
						if(n==100) {
							msg("Win!!");
							break; // 게임을 종료한다.
						}
						else
							card.setText(Integer.toString(n)); // 숫자를 카드에 출력	
					} catch (InterruptedException e) {
						return; // 프로그램 종료						
					}
				}
				startBtn.setEnabled(true); // 시작 버튼 활성화			
			}
			
			void msg(String s) {
				card.setText(s);
			}
		}
		
		class MouseHandler extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 2) { // 더블 클릭. 33, 66, 99 등의 경우
					setDoubleClicked(true); // 더블 마우스 클릭 표시
					setSingleClicked(false); // 싱글 마우스 클릭 표시					
				}
				else { // 싱글 클릭
					setSingleClicked(true); // 싱글 마우스 클릭 표시					
				}
				JLabel card = (JLabel)e.getSource();
				card.setBackground(Color.GREEN);
			}
			public void mouseReleased(MouseEvent e) {
				JLabel card = (JLabel)e.getSource();
				card.setBackground(Color.ORANGE);				
			}			
		}
	}
	

	public static void main(String[] args) {
		new Game369singleFrame();
	}

}
