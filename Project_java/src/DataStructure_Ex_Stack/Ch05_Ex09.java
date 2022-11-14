package DataStructure_Ex_Stack;

import java.util.Scanner;

public class Ch05_Ex09 {

	public static void main(String[] args) {

		ArrayStack as = new ArrayStack();
		Scanner sc = new Scanner(System.in);

		// 스택사이즈 설정 (입력)
		int stackSize; 
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		stackSize = sc.nextInt();
		as.setCapa(stackSize);
		
		//문자열 입력으로 스택 push
		String val;
		while (true) {	// 스택 용량 만큼 반복 (문자열 입력)
			System.out.print("문자열 입력 >> ");
			val = sc.next();
			
			if (val.equals("그만")) {			// "그만" 입력시 스택 출력 후 종료
				as.printStack();			// allPop()으로 구현해보자************************ to do
				break;
			}
			else if (as.length() >= as.capacity())			// 스택 길이가 용량 오버하면 에러메시지
				System.out.println("스택이 꽉 차서 푸시 불가!");
			else
				as.push(val);				// 스택에 문자열 입력
		}
		sc.close();
	}
}
