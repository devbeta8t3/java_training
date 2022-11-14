package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class CircleManager {

		public void run() {
			Scanner scanner = new Scanner(System.in);
			
			// 3개의 Circle 배열 선언
			Circle c[] = new Circle[3];
			
			for (int i=0; i<c.length; i++) {			// 배열에 값 넣기
				
				System.out.print("x, y, radius >>");
				double x = scanner.nextDouble();		// x값 입력 받기
				double y = scanner.nextDouble();		// y값 입력 받기
				int radius = scanner.nextInt();			// 반지름 입력 받기
				c[i] = new Circle(x, y, radius);		// Circle 객체 생성
			}
			
			for (int i=0; i<c.length; i++)
				c[i].show();

			scanner.close();
		}
}
