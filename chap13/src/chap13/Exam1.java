package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 화면에서 홀수개의 정수를 입력받아 입력받은 숫자의 평균과 중간값 출력하기
 * 999 숫자 입력된경우 입력 종료
 * 평균 : 총합/갯수
 * 중간값 : 숫자를 정렬하여 일렬 배치. 가운데 값
 * 정렬 : Collections.sort(List) 
 * 10 40 30 60 30
 * 평균 : (10+40+30+60+30)/5
 * 중간값 : 10 30 30 40 60 => 30
 * [결과]
 * 홀수개의 숫자를 입력하세요(종료:999)
 * 10 40 30 60 30 
 * 총합 : 000
 * 평균 : 000.0
 * 중간값 : 30
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println("홀수개의 숫자를 입력하세요(종료:999)");
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		List<Integer> list = new ArrayList<>();
		while(true) {
			int num = scan.nextInt();
			if(num == 999) break;
			list.add(num);
			sum += num;
		}
		if(list.size() % 2 == 0) {
			System.out.println("한개 숫자를 더 입력하세요");
			int num = scan.nextInt();
			list.add(num);
			sum += num;
		}
		Collections.sort(list);
		System.out.println("평균값:" + sum/list.size());
		System.out.println("중간값:" + list.get(list.size()/2));
	}
}
