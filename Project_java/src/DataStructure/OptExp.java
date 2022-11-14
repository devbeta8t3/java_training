package DataStructure;

class OptExp {
	
	private String exp;			// 표현식
	private int expSize;
	private char testCh;		// 한글자씩 테스트하는 케릭터
	private char openPair;
	
	public boolean testPair(String exp) {
		this.exp = exp;
		LinkedStack s = new LinkedStack();
		expSize = this.exp.length();
		
		for (int i=0; i<expSize; i++) {
			testCh = this.exp.charAt(i);
			switch (testCh) {
				case '(':
				case '{':
				case '[':
					s.push(testCh);
					break;
				case ')':
				case '}':
				case ']':
					if (s.isEmpty())
						return false;
					else {
						openPair = s.pop();		// LinkedStack 클래스 pop() 메소드 char로 변경하면 에러 사라짐.
						if ((openPair=='(' && testCh!=')') ||
							(openPair=='{' && testCh!='}') ||
							(openPair=='[' && testCh!=']')) {
							return false;
						}
						else break;
					}
			}
		}
		if (s.isEmpty())
			return true;
		else 
			return false;
	}
	
	public char[] toPostfix(String infix) {
		char testCh;
		exp = infix;
		int expSize = 10;
		int j = 0;
		char postfix[] = new char[expSize];		// 결과를 담을 배열
		LinkedStack s = new LinkedStack();
		
		for (int i=0; i<=expSize; i++) {
			testCh = this.exp.charAt(i);
			switch(testCh) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j++] = testCh;		// 숫자가 나오면 결과 배열에 집어넣는다.
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					s.push(testCh);				// 연산자가 나오면 스택에 쌓는다.
					break;
				case ')':
					postfix[j++] = s.pop();		// 닫는 괄호가 나오면 스택의 연산자를 꺼내서 결과배열에 집어넣는다.
					break;
				default:
					
			}
		}
		postfix[j] = s.pop();
		return postfix;
	}
}
