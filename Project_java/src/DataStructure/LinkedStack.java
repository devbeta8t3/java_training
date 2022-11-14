package DataStructure;

class LinkedStack implements Stack {

	StackNode top;
	
	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public void push(char item) {						// push 메소드
		StackNode newNode = new StackNode();				// 스택노드 newNode 생성
		newNode.data = item;								// 입력된 item을 newNode.data에 입력
		newNode.link = top;									// newNode 다음은 top 설정
		top = newNode;										// top에 newNode 덮어쓰기
		System.out.println("Inserted Item : " +item);
	}
	
	public void push(int item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	@Override
//	public char pop() {
	public int pop() {		// 예제 7-4	// 예제 10-2
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else {
//			char item = top.data;
			int item = top.data;	// 예제 7-4	// 예제 10-2
			top = top.link;
			return item;
		}
	}
	
	@Override
	public void delete() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
		}
		else {
			top = top.link;
		}
	}

	@Override
//	public char peek() {
	public int peek() {		// 예제 7-4
		if (isEmpty()) {
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else {
			return top.data;
		}
	}
	
	public void printStack() {
		if (isEmpty()) {
			System.out.println("Linked Stack is empty!!");
			System.out.println();
		}
		else {
			StackNode temp = top;
			System.out.println("Linked Stack >> ");
			while (temp!=null) {
				System.out.print("\t" +temp.data+ "\n");
				temp = temp.link;
			}
			System.out.println();
		}
	}

}

class StackNode{
	int data;
//	char data;
	StackNode link;
}