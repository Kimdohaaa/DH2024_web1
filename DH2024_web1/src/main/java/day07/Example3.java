package day07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Example3 {
	public static void main(String[] args) {
		// [1] Set 타입의 HashSet 인스턴스 생성
		Set<String> set = new HashSet<String>();
		
		// [2] Set 인터페이스의 주요 메소드
		// 1) .add() : Set 내 지정한 자료 추가
		set.add("유재석");
		set.add("강호동");
		set.add("신동엽");
		
		System.out.println(set);	// [유재석, 강호동, 신동엽]
			
		// 2) .size() : Set 내 전체 요소 개수 반환
		System.out.println(set.size());	// 3
		
		// 3) .remove(자료) : Set 내 지정한 자료 존재 시 삭제
		set.remove("강호동");
		
		System.out.println(set);	// [유재석, 신동엽]
		
		// 4) .contains(자료) : Set 내 지정한 자료가 존재하는 지 여부 반환(boolean)
		set.contains("유재석");	// true
		
		// 5) Set 순회
		Iterator<String> rs = set.iterator();
			// iterate : 반복하다 , iterator : 반복자
		while(rs.hasNext()) {
			System.out.println(rs.next());
		}
			// 5-1) 향상된 for 문	-> iterator 기반으로 만들어진 문법
		for(String str : set) {
			System.out.println(str);
		}
		
			// 5-2) .forEach() -> iterator 기반으로 만들어진 문법
		set.forEach((str) -> {System.out.println(str);});
		
		// [1] Set 타입의 TreeSet 인스턴스 생성
		Set<String> set2 = new TreeSet<String>();

		// .add() 시 오름차순으로 자동 정렬 -> 사용 시 인스턴스 타입을 Set 타입으로 지정해야 함
		set2.add("유재석");
		set2.add("강호동");
		set2.add("신동엽");
		
		System.out.println(set2); // [강호동, 신동엽, 유재석]
		
		// .descendingIterator() : 내림차순 정렬 -> 사용 시 인스턴스 타입을 Set 이 아닌 TreeSet 타입으로 지정해야 함
		TreeSet<String> set3 = new TreeSet<String>();
		
		set3.add("유재석");
		set3.add("강호동");
		set3.add("신동엽");
		
		System.out.println(set3.descendingIterator()); 
	}
	
}
