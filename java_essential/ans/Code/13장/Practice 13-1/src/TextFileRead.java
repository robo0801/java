import java.io.*;

public class TextFileRead {
	public static void main(String[] args) {
		try {
			FileReader fin = new FileReader("c:\\tmp\\sample.txt");
			int c;
			while((c=fin.read()) != -1) {
				System.out.print((char)c);
			}
			fin.close();
		}
		catch(IOException e) {
			System.out.println("파일 읽기 오류");
		}
	}
}
