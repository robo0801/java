import java.util.InputMismatchException;
import java.util.Scanner;

public class OddAndEvenWithInputMismatchException {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");
		int n;
		try {
			n = scanner.nextInt();
			if(n%2 == 0)
				System.out.println("짝수");
			else
				System.out.println("홀수");			
		}
		catch(InputMismatchException e) {
			System.out.println("수를 입력하지 않아 프로그램 종료합니다.");
		}
		finally {
			scanner.close();
		}
	}
}
