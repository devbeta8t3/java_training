package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class Reservation {

	Seat seat[];						// 객체배열 선언
	
	void runReserv() {
		seat = new Seat[3];				// 객체배열 생성
		for (int i=0; i<3; i++) {		// 객체배열 seat[] 초기화 
			seat[i] = new Seat();		// Seat('S', 10) 이런방식으로 만들어도 된다...
		}
		
		Scanner scanner = new Scanner(System.in);
								
		for (;;) {
			System.out.print("예약:1,  조회:2,  취소:3,  끝내기:4 >> ");
			int menu = scanner.nextInt();			// 메뉴 입력값 
			
			////// menu 1 예약 //////	
			if (menu==1) {
				
				// 해당 좌석 예약상황 보여주기 
				int seat_type;
				for (;;) {
					System.out.print("예약할 좌석구분 S(1), A(2), B(3) >> ");		// 좌석구분 입력
					seat_type = scanner.nextInt();
									
					if (seat_type<1 || seat_type>3) {					// 좌석구분 예외처리
						System.out.println("좌석구분 입력이 잘못되었습니다. 1~3을 입력하세요.");
						continue;
					}
					else break;
				}
				
				if (seat_type==1)
					System.out.print("S>> ");
				else if (seat_type==2)
					System.out.print("A>> ");
				else if (seat_type==3)
					System.out.print("B>> ");	
				
				seat[seat_type-1].printPosition();	// 예약 선택한 좌석타입 보여주기
				
				System.out.print("이름 >> ");			// 예약할 이름 입력
				String name = scanner.next();		
				int seat_num;
				for (;;) {
					System.out.print("좌석번호 >> ");	// 좌석번호 입력
					seat_num = scanner.nextInt();	
					
					if (seat_num<1 || seat_num>10) {	// 좌석번호 예외처리
						System.out.println("좌석번호가 잘못되었습니다. 1~10을 선택하세요.");
						continue;
					}
					else break;
				}
				
				seat[seat_type-1].setPosition(seat_num, name);	// 예약자 자리 설정하기
				continue;
			}
			
			////// menu 2 조회 //////
			else if (menu==2) {
				System.out.print("S>> ");			// S석 예약상황 출력
				seat[0].printPosition();
				System.out.print("A>> ");			// A석 예약상황 출력
				seat[1].printPosition();
				System.out.print("B>> ");			// B석 예약상황 출력
				seat[2].printPosition();
				System.out.println("<<< 조회를 완료하였습니다. >>>");
				continue;
			}
			
			////// menu 3 취소 //////
			else if (menu==3) {
				int seat_type;
				for (;;) {
					System.out.print("예약할 좌석구분 S(1), A(2), B(3) >> ");		// 좌석구분 입력
					seat_type = scanner.nextInt();
									
					if (seat_type<1 || seat_type>3) {					// 좌석구분 예외처리
						System.out.println("좌석구분 입력이 잘못되었습니다. 1~3을 입력하세요.");
						continue;
					}
					else break;
				}
				// 해당 좌석 예약상황 보여주기 
				switch (seat_type) {
					case 1:
						System.out.print("S>> ");
					case 2:
						System.out.print("A>> ");
					case 3:
						System.out.print("B>> ");
				}
				seat[seat_type-1].printPosition();	// 취소 선택한 좌석타입 보여주기
				
				String name;
				for (;;) {
					System.out.print("이름 >> ");			// 취소할 이름 입력 및 예외처리
					name = scanner.next();		
					int count = 0;
					
					for (int i=0; i<10; i++) {
						if (name.equals(seat[seat_type-1].getName(i))) {	// 이름이 있으면
							seat[seat_type-1].delPosition(name);			// 예약 취소 설정
							count++;
						}
					}
					
					if (count==0) {										// 이름이 없으면 다시 입력
						System.out.println("입력하신 이름은 예약자 명단에 없습니다. 다시 입력하세요.");
						continue;
					}
					else break;
				}
								
			}
			
			////// menu 4 종료 //////
			else if (menu==4) {
				System.out.println("종료합니다...");
				scanner.close();
				return;
			}
			
			// 예외처리 (입력 실수 - 반복문 처음으로)
			else {
				System.out.println("입력이 잘못되었습니다. 다시 입력하세요.");
				continue;						
			}
		}
		
	}
}
