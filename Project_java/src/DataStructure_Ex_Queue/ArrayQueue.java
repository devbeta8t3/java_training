package DataStructure_Ex_Queue;

class ArrayQueue implements Queue {

	private int front;					// 첫 원소의 인덱스-1
	private int rear;					// 마지막 원소의 인덱스
	private int queueSize;				// 큐 크기
	private char itemArray[];
	
	public ArrayQueue(int queueSize) {			// 생성자
		front = -1;
		rear = -1;
		this.queueSize = queueSize;						// 큐 사이즈
		itemArray = new char[this.queueSize];
	}

	@Override
	public boolean isEmpty() {
		return (front == rear);
	}

	public boolean isFull() {
		return (rear == this.queueSize-1);
	}
	
	@Override
	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("Inserting fail! Array Queue is full!!");
		}
		else {
			rear++;
			itemArray[rear] = item;
			System.out.println("Inserted Item : " +item);
		}
	}

	@Override
	public char deQueue() {		// 삭제
		if (isEmpty()) {			// 비어있으면 에러메시지
			System.out.println("Deleting fail! Array Queue is empty!!");
			return 0;
		}
		else {
			front++;
			return itemArray[front];	// front+1 하고 해당 캐릭터 리턴
		}
	}

	@Override
	public void delete() {
		if (isEmpty()) {			// 비어있으면 에러메시지
			System.out.println("Deleting fail! Array Queue is empty!!");
		}
		else {
			front++;
		}
	}

	@Override
	public char peek() {
		if (isEmpty()) {			// 비어있으면 에러메시지
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}
		else {
			return itemArray[front+1];	// 첫 원소 캐릭터 리턴
		}
	}
	
	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Array Queue is empty!!");
			System.out.println();
		}
		else {
			System.out.print("Array Queue >> ");
			for (int i=front+1; i<=rear; i++) {
				System.out.print(" " +itemArray[i]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
