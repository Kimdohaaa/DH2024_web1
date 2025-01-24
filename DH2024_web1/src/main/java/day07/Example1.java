package day07;

import java.util.ArrayList;

public class Example1{
	public static void main(String[] args) {
	
		// [1] Box1 의 인스턴스 생성
		Box1 box1 = new Box1();
		// [2] 생성한 인스턴스의 멤버변수에 값 대입
		box1.content = "안녕하세요.";
		// [3] 인스턴스 내 멤버변수의 값 호출 , 반환
		String content1 = box1.content;
		
		// [1] Box2 의 인스턴스 생성
		Box2 box2 = new Box2();
		// [2] 생성한 인스턴스의 멤버변수에 값 대입
		box2.content = 100;
		// [3] 인스턴스 내 멤버변수의 값 호출 , 반환
		int content2 = box2.content;
		
		System.out.println(content1);
		System.out.println(content2);
		
		// 특정 인스턴스의 하나의 멤버변수가 여러 타입 가질 수 있는 방법
		// [1] 다형성: 다양한 타입으로 변환이 가능한 성질
		Box3 box3 = new Box3(); // Object 가 최상위 클래스이기 때문에 여러 타입 대입 가능
		box3.content = "안녕하세요.";	// 업캐스팅(자동타입변환) -> Box3 의 content 멤버변수가 Object 타입이기 때문에
		String content3 = (String)box3.content;	// 다운캐스팅(강제형변환) -> 부모클래스에서 자식클래스로의 형변환
		box3.content = 100;	// Object 가 최상위 클래스이기 때문에 여러 타입 대입 가능
		int content4 = (Integer)box3.content;
		
		System.out.println(content3);
		System.out.println(content4);
		
		// [2] 제네릭 타입 : 클래스 내 멤버변수의 타입이 일정하지 않을 때 인스턴스 생성 시 타입 지정 
		Box4<String> box4 = new Box4<String>();
		box4.content = "안녕하세요.";
		String content5 = box4.content;
		Box4<Integer> box5 = new Box4<>();
		box5.content = 100;
		int content6 = box5.content;
		
		System.out.println(content5);
		System.out.println(content6);
		
		// 2-1) 제네릭의 대표적인 사용처
		ArrayList<String> sList = new ArrayList<String>();	// String 타입 여러개를 저장하는 ArrayList
		ArrayList<Dto> dtoList = new ArrayList<Dto>();	// Dto 타입 여러개를 저장하는 ArrayLilst
			// * 1 개 조회 -> DTO
			// * 여러 개 조회 -> ArrayList<>
	
		// 2-2) 여러개의 제네릭 타입 사용
		Point<String,Integer> point1 = new Point();
		point1.value1 = "안녕하세요.";
		point1.value2 = 100;
		
		Point<Double, Dto> point2 = new Point();
		point2.value1 = 100.0;
		point2.value2 = new Dto();
	}
}

class Box1{String content;	}
class Box2{int content;}
class Box3{Object content;}
class Dto{}

// 제네릭타입 클래스 선언 : 클래스명 <제네릭 타입>{ }
class Box4<T>{T content;}
class Point<T,V>{
	T value1;
	V value2;
}