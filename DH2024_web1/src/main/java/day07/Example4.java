package day07;

import java.util.HashMap;
import java.util.Map;

public class Example4 {
	public static void main(String[] args) {
		// [1] Map 타입으로 HashMap 인스턴스 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// [2] Map 인터페이스의 주요 메소드
		// 1) .put(key, value) : Map 내 key 와 value 를 entry(한쌍)으로 저장
		map.put("유재석", 85);
		map.put("홍길동", 90);
		map.put("강호동", 100);
		map.put("신동엽", 100);
		map.put("유재석", 100);	// key 가 중복이기 때문에 추가가 아닌 "유재석" key 의 값이 100 으로 변경됨 

		System.out.println(map); // {홍길동=90, 유재석=100, 강호동=100, 신동엽=100}

		// 2) .get(key) : Map 내 지정한 key 의 value 값 반환
		System.out.println( map.get("유재석")); // 100
		int value1 = map.get("신동엽");
		System.out.println(value1); // 100
		
		// 3) .size() : Map 내 전체 entry 개수 반환
		System.out.println(map.size()); // 4
	
		// 4) .remove(key) : Map 내 지정한 key 의 entry 삭제
		map.remove("신동엽");
		System.out.println(map); // {홍길동=90, 유재석=100, 강호동=100}
		
		// 5) .containsKey(key) : Map 내 지정한 Key 의 존재 여부 반환
		// 6) .containsKey(value) : Map 내 지정한 value 의 존재 여부 반환
		
		// 7) .entrySet() : Map 내 모든 entry 반환
		System.out.println(map.entrySet()); // [홍길동=90, 유재석=100, 강호동=100
		// 8) 
		System.out.println(map.keySet()); // [홍길동, 유재석, 강호동]
		// 9) .values() : Map 내 모든 value 반환
		System.out.println(map.values()); // [90, 100, 100]
		
		// 10) 순회
			// 10-1) 향상된 for 문
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
			// 10-2) .forEach()
		map.keySet().forEach((key) -> {System.out.println(map.get(key));});
	}
	
}
