package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		
		// [1] *실행 중인* 자바 자료를 윈도우 파일에 출력(쓰기)
			// FileOutputStream 클래스 : FileOutputStream 변수명 = new FileOutputStream("파일경로");
		try {
			// 1) FileOutputStream 객체 생성 ★ 예외처리 필수 ★
			FileOutputStream out = new FileOutputStream("c:/java/test1.txt");
			
			// 2) 출력할 데이터 
			String str = "Hello JAVA";
			
			// 3) 윈도우는 바이트 단위를 사용하기 때문에 String 타입의 데이터를 byte 타입으로 형변환하여 배열에 대입
				// .getBytes() : String -변환-> byte[] 하는 메소드
			byte[] outStr = str.getBytes();
			
			// 4) 출력스트림 객체 내 출력함수로 바이트열 내보내기 ★ 예외처리 필수 ★
				// .write(출력할 바이트) : 지정한 경로의 File 에 출력됨
			out.write(outStr);
		
		// FileOutputStream 클래스에 객체 생성에 대한 예외처리
		}catch (FileNotFoundException e) {
			System.out.println(e);
		// .write() 에 대한 예외처리 
		}catch (IOException e) {
			System.out.println(e);
		}
		
		
		// [2] 키보드로부터 입력받은 자료를 윈도우 파일에 출력
		try {
			// 1) FileOutputStream 객체 생성 ★ 예외처리 필수 ★
			FileOutputStream out = new FileOutputStream("c:/java/test2.txt");
			
			// 2) 출력할 데이터를 Scanner 객체를 통해 입력받기
			Scanner scan = new Scanner(System.in);
			System.out.print(">> 메모장에 작성할 내용 입력 : ");
			String str = scan.nextLine();
			
			// 3) 파일 출력을 위해 byte 로 형변환
			byte[] outStr = str.getBytes();
			
			// 4) 파일에 출력 
			out.write(outStr);
			
		// IOException 예외에 FileNotFoundException 이 포함되어 있음
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
