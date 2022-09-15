package chap13;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet : 중복불가, 정렬됨.
 * Exam3.java 소스를 TreeSet으로 수정하기
 * 
 * Comparable 인터페이스: TreeSet의 요소는 구현클래스여야함
 * Comparator 인터페이스: 동적으로 정렬방식 설정 가능
 */
public class SetEx4 {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>
						((i1,i2)->i2.compareTo(i1));;
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		while(set.size()<6) {
			set.add(r.nextInt(45)+1);
		}
		System.out.println(set);

	}

}
