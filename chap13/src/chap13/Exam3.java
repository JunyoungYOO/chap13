package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * 1~45사이의 중복되지 않는 숫자 6개를 정렬하여 출력하기
 */
public class Exam3 {

	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<>();
		while(set.size()<6) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set);
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
