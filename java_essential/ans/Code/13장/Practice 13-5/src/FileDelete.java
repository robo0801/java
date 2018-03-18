import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		File dir = new File("c:\\tmp\\");
		File [] files = dir.listFiles(); // 디렉토리의 파일 리스트
		
		for(int i=0; i<files.length; i++) {
			String name = files[i].getName();
			int index = name.lastIndexOf('.'); // 파일명 문자열에서 제일 마지막에 있는 '.' 의 인덱스
			if(index == -1) // 찾을 수 없음
				continue;
			String ext = name.substring(index); // ext = ".txt" 
			if(ext.equals(".txt")) {
				System.out.println(files[i].getPath() + " 삭제");
				files[i].delete();
			}
		}
	}

}
