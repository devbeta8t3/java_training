package DataStructure_Ex_Queue;

class Ex8_1 {

	public static void main(String[] args) {
		
		int queueSize = 3;
		char deletedItem;
		ArrayQueue q = new ArrayQueue(queueSize);
		
		q.enQueue('A');
		q.printQueue();
		
		q.enQueue('B');
		q.printQueue();
		
		deletedItem = q.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		q.printQueue();
		
		q.enQueue('C');
		q.printQueue();
		
		deletedItem = q.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		q.printQueue();
		
		deletedItem = q.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		q.printQueue();
		
		deletedItem = q.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		q.printQueue();
	}

}
