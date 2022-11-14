package DataStructure_Ex_Queue;

class Ex8_4 {

	public static void main(String[] args) {
		
		char deletedItem;
		DQueue dq = new DQueue();
		
		dq.insertFront('A');
		dq.printQueue();
		
		dq.insertFront('B');
		dq.printQueue();
		
		dq.insertRear('C');
		dq.printQueue();
		
		deletedItem = dq.deleteFront();
		if (deletedItem!=0)
			System.out.println("Front deleted Item : " +deletedItem);
		dq.printQueue();
		
		deletedItem = dq.deleteRear();
		if (deletedItem!=0)
			System.out.println("Rear deleted Item : " +deletedItem);
		dq.printQueue();
		
		dq.insertRear('D');
		dq.printQueue();
		
		dq.insertFront('E');
		dq.printQueue();
		
		dq.insertFront('F');
		dq.printQueue();
	}

}
