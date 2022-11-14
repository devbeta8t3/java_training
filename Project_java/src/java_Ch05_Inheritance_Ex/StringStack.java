package java_Ch05_Inheritance_Ex;


class StringStack implements Stack {
	// 연습문제 9
	
	private String contents[];	// 문자열 저장
	private int count; 			// 스택에 저장된 문자열 갯수
	private int top;
	
	public StringStack(int a) {
		contents = new String[a];
		top = a;				// 전체 칸 갯수
	}
	
	@Override
	public int length() {		// 현재 스택에 저장된 갯수
		for (int i=0; i<capacity(); i++) {
			if (contents[i]!=null)
				count++;
		}
		return count;
	}
	@Override
	public int capacity() {		// 스택의 전체 저장 가능한 갯수
		return contents.length;
	}
	@Override
	public String pop() {		// 스택의 top에 저장된 문자열
		return contents[count-1];
	}
	@Override
	public boolean push(String val) {	// 스택의 top에 문자열 저장
		if (contents[top-1]==null)
			return true;
		else return false;
	}
	public void setContents(String input) {
		for (int i=0; i<capacity(); i++) {
			if (contents[i]==null) {
				contents[i] = input;
				break;
			}
		}
		
	}
	public void printAll() {
		for (int i=capacity()-1; i>=0; i--) {
			System.out.print(contents[i]+ " ");
		}
		System.out.println();
		
	}
}
