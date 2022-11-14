package DataStructure;

public interface Stack {
	boolean isEmpty();
	void push(char item);
	void push(int item);
//	char pop();
	int pop();		// 예제 7-4
	void delete();
//	char peek();
	int peek();		// 예제 7-4
}
