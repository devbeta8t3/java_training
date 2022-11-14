package java_Ch04_ClassObject;

public class MyExpTest {

	void runMyExp() {
		MyExp number1 = new MyExp();
		number1.base = 2;
		number1.exp = 3;
		
		MyExp number2 = new MyExp();
		number2.base = 3;
		number2.exp = 4;
		
		System.out.println("2의 3승 = " + number1.getValue());
		System.out.println("3의 4승 = " + number2.getValue());
	}
}
