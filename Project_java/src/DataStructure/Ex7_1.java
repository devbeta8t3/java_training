package DataStructure;

public class Ex7_1 {

	public static void main(String[] args) {

		int stackSize = 5;
		char deletedItem;
		ArrayStack s = new ArrayStack(stackSize);
		
		s.push('A');
		s.printStack();
		
		s.push('B');
		s.printStack();
		
		s.push('C');
		s.printStack();
		
		deletedItem = s.pop();
		if (deletedItem !=0) {
			System.out.println("deleted Item : " +deletedItem);
		}
		s.printStack();
	}

}
