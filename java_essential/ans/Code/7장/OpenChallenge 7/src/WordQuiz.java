import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Word { // 영어 단어와 한글 단어를 쌍으로 가진 하나의 어휘 표현
	private String english; // 영어 단어
	private String korean; // 영어 단어에 해당하는 한글 단어
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
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "자기"));
		v.add(new Word("honey", "애인"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1로 초기화
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			} while(index == answerIndex || exists(n, index)); // 다시 시도
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
		System.out.println("영어 어휘 테스트를 시작합니다. 1~4 외 다른 입력시 종료합니다.");
		while(true) {
			int answerIndex = (int)(Math.random()*v.size());
			String eng = v.get(answerIndex).getEnglish();
			int example[] = new int [4]; // 보기에 들어갈 벡터의 index 배열
			int answerLoc = makeExample(example, answerIndex); // 정답이 있는 보기 번호
			example[answerLoc] = answerIndex;

			// 문제를 출력합니다.
			System.out.println(eng + "?");
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ") " + v.get(example[i]).getKorean() + " "); // 보기 출력
			
			System.out.print(":>"); // 프롬프트
			try {
				int in = scanner.nextInt(); // 사용자의 정답 입력
				if(in < 1 || in > 4) {
					System.out.print("프로그램을 종료합니다...");
					return; // ouf of example ranges. 프로그램 종료
				}

				in--; // 사용자가 1~4 사이의 정답 입력
				if(in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No. !!");
			}
			catch(InputMismatchException e) {
				scanner.next(); // 현재 스트림 버퍼에 입력되어 있는 입력을 읽어서 제거함
				System.out.print("프로그램을 종료합니다...");
				return; // 프로그램 종료
			}
		}
		
	}
	
	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz();
		quiz.run();

	}

}
