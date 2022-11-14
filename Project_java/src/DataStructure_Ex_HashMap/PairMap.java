package DataStructure_Ex_HashMap;

abstract class PairMap {

	protected String keyArray[];
	protected String valueArray[];
	abstract String get(String key);		// key 값으로 value 검색
	abstract void put(String key, String value);
	abstract String delete(String key);
	abstract int length();		// 현재 저장된 스택 개수 리턴
}
