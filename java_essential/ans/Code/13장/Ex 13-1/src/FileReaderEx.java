import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader in = null;
		try {
			in = new FileReader("c:\\windows\\system.ini"); // ���� �Է� ��Ʈ�� ����
	        int c;
            while ((c = in.read()) != -1) { // ���� ������ ���� ������ �д´�.
                System.out.print((char)c);
            }
			in.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}
	}
}