package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class CircleManager2 {

		public void run2() {
			Scanner scanner = new Scanner(System.in);
			
			// 3개의 Circle 배열 선언
			Circle2 c2[] = new Circle2[3];
			
			for (int i=0; i<c2.length; i++) {			// 배열에 값 넣기
				
				System.out.print("x, y, radius >>");
				double x = scanner.nextDouble();		// x값 입력 받기
				double y = scanner.nextDouble();		// y값 입력 받기
				int radius = scanner.nextInt();			// 반지름 입력 받기
				c2[i] = new Circle2(x, y, radius);		// Circle 객체 생성
			}
			
			int max = 0;								// max 값을 가진 객체의 인덱스 찾기
			int max_addr = 0;
			for (int i=0; i<c2.length; i++) {
				if (max<c2[i].radius) {					
					max = c2[i].radius;
					max_addr = i;
				}	
			}
			c2[max_addr].show2();
			scanner.close();
		}
}		// review - 멤버변수를 private 처리하고, radius 는 getRad 같은 메소드로 처리해야한다.
