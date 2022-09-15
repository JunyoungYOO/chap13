package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Collections  클래스
 * sort 메서드 : 정렬기능
 *             요소의 자료형이 Comparable 인터페이스 객체여야함.
 *             => 요소객체가 Comparable 인터페이스 구현 클래스 객체여야함
 *             => Data 클래스가 Comparable 인터페이스를 구현해야함.
 * Comparable 인터페이스 : compareTo() 추상메서드를 가짐     
 */

/*
 *  정렬관련 인터페이스
 *  1. Comparable : 클래스가 구현하여, 클래스의 객체의 기본 정렬방식 설정에 사용됨 
 *                  int compareTo(Object o) 추상메서드를 가짐
 *  2. Comparator : 기본정렬방식과 상관없이 실행 중 정렬방식을 설정시 사용됨.
 *                  Collections.sort(List, Comparator 객체)
 *                  int compare(Object o1, Object o2)                
 */
class Data implements Comparable<Data> {
	int value;
	Data(int value) {
		this.value = value;
	}
	public String toString() {
		return value+"";
	}
	@Override
	public int compareTo(Data d) {
		return (value - d.value) ;
	}
}
class Data2 {
	int value2;
	Data2(int value) {
		this.value2 = value;
	}
	public String toString() {
		return value2+"";
	}
}

public class ListEx2 {
	public static void main(String[] args) {
		List<String> list1= new ArrayList<>();
		list1.add("9");list1.add("8");list1.add("7");
		list1.add("6");list1.add("5");list1.add("0");
		System.out.println(list1);
		Collections.sort(list1);
		System.out.println(list1);
		List<Data> list2= new ArrayList<>();
		list2.add(new Data(10));
		list2.add(new Data(1));
		list2.add(new Data(5));
		list2.add(new Data(3));
		list2.add(new Data(0));
		list2.add(new Data(0));
		System.out.println(list2);		
		Collections.sort(list2); //기본 정렬방식대로 정렬
		System.out.println(list2);
		 //역순으로 정렬
		Collections.sort(list2,Comparator.reverseOrder());
		System.out.println(list2);
		
		List<Data2> list3= new ArrayList<>();
		list3.add(new Data2(10));
		list3.add(new Data2(1));
		list3.add(new Data2(5));
		list3.add(new Data2(3));
		list3.add(new Data2(0));
		list3.add(new Data2(0));
		System.out.println("list3:" + list3);		
//		Collections.sort(list3,(d1,d2)->d1.value2 - d2.value2);

		//Comparator 인터페이스 객체 : FunctionalInterface임
		//FunctionalInterface 인터페이스 : 추상메서드가 한개만 존재하는 인터페이스
		//                            : 람다방식이 가능 
		Collections.sort(list3,new Comparator<Data2>() {
			public int compare(Data2 d1, Data2 d2) {
				return d1.value2 - d2.value2; //양수 : 순서 d2->d1
				                              //음스 : 순서 d1->d2
			}
		});
		System.out.println(list3);
	}
}
