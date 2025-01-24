package day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example2 {
	public static void main(String[] args) {
		// [1] List 타입 ArrayList 인스턴스 생성 
		// -> ArrayList 가 List 인터페이스의 추상메소드 구현체이기 때문에 List 타입 생성 가능
		List<String> list = new ArrayList<String>();
			// 변수 타입 : List<String> -> 인터페이스 타입
			// 변수 : list
			// 인스턴스 : new ArrayList<String>()	-> 클래스
		
		// [2] List 인터페이스의 메소드
		// 1) .add(자료) : 리스트 내에 지정한 자료를 마지막 요소에 추가
		list.add("유재석");
		list.add("강호동");
		list.add("신동엽");
		list.add("하하");
		list.add(2, "김희철");	// .set()과 다르게 해당 인덱스의 자료 변경이 아니라 추가
		
		System.out.println(list);	// [유재석, 강호동, 김희철, 신동엽, 하하]
		
		// 2) .set(인덱스, 자료) : 리스트 내 지정한 인덱스에 지정한 자료의 요소 변경
		list.set(2, "서장훈");
		 
		System.out.println(list);	// [유재석, 강호동, 서장훈, 신동엽, 하하]
		
		// 3) .get(인덱스) : 리스트 내 지정한 인덱스의 요소 값 반환
		System.out.println( list.get(3) );	// 서장훈
		String str1 = list.get(0);
		System.out.println( str1 );
		
		// 4) .size() : 리스트 내 요소 전체 개수 반환
		System.out.println(list.size());
		
		// 5) .contains(자료) : 리스트 내 지정한 자료 존재 여부 반환(boolean)
		System.out.println(list.contains("서장훈"));	// true
		boolean result1 = list.contains("박명수");
		System.out.println(result1);	// false
		
		// 6) .indexOf(자료) : 리스트 내 지정한 자료의 인덱스 반환 (없을 시 -1 반환)
		System.out.println(list.indexOf("서장훈"));	// 2
		int result2 = list.indexOf("박명수");
		System.out.println(result2);  // -1
		
		// 7) .remove(인덱스 / 자료) : 리스트 내 지정한 인덱스/자료 삭제
		list.remove(0);
		System.out.println(list);	// [강호동, 서장훈, 신동엽, 하하]
		
		// 8) .clear() : 리스트 내 모든 요소 삭제
		
		// 9) .isEmpty() : 리스트 내 요소 존재 여부(boolean)
		System.out.println(list.isEmpty());  // false
		
		// 10) 리스트 내 요소 순회 방법	
			// 10-1) 일반 for 문 사용
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
			// 10-2) 향상된 for 문 : for(타입 반복변수명 : 리스트명) { }
		for(String str : list) {
			System.out.print(str);
		}
			// 10-3) .forEach() -> 람다식 : JS : () => { } / JAVA : () -> { }
		list.forEach((str) -> {System.out.print(str);});
		
		// [3] List 인터페이스 클래스(구현체) *** 클래스들의 사용법(메소드)은 동일함 ***
		ArrayList<String> list1 = new ArrayList<String>();
		Vector<String> list2 = new Vector<String>();		 // 멀티스레드에서 주로 사용
		LinkedList<String> list3 = new LinkedList<String>(); // 중간 삽입 , 삭제 시 주로 사용
		
		// 여러 클래스들의 인스턴스를 다루기 위해서는 주로 인터페이스 타입 사용 -> 다형성을 위해
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new Vector<String>();
		List<String> list6 = new LinkedList<String>();
		
		
	}
}










