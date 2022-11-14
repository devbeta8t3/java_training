package DataStructure;

public class Ex7_2 {

	public static void main(String[] args) {
		
		char deletedItem;
		LinkedStack ls = new LinkedStack();
		
		ls.push('A');
		ls.printStack();
		
		ls.push('B');
		ls.printStack();
		
		ls.push('C');
		ls.printStack();
		
		deletedItem = ls.pop();		// 에러시 LinkedStack 클래스에서 pop() 메소드 char로 변경요.
		
		if (deletedItem!=0) {
			System.out.println("deleted Item : " +deletedItem);
		}
		ls.printStack();
	}

}
