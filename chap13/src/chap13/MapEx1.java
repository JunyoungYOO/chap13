package chap13;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map 인터페이스 : (key,value) 쌍으로 객체들을 저장하는 객체
 */
public class MapEx1 {

	public static void main(String[] args) {
		String[] names = {"홍길동", "김삿갓", "이몽룡", "임꺽정", "김삿갓"};
		int[] nums = {1234,4567,2350,9870,3456};
		Map<String,Integer> map = new HashMap<>();
		for(int i=0; i<names.length;i++) {
			map.put(names[i],nums[i]);
		}
		System.out.println(map);
		//value <= map.get(key)
		System.out.println("김삿갓의 전화번호 "+map.get("김삿갓"));
		System.out.println("홍길동의 전화번호 "+map.get("홍길동"));
		
		//map.keySet() : map 객체에서 key값들만 Set의 객체로 리턴
		System.out.println("keySet() 메서드로 전체 요소 조회");
		Set<String> keys = map.keySet();
		for(String k : names)
			System.out.println(k+":" +map.get(k));
		//map.values() : map 객체에서 value값들만 조회
		Collection<Integer> values = map.values();
		System.out.println("value() 메서드로 value값만 조회");
		System.out.println(values);
		for(Integer i : values) {
			System.out.println(i);
		}
		// map.entrySet() : map 객체에서 (key, value) 객체들 조회
		System.out.println("entrySet() 메서드로 모든 요소 조회");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for(Map.Entry<String, Integer> e: entry) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}
