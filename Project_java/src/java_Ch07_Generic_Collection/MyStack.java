package java_Ch07_Generic_Collection;
import java.util.*;

public class MyStack {

	
	public static void main(String[] args) {
		
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("Seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		for (int i=0; i<3; i++) {
			System.out.println(stringStack.pop());
		}

		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		for (int i=0; i<3; i++) {
			System.out.println(intStack.pop());
		}
	}

}

class GStack<T> {		// 타입(T)을 정해두지 않음
	int tos;			// top of stack을 뜻하는 변수
	Object[] stck;	// 일반적인 객체배열 "타입이 정해지지 않음"
	
	public GStack() {
		tos = 0;
		stck = new Object[10];
	}
	
	public void push(T item) {
		if (tos==10) {
			return;
		}
		stck[tos] = item;
		tos++;
	}
	
	public T pop() {
		if (tos==0) {
			return null;
		}
		tos--;
		return (T)stck[tos];	// 정해지지 않은 Type 형태로 리턴
	}
}