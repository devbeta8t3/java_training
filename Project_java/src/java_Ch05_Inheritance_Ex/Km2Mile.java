package java_Ch05_Inheritance_Ex;

class Km2Mile extends Converter {

	// 연습문제 3
		public Km2Mile(double r) {		// km - mile 비율 결정
			ratio = r;
		}
		public double convert(double src){
			return src/ratio;
		}
		
		public String srcString() {			// 소스 통화 단위 : 원
			return "km";
		}
		
		public String destString() {		// 목표 통화 단위 : 달러
			return "mile";
		}
}
