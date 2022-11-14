package DataStructure_Ex_Stack;

interface Stack {
	int length();			// 현재 스택에 저장된 갯수
	int capacity();			// 스택의 전체 크기
	String pop();			// 스택의 top 꺼내기
	void push(String val);	// 스택에 문자열 저장
}
