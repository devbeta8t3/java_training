public class foreachEx {
	
	enum Week {월,화,수,목,금,토,일}
	
	public static void main(String[] args) {
		int num[] = {1,2,3,4,5};
		String names[] = {"사과","배","바나나","체리","딸기","포도"};
		int sum = 0;
		
		// k는 num[0], num[1], ..., num[4] 반복
		for (int k: num)
			sum += k;
		System.out.println("합은 " + sum);
		
		// s는 names[0], ..., names[4] 반복
		for (String s: names)
			System.out.print(s + " ");
		System.out.println();
		
		// day는 월,화,...,일 값으로 반복
		for (Week day: Week.values())
			System.out.print(day + "요일 ");
		System.out.println();
	}

}
