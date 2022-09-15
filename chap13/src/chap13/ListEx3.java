package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
 * Shape 추상 클래스 구현하기
 *   추상메서드 : double area()
 *             double length()
 *   Comparable 인터페이스 구현
 *    기본정렬방식 : 넓이의 오름차순으로 설정                 
 * 
 * Circle 클래스 구현.  Shape 클래스 상속
 *   멤버변수 : r
 *   생성자 : 멤버변수 초기화
 *   추상메서드구현하기  
 *   
 * Rectangle 클래스 구현.  Shape 클래스 상속
 *   멤버변수 : w,h
 *   생성자 : 멤버변수 초기화
 *   추상메서드구현하기  
*/
abstract class Shape implements Comparable<Shape> {
	abstract double area();
	abstract double length();
	
	public int compareTo(Shape s) {
		return (int)(area() - s.area());
	}
}
class Circle extends Shape {
	int r;
	Circle(int r) {
		this.r = r;
	}
	@Override
	double area() {
		return r*r*Math.PI;
	}
	@Override
	double length() {
		return 2*r*Math.PI;
	}
	public String toString() {
		return "반지름:"+r + ",면적:"+area() + ",둘레:"+length();
	}
}
class Rectangle extends Shape {
	int w,h;
	Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	double area() {
		return w*h;
	}
	@Override
	double length() {
		return 2*(w+h);
	}
	public String toString() {
		return "("+w +","+h+ "),면적:"+area() + ",둘레:"+length();
	}
}
public class ListEx3 {
	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		list.add(new Circle(5));
		list.add(new Circle(1));
		list.add(new Circle(10));
		list.add(new Rectangle(6,10));
		list.add(new Rectangle(1,2));
		for(Shape s: list) System.out.println(s);
		Collections.sort(list);
		System.out.println("기본 정렬 후:");
		for(Shape s: list) System.out.println(s);
		System.out.println("면적의 역순으로 정렬 :");
		Collections.sort(list,Comparator.reverseOrder());
		for(Shape s: list) System.out.println(s);
		System.out.println("둘레 순으로 정렬 :");
/* jdk8 이전 방식		
		Collections.sort(list,new Comparator<Shape> () {
			@Override
			public int compare(Shape s1, Shape s2) {
				return (int)(s1.length() - s2.length());
			}
		});
*/
		//jdk8 부터 가능 방식
		Collections.sort
		   (list,(s1,s2)->(int)(s1.length() - s2.length()));
		for(Shape s: list) System.out.println(s);
		System.out.println("둘레 역순으로 정렬 :");
		Collections.sort
		(list,(s1,s2)->
(int)(Math.round(s1.length()) - Math.round(s2.length())) * -1);
		for(Shape s: list) System.out.println(s);
	}
}
