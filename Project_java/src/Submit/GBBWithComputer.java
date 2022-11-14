package Submit;
import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		// Generated by SH Lee
		// 컴퓨터와 사용자의 가위바위보 게임 프로그램을 작성하세요. 
		// 사용자가 입력하고 <Enter> 키를 치면, 컴퓨터는 랜덤하게 가위, 바위, 보 중 하나를 선택합니다.
		// 그리고 누가 이겼는지 출력합니다. “그만”을 입력하면 게임을 종료합니다.
		
		// 컴퓨터의 가위바위보 배열 생성
		String str[] = {"가위", "바위", "보"};
		int computer;
				
		Scanner in = new Scanner(System.in);
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		
		// 가위 바위 보 시작!
		while (true) {
			System.out.print("가위 바위 보!>>");	// 사용자 가위 바위 보 입력
			String mine = in.next();
			
			// 그만 to 종료
			if (mine.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}
			
			// 올바른 입력일 경우
			// 나의 선택 '가위'의 경우
			if (mine.equals("가위")) {				
				computer = (int)(Math.random()*3); 	// 컴퓨터의 선택(랜덤)
				System.out.print("사용자 = " +mine+ ", 컴퓨터 = " +str[computer]+ ",");
				
				switch (str[computer]) {
					case "가위":
						System.out.println(" 비겼습니다.");
						break;
					case "바위":
						System.out.println(" 컴퓨터가 이겼습니다.");
						break;
					case "보":
						System.out.println(" 사용자가 이겼습니다.");
						break;
				}
			}
			// 나의 선택 '바위'의 경우
			else if (mine.equals("바위")) {
				computer = (int)(Math.random()*3); // 컴퓨터의 선택(랜덤)
				System.out.print("사용자 = " +mine+ ", 컴퓨터 = " +str[computer]+ ",");
				
				switch (str[computer]) {
					case "가위":
						System.out.println(" 사용자가 이겼습니다.");
						break;
					case "바위":
						System.out.println(" 비겼습니다.");
						break;
					case "보":
						System.out.println(" 컴퓨터가 이겼습니다.");
						break;
				}
			}
			// 나의 선택 '보'의 경우
			else if (mine.equals("보")) {
				computer = (int)(Math.random()*3); // 컴퓨터의 선택(랜덤)
				System.out.print("사용자 = " +mine+ ", 컴퓨터 = " +str[computer]+ ",");
				
				switch (str[computer]) {
					case "가위":
						System.out.println(" 컴퓨터가 이겼습니다.");
						break;
					case "바위":
						System.out.println(" 사용자가 이겼습니다.");
						break;
					case "보":
						System.out.println(" 비겼습니다.");
						break;
				}
			}
			// 잘못된 입력일 경우(가위, 바위, 보 이외의 문자열을 입력한 경우)
			else {
				System.out.println("입력이 잘못되었습니다. 다시 입력하세요.");		// 입력 실수 안내 메시지 출력
			}
		}
		in.close();
	}

}