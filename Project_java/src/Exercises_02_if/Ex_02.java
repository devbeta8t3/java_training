package Exercises_02_if;
import java.util.Scanner;

public class Ex_02 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int ten = 0;
		int one = 0;
				
		System.out.print("2자리수 정수 입력(10~99)>>");
		int k = a.nextInt(); 
		ten = k / 10;
		one = k % 10;
		
		if (ten == one)
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		else
			System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
	}

}	// self-review : 예외처리 고려할것.
