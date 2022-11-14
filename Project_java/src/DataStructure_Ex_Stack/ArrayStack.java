package DataStructure_Ex_Stack;

class ArrayStack implements Stack {

	int stackSize;
	int top;
	String[] itemArray;
	
	public void setCapa(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		itemArray = new String[this.stackSize];

	}
	@Override
	public int length() {
		return top+1;
	}
	
	@Override
	public int capacity() {
		return stackSize;
	}

	@Override
	public String pop() {
		String strPop = itemArray[top];
		top--;
		return strPop;
	}

	@Override
	public void push(String val) {
		itemArray[top+1] = val;
		top++;
	}
	
	public void printStack() {			// pop으로 구현해야됨 allPop()으로 구현해보자! ********* to do
		System.out.print("스택에 저장된 모든 문자열 팝 : ");
		for (int i=this.length()-1; i>=0; i--) {
			System.out.print(itemArray[i]+ " ");
		}
	}

}
