
public class switchWithoutBreakEx {

	public static void main(String[] args) {
		char grade='A';
		switch(grade) {
			case 'A':
				System.out.println("90~100���Դϴ�.");
				//break;
			case 'B':
				System.out.println("80~89���Դϴ�.");
				break;
			case 'C':
				System.out.println("70~79���Դϴ�.");
				break;
		}

	}

}
