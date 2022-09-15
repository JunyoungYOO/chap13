package chap13;

import java.util.HashSet;
import java.util.Set;
//Person 객체의 내용이 같으면 중복으로 인정되도록 프로그램 수정
/*
 * Set 객체에서 중복 판단 관련 메서드
 *   boolean equals()  : 결과가 true
 *   int   hashCode()  : 결과의 값이 같다 
 *   => 두개 모두 만족하는 객체는 중복 판단함.
 */
class Person {
	String name;
	int age;
	Person(String name, int age) {
		this.name = name;
		this.age =age;
	}
	public String toString() {
		return "(" + name+"," + age+")";
	}
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return name.equals(p.name) && age == p.age;
		}
		return false;
	}
}
public class SetEx2 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		set.add(new String("abc"));
		set.add(new String("abc")); //추가 실패
		set.add(new Person("홍길동",10));
		set.add(new Person("홍길동",10));
		System.out.println(set);
		System.out.println(set.size()); //2. set 객체의 요소의 갯수
	}
}
