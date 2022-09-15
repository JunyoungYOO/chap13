package chap13;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Set인터페이스 : Collection 인터페이스의 하위 인터페이스.
 *              중복 객체 저장 불가
 *   구현 클래스 :  HashSet : 중복 불가, 순서 모름
 *              TreeSet : 중복 불가, 정렬됨. 
 *              LinkedHashSet : 중복 불가, 순서 유지           
 */
public class SetEx1 {
	public static void main(String[] args) {
		Object[] arr = {"홍길동",1,"1","김삿갓","이몽룡","홍길동",
				"성춘향","향단이","홍길동","김삿갓"};
//		Set<Object> set1 = new HashSet<>();
//		Set<Object> set2 = new HashSet<>();
//		Set<Object> set3 = new HashSet<>();
		Set<Object> set1 = new LinkedHashSet<>();
		Set<Object> set2 = new LinkedHashSet<>();
		Set<Object> set3 = new LinkedHashSet<>();
		for(Object o : arr) {
			//boolean add(Object) : Set 요소 추가
			//                      true/false 값리턴
			//             결과 true  : Set 에 요소 추가 성공
			//             결과 false : Set 에 요소 추가 실패
			if(!set1.add(o)) { //set1 객체에 요소 추가 실패한 경우
				if(!set2.add(o)) {
					set3.add(o);
				}
			}
		}
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		//개선된 for 구문으로 요소 출력하기
//		set1.get(0); //get 멤버 메서드 없음. 인덱스로 객체 리턴 불가 
		for (Object o : set1)
			System.out.print(o + ",");
		System.out.println();
		for (Object o : set2)
			System.out.print(o + ",");
		System.out.println();
		for (Object o : set3)
			System.out.print(o + ",");
		System.out.println();
	}
}
