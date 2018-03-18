
public class switchWithoutBreakEx {

	public static void main(String[] args) {
		char grade='A';
		switch(grade) {
			case 'A':
				System.out.println("90~100점입니다.");
				//break;
			case 'B':
				System.out.println("80~89점입니다.");
				break;
			case 'C':
				System.out.println("70~79점입니다.");
				break;
		}

	}

}
