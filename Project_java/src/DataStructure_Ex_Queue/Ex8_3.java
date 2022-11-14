package DataStructure_Ex_Queue;

class Ex8_3 {

	public static void main(String[] args) {
		
		char deletedItem;
		LinkedQueue lq = new LinkedQueue();
		
		lq.enQueue('A');
		lq.printQueue();
		
		lq.enQueue('B');
		lq.printQueue();
		
		deletedItem = lq.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		lq.printQueue();
		
		lq.enQueue('C');
		lq.printQueue();
		
		deletedItem = lq.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		lq.printQueue();
		
		deletedItem = lq.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		lq.printQueue();
		
		deletedItem = lq.deQueue();
		if (deletedItem!=0)
			System.out.println("deleted Item : " +deletedItem);
		lq.printQueue();
		
	}

}
