package java_Ch05_Inheritance_Ex;

abstract class PairMap {		// 연습문제 10
	
	protected String keyArray[];			// key 배열
	protected String valueArray[];			// value 배열
	
	abstract String get(String key);			// key값으로 value 검색
	abstract void put(String key, String value);// key와 value 쌍으로 저장
	abstract String delete(String key);			// key값 아이템 삭제, value 리턴
	abstract int length();						// 현재 저장된 아이템의 개수 리턴
}
