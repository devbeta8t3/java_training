package java_Ch07_Generic_Collection;

import java.util.*;

public class IteratorEx {

	public static void main(String[] args) {
		// 정수값만 다루는 제네릭 벡터 생성
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);	// 2번 인덱스에 100 삽입 (4와 -1 사이)
		
		// Iterator를 이용한 모든 정수 출력하기
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}
		
		// Iterator를 이용하여 모든 정수 더하기
		int sum = 0;
		it = v.iterator();
		while (it.hasNext()) {
			int n = it.next();
			sum = sum + n;
		}
		System.out.println("벡터에 있는 정수의 합 : " +sum);
	}

}
