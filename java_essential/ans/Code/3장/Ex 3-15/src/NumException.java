import java.util.InputMismatchException;
import java.util.Scanner;
public class NumException {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� 5�� �Է�(������ �ƴϸ� ������ �ʽ��ϴ�)>>");
		int sum=0, n=0;
		for (int i=0; i<5; i++) {		
			try {
				n = scanner.nextInt();
				sum += n;
			}
			catch (InputMismatchException e) {
				String r = scanner.next(); // ��ȯ���� ���� scanner�� ���ۿ� ���� �ִ� ��ū�� �о ������.				
				System.out.println(r + "�� ������ ��ȯ�� �� �����ϴ�.");
				continue; // ���� �ݺ����� ��� ����
			}
		}
		System.out.println("���� ���� " + sum);		
	}
}
