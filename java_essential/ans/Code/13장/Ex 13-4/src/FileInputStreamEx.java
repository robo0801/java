import java.io.*;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte b[] = new byte [6]; // ��� �ִ� byte �迭
		try {
			// "c:\\test.out" ������ �о� �迭 b�� ����
			FileInputStream fin = new FileInputStream("c:\\test.out");
			int n=0, c;
			while((c = fin.read())!= -1) {
				b[n] = (byte)c; // ���� ����Ʈ�� �迭�� ����
				n++;
			}
			// �迭 b�� ����Ʈ ���� ��� ȭ�鿡 ���
			System.out.println("c:\\test.out���� ���� �迭�� ����մϴ�.");
			for(int i=0; i<b.length; i++) // �迭 b ���
				System.out.print(b[i]+" ");
			System.out.println();
			
			fin.close();
		} catch(IOException e) { }
	}
}