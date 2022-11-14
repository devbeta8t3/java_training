
public class CircleArea {

	public static void main(String[] args) {
		final double PI = 3.14;	//원주율
		double radius = 10;		//반지름
		double circleArea = 0;	//원의 면적
		
		circleArea = radius * radius * PI;	//원의 면적 계산
		
		System.out.println("원의 면적 = " + circleArea);
	}

}
