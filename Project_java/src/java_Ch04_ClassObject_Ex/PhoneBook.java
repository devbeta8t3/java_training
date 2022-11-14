package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class PhoneBook {

	Scanner scanner = new Scanner(System.in);
	
	public void run() {
		// 인원수 입력 (객체배열 만들기)
		System.out.print("전화번호부의 인원수>> ");		// 인원수 입력
		int num = scanner.nextInt();
		
		Phone phone[] = new Phone[num];				// 객체배열 선언
		for (int i=0; i<num; i++) {
			phone[i] = new Phone(null, null);		// 객체배열 초기화
		}
		
		// 이름, 전화번호 입력 (객체배열 길이만큼 반복)
		for (int i=0; i<num; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈칸 없이 입력)>> ");	// 이름과 전화번호 입력
			String name = scanner.next();
			String tel = scanner.next();
			phone[i].setName(name);
			phone[i].setTel(tel);
		}
		System.out.println("저장되었습니다...");	
		
		// 검색 (반복)
		while (true) {
			
			System.out.print("검색할 이름(종료 입력시 프로그램 종료)>> ");			// 검색할 이름 입력 (종료조건 만들기)
			String inputName = scanner.next();
			
			int count = 0;
			for (int i=0; i<num; i++) {					// 입력한 이름과 객체배열 이름 비교(반복)
				
				if (phone[i].getName().equals(inputName)) {		// 이름 있는 경우 // 전화번호 출력
					System.out.println(phone[i].getName()+ "의 전화번호는 " +phone[i].getTel()+ " 입니다.");
					count++;
				}
				if (inputName.equals("종료")) {			// 종료
					System.out.println("종료합니다...");
					return;
				}
			}
			if (count==0) {										// 이름 없는 경우
				System.out.println(inputName+ "이 없습니다.");
			}
		}
	}
	
}
