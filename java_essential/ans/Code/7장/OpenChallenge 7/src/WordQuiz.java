import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Word { // ���� �ܾ�� �ѱ� �ܾ ������ ���� �ϳ��� ���� ǥ��
	private String english; // ���� �ܾ�
	private String korean; // ���� �ܾ �ش��ϴ� �ѱ� �ܾ�
	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}
	public String getEnglish() { return english; }
	public String getKorean() { return korean; }
	
}
public class WordQuiz {
	private Vector<Word> v;

	public WordQuiz() {
		v = new Vector<Word>();
		v.add(new Word("love", "���"));
		v.add(new Word("animal", "����"));
		v.add(new Word("emotion", "����"));
		v.add(new Word("human", "�ΰ�"));
		v.add(new Word("stock", "�ֽ�"));
		v.add(new Word("trade", "�ŷ�"));
		v.add(new Word("society", "��ȸ"));
		v.add(new Word("baby", "�ڱ�"));
		v.add(new Word("honey", "����"));
		v.add(new Word("dall", "����"));
		v.add(new Word("bear", "��"));
		v.add(new Word("picture", "����"));
		v.add(new Word("painting", "�׸�"));
		v.add(new Word("fault", "����"));
		v.add(new Word("example", "����"));
		v.add(new Word("eye", "��"));
		v.add(new Word("statue", "������"));
	}
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1�� �ʱ�ȭ
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			} while(index == answerIndex || exists(n, index)); // �ٽ� �õ�
			n[i] = index;
		}

		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length);
	}
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
		}
		return false;
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���� �׽�Ʈ�� �����մϴ�. 1~4 �� �ٸ� �Է½� �����մϴ�.");
		while(true) {
			int answerIndex = (int)(Math.random()*v.size());
			String eng = v.get(answerIndex).getEnglish();
			int example[] = new int [4]; // ���⿡ �� ������ index �迭
			int answerLoc = makeExample(example, answerIndex); // ������ �ִ� ���� ��ȣ
			example[answerLoc] = answerIndex;

			// ������ ����մϴ�.
			System.out.println(eng + "?");
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ") " + v.get(example[i]).getKorean() + " "); // ���� ���
			
			System.out.print(":>"); // ������Ʈ
			try {
				int in = scanner.nextInt(); // ������� ���� �Է�
				if(in < 1 || in > 4) {
					System.out.print("���α׷��� �����մϴ�...");
					return; // ouf of example ranges. ���α׷� ����
				}

				in--; // ����ڰ� 1~4 ������ ���� �Է�
				if(in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No. !!");
			}
			catch(InputMismatchException e) {
				scanner.next(); // ���� ��Ʈ�� ���ۿ� �ԷµǾ� �ִ� �Է��� �о ������
				System.out.print("���α׷��� �����մϴ�...");
				return; // ���α׷� ����
			}
		}
		
	}
	
	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz();
		quiz.run();

	}

}
