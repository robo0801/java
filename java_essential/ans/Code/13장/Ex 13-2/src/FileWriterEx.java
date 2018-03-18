import java.io.*;

public class FileWriterEx {
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in); // ���� �Է� ��Ʈ�� ����
		
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\tmp\\test.txt"); // ���ϰ� ����� ��� ���� ��Ʈ�� ����
			while ((c = in.read()) != -1) {
				fout.write(c); // Ű����κ��� �Է¹��� ���ڸ� ���Ͽ� ����
			}
            in.close();
            fout.close();
		} catch (IOException e) {
			System.out.println("�����  ����");
		}
	}
}