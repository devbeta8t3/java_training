package java_Ch05_Inheritance_Ex;

class Dictionary extends PairMap {

	private int item;
	private String prevValue;
	
	public Dictionary(int a) {
		keyArray = new String[a];
		valueArray = new String[a];
	}
	@Override
	public String get(String key) {			// key값으로 value 검색
		for (int i=0; i<keyArray.length; i++) {
			if (key==keyArray[i]) {
				return valueArray[i];
			}
		}
		return null;
	}
	@Override
	public void put(String key, String value) {	// key, value 저장 ********중복처리필요***to do
		
		for (int i=0; i<keyArray.length; i++) { // key 값 동일하면 덮어쓰기
			if (keyArray[0]==null) {
				keyArray[i] = key;
				valueArray[i] = value;
			}
			else if (keyArray[i]!=null && keyArray[i].equals(key)) {
				valueArray[i] = value;
				break;
			}
			else if (keyArray[i]==null) {	// key 값 동일하지 않으면 null인 가장빠른 주소에 key, value 입력
				keyArray[i] = key;
				valueArray[i] = value;
				break;
			}
		}
		
		
	}
	@Override
	public String delete(String key) { // key값으로 key, value 삭제 & value 리턴
		for (int i=0; i<keyArray.length; i++) {
			if (keyArray[i]==key) {
				keyArray[i] = null;
				prevValue = valueArray[i];
				valueArray[i] = null;
				return prevValue;
			}
		}
		return null;
	}
	@Override
	public int length() {
		for (int i=0; i<keyArray.length; i++) {
			if (!keyArray[i].equals(null))
				item++;
		}
		return item;
	}
}
