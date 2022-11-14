package java_Ch05_Inheritance;

// SmartPhone 클래스는 PDA를 상속받고,
// MobiePhoneInterface와 MP3Interface 인터페이스에 선언된 추상 메소드를 모두 구현한다.

class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {
	

	// MobilePhoneInterface의 추상 메소드 구현
	//override
	public void sendCall() {
		System.out.println("따르르르릉~~");
	}
	//override
	public void receiveCall() {
		System.out.println("전화 왔어요");
	}
	//override
	public void sendSMS() {
		System.out.println("문자 갑니다.");
	}
	//override
	public void receiveSMS() {
		System.out.println("문자 왔어요.");
	}
	
	// MP3Interface의 추상 메소드 구현
	//override
	public void play() {
		System.out.println("음악 플레이합니다.");
	}
	//override
	public void stop() {
		System.out.println("음악 중단합니다.");
	}
	
	// 추가로 작성한 메소드
	public void schedule() {
		System.out.println("일정 관리합니다.");
	}
}
