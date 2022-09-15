package chap13;
/*
 * 1. 대한민국=서울,캐나다=오타와,영국=런던을 HashMap에 저장하고,
 *    화면에서 나라이름을 입력받아 해당 나라의 수도를 출력하는 프로그램 구현하기
 * 2. 나라이름 입력시 종료문자가 입력될때까지 계속 입력받기
 * 3. 등록된 나라가 아니면 등록된 나라아님 출력하기
 * 4. 등록된 나라가 아니면 수도 입력 받음
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		String[] country = {"대한민국", "캐나다", "영국"};
		String[] city = {"서울", "오타와", "런던"};
		Map<String, String> map = new HashMap<>();
		for(int i=0;i<country.length;i++) {
			map.put(country[i], city[i]);
		}
		System.out.println(map);
		
		Scanner scan = new Scanner(System.in);
		String s="";
		String c="";
		while(true) {
			System.out.print("나라 이름 입력 (종료:종료)");
			s= scan.next();
			if(s.equals("종료")) {
				System.out.println("끝");break;
			}
			if(map.get(s)==null) {
				System.out.println("=>등록된 나라 아님");
				System.out.println("수도를 입력하세요.");
				c=scan.next();
				map.put(s, c);
				
			} else System.out.println(s+"의 수도: "+ map.get(s));
			
		}
		
		
		System.out.println(map);
		
		
	}

}
