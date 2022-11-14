package java_Ch07_Generic_Collection;
import java.util.*;

public class CollectionEx {

	static void printList(LinkedList<String> l) {	// 링크드리스트 객체 l을 매개변수로 갖는 printList 메소드
		
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			
			if (iterator.hasNext())
				separator = "->";
			else
				separator = "\n";
			
			System.out.print(e + separator);
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0, "터미네이터");
		myList.add(2, "아바타");
		
		printList(myList);			// 요소 출력
		
		Collections.sort(myList); 	// 요소 정렬	// static 메소드이므로 클래스 이름으로 바로 호출
		printList(myList);			// 요소 출력
		
		Collections.reverse(myList);	// 요소 순서 리버스
		printList(myList);
		
		int index = Collections.binarySearch(myList, "아바타");
		System.out.println("아바타는 " +index+ "번째 요소입니다.");

	}

}
