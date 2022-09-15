package chap13;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/*
 * 반복자 : Iterator 예제
 * Iterator 인터페이스
 *   1. Collection 객체를 순서대로 조회 할 수 있는 기능
 *   2. 메서드
 *   	- boolean hasNext() : 다음 조회 대상 객체가 존재하는가
 *   	- Object next() : 객체를 리턴
 *   	- void remove() : next()에 의해 조회된 객체 제거
 *   Enumeration 인터페이스 => Iterator 이전의 반복자
 *   	1. Vector(List), HashTable(Map)	이전 클래스에서만 사용 가능한 반복자
 *   	2. 메서드
 *   		- boolean hasMoreElement() : 조회 대상 객체 존재?
 *   		- Object nextElement() : 객체 리턴
 */
public class IteratorEx1 {

	public static void main(String[] args) {
		Iterator it = null;
		List list = new ArrayList();
		Set set = new HashSet();
		Vector v = new Vector();
		for(int i=1;i<=5;i++) {
			list.add(i+10); set.add(i*10);
			v.add(i*20);
		}
		System.out.println(list);
		System.out.println(set);
		it = list.iterator();
		print(it);
		System.out.println("list"+list);
		it=set.iterator();
		print(it);
		System.out.println("set"+set);
		//Vection 클래스는 Colletion 이전의 클래스
		Enumeration e = v.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

	private static void print(Iterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println();
	}

}
