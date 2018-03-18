public class StringStack implements StackInterface {
	private String[] element;
	private int index;
	public StringStack(int capacity) {
		element = new String[capacity];
		index = 0; // 앞으로 들어갈 배열의 인덱스 
	}
	@Override
	public int length() {
		return index;
	}

	@Override
	public String pop() {
		if(index == 0) // 스택이 비었음
			return null;
		index--; // 스택 포인터 감소
		return element[index];
	}

	@Override
	public boolean push(String ob) {
		if(index == element.length)
			return false; // 스택이 다 찼음
		element[index++] = ob; // 요소 스택에 저장 후 스택 포인터 증가
		return true;
	}
}
