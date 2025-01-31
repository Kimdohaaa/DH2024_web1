package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example2 {
	public static void main(String[] args) {
		// [1] 파일의 자료를 자바로 가져오기(입력)
		// FileInputStream in = new FileInputStream("파일경로")
		try {
			// 1) FileInputStream 객체 생성 ★ 예외처리 필수 ★ 
			FileInputStream in = new FileInputStream("c:/java/test1.txt");
			// 2) 불러온 자료를 담을 배열 선언(영문/특수문자 : 1바이트 / 한글 : 3바이트)
			byte[] bytes = new byte[10];
			// 3) 파일 내 자료를 바이트 배열로 읽어오기
			in.read(bytes);
			// 4) 바이트배열 -변환-> String -> Byte 배열 bytes 를 문자열로 변환
			String str = new String(bytes);
			
			// 5) 콘솔에서 확인
			System.out.println(str);
			
		// FileInputStream 에 대한 예외처리
		}catch (FileNotFoundException e) {
			System.out.println(e);
		// .read() 에 대한 예외처리
		}catch (IOException e) {
			System.out.println(e);
		}
		// [2] 파일 클래스
		// 1. File 클래스 : 지정한 경로의 파일을 자바 객체와 연결
		// 1) File 객체 생성
		File file = new File("c:/java/test1.txt");
		// 2) 파일 존재 여부 확인
			// .isFile() : 지정한 경로의 파일 존재 여부를 boolean 타입으로 반환
		System.out.println(file.isFile());
			// .getName() : 지정한 경로의 파일 명 반환
		System.out.println(file.getName());
			// .exists() : 지정한 경로의 파일 존재 여부를 boolean 타입으로 반환
		System.out.println(file.exists());
			// .length() : 지정한 경로의 파일 용량을 바이트로 반환
		System.out.println(file.length());
			// .delete() : 지정한 경로의 파일 삭제(자바에서)
		file.delete();
			// .getPath() : 지정한 경로의 파일의 경로 확인
		System.out.println(file.getPath());
		
		
		File file2 = new File("c:/java2");
		if(!file2.exists()) {	// 만약 file2 에 지정된 경로의 파일이 존재하지 않으면
			// .mkdir() : 지정한 경로의 파일 생성
			file2.mkdir();	// 지정한 경로의 폴더 생성
		}
	}
	
	
}
