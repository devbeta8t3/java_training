package DataStructure;

class OptExp2 {
	
	private String exp;
	
	public int evalPostfix(String postfix) {		// 응용방법의 패턴을 익혀두는 정도로 학습하세요.
		LinkedStack s = new LinkedStack();
		exp = postfix;
		int opr1;
		int opr2;
		int value;
		char testCh;
		
		for (int i=0; i<7; i++) {
			testCh = exp.charAt(i);
			
			if (testCh!='+' && testCh!='-' && testCh!='*' && testCh!='/') {		// 연산자가 아니면 스택에 쌓는다.
				value = testCh - '0';
				s.push(value);
			}
			else {
				opr2 = s.pop();
				opr1 = s.pop();
				switch (testCh) {
					case '+':
						s.push(opr1+opr2);
						break;
					case '-':
						s.push(opr1-opr2);
						break;
					case '*':
						s.push(opr1*opr2);
						break;
					case '/':
						s.push(opr1/opr2);
						break;
				}
			}
		}
		return s.pop();
		
	}
	
	
}
