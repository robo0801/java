public class ArrayException {
	public static void main(String[] args) {
		int [] intArray = {1,2,3,4};
		int i=0, sum=0;
		try {
			for(i=0; i<10; i++) { // �迭 ������ 4�ε� 10�� ����
				sum += intArray[i]; // i=4 �϶� ���� �߻�
				System.out.println("�ε��� " + i + "������ �� = " + sum);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("intArray["+ i + "]"+ "�� ������ �� �����ϴ�.");
			System.out.println(" �ε����� ������ ������ϴ�.");
		}
	}
}
