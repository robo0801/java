import java.util.Scanner;

public class PrintAlphabet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("알파벳 한 문자를 입력하세요>>");
		String s = scanner.next(); // 입력을 문자열로 읽음
		char c = s.charAt(0); // 문자열의 첫 번째 문자
		
		for(char a='a'; a<=c; a++) {
			for(char b=a; b<=c; b++) {
				System.out.print(b);
			}
			System.out.println();
		}
		scanner.close();
	}

}
