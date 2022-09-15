package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * List 예제
 * 
 * 프레임워크 : 기능 수행하기 위한 클래스와 인터페이스의 모임.
 * 
 * Collection 프레임워크 : 객체들의 집합 구현하기 위한 클래스와 인터페이스들의 모임
 *                      java.util 패키지에 속함
 *                      
 * Collection 인터페이스 : 객체들의 집합
 * 하위인터페이스
 *  1. List 인터페이스 : 객체를 저장한 순서를 유지. 중복가능.
 *                    인덱스(첨자) 사용가능. 0부터 시작
 *     구현클래스 : ArrayList, Vector, LinkedList
 *               Vector : Collect 프레임워크이전에 사용되던 클래스
 *                        이전의 메서드와 Collection 프레임워크의 메서드
 *                        모두 사용가능
 *  2. Set 인터페이스 : 객체를 저장한 순서 모름. 중복불가
 *     구현클래스 : HashSet, TreeSet
 *     
 * Map 인터페이스 : (Key,Value) 쌍인 객체들의 집합    
 *     구현클래스 : HashMap, TreeMap
 *               Hashtable <- Properties
 */
public class ListEx1 {
	public static void main(String[] args) {
		//<Integer> : 제네릭설정. 요소로 저장되는 객체의 자료형 설정
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(5);
		list.add(4);list.add(3);list.add(0);
//		list.add("a"); //Integer 객체가 아니므로 list 객체에 추가 불가
		System.out.println(list);
		//첨자를 사용하여 데이터 출력
		for(int i=0;i < list.size();i++) {
			System.out.println(i + ":" + list.get(i));
		}
		//개선된 for 구문으로 데이터 출력 
		for (Integer i : list) {
			System.out.println(i);
		}
		System.out.println("list2 : ");
		//jdk8 이후부터 같은자료형인 경우 자료형을 생략가능 
		//subList(1, 4) : list의 1번인덱스 부터 3번인덱스 까지의 부분리스트
		List<Integer> list2 = new ArrayList<>(list.subList(1, 4));
		for (Integer i : list2) {
			System.out.println(i);
		}
		//정렬하기
		//Collection 인터페이스
		//Collections 클래스 : Collection 객체의 기능을 수행할 수 있는 클래스
		//list 객체의 요소들을 정렬하기
		Collections.sort(list);
		System.out.println(list);
	}
}
