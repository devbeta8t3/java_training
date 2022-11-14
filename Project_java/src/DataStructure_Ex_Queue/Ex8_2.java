package DataStructure_Ex_Queue;

class Ex8_2 {

	public static void main(String[] args) {
		
		int queueSize = 4;
		char deletedItem;
		ArrayCQueue cq = new ArrayCQueue(queueSize);
		
		cq.enQueue('A');
		cq.printQueue();
		
		cq.enQueue('B');
		cq.printQueue();
		
		deletedItem = cq.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		cq.printQueue();
		
		cq.enQueue('C');
		cq.printQueue();
		
		cq.enQueue('D');
		cq.printQueue();
		
		cq.enQueue('E');
		cq.printQueue();
	}

}
