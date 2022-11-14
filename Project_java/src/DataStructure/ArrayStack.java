package DataStructure;

class ArrayStack implements Stack {

	private int top;
	private int stackSize;
	private char itemArray[];
	
	public ArrayStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];
	}
	
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == this.stackSize-1);
	}
	
	@Override
	public void push(char item) {
		if (isFull()) {
			System.out.println("Inserting fail! Array Stack is full!!");
		}
		else {
			itemArray[++top] = item;
			System.out.println("Inserted Item : " +item);
		}
	}

	@Override
	public char pop() {			// 꺼낸다.(값 확인 + 지우기)
		if (isEmpty()) {
			System.out.println("Deleting(popping) fail! Array Stack is empty!!");
			return 0;
		}
		else {
			return itemArray[top--];
		}
	}

	@Override
	public void delete() {		// 지우기만 한다.
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
		}
		else {
			top--;
		}
	}

	@Override
	public char peek() {		// 값만 확인
		if (isEmpty()) {
			System.out.println("peeking fail! Array Stack is empty!!");
			return 0;
		}
		else {
			return itemArray[top];
		}
	}
	
	public void printStack() {
		if (isEmpty()) {
			System.out.println("Array Stack is empty!!");
			System.out.println();
		}
		else {
			System.out.print("Array Stack >> ");
			for (int i=0; i<=top ; i++) {
				System.out.print(itemArray[i]+ " ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
