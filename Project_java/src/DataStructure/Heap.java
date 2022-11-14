package DataStructure;

class Heap {

	private int heapSize;
	private int itemHeap[];
	
	public Heap() {
		heapSize = 0;
		itemHeap = new int[50];
	}
	
	public void insertHeap(int item) {
		int i = ++heapSize;
		while ((i!=1) && (item>itemHeap[i/2])) {
			itemHeap[i] = itemHeap[i/2];	
			i = i/2;
		}
		itemHeap[i] = item;
	}
	
	public int getHeapSize() {
		return this.heapSize;
	}
	
	public int deleteHeap() {
		int parent;
		int child;
		int item;
		int temp;
		item = itemHeap[1];
		temp = itemHeap[heapSize--];
		parent = 1;
		child = 2;
		
		while (child <= heapSize) {
			if ((child<heapSize) && (itemHeap[child]<itemHeap[child+1]))
				child++;
			if (temp >= itemHeap[child])
				break;
			
			itemHeap[parent] = itemHeap[child];
			parent = child;
			child = child * 2;
		}
		itemHeap[parent] = temp;
		return item;
	}
	
	public void printHeap() {
		System.out.print("\nHeap >>> ");
		for (int i=1; i<=heapSize; i++) {
			System.out.print(" " +itemHeap[i]);
		}
	}
	
}
