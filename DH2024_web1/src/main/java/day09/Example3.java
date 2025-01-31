package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example3")
public class Example3 extends HttpServlet{
	
	// 여러 개의 map 객체를 저장할 list 선언 -> DTO 대용
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
	// 파일 경로 
	private String filePath = "c:/java";
	
	// [1] 파일 쓰기(doPost)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST (FILE)");
		
		// 1) HTTP 요청 BODY 자료를 HashMap 타입을 매핑
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map =  mapper.readValue(req.getReader(), HashMap.class);
		
		// 2) 입력받은 map 을 list 객체에 저장
		list.add(map);
		
		// 3) 지정한 파일 경로의 File 객체 생성
		File file = new File(filePath);
		
		// 4) 만약 지정한 경로가 존재하지 않을 시 폴더 생성	
		if(!file.exists()) {
			file.mkdir();
		}
		
		// 5) 출력(쓰기) 스트림 객체 생성
		FileOutputStream out = new FileOutputStream(filePath + "/text3.txt");
			
		// 6) 출력할 자료(list)를 JSON 형식의 문자열 타입을 변환 
		String outStr = mapper.writeValueAsString(list);
			
		// 7) 출력할 내용물을 byte[] 로 변환
		byte[] bytes = outStr.getBytes();
			
		// 8) 출력
		out.write(bytes);
		
		// doPost 메소드에 throw 로 이미 예외던지기가 되어있기 때문에 예외처리를 따로 하지 않아도 됨
		
		// 확인
		resp.setContentType("text/plain");
		resp.getWriter().print("파일저장성공");
		
	}
	
	// [2] 파일 읽기(doGet)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET (FILE)");
		
		// 1) 지정한 파일 경로의 File 객체 생성
		File file = new File(filePath +"/text3.txt");
		
		// 2) 지정한 경로가 존재 여부 확인 
		if(file.exists()) {
			// 파일이 존재하지 않을 시
			System.out.println(">> 파일이 존재하지 않습니다.");
			
			// 응답
			resp.setContentType("text/plain");
			resp.getWriter().print(">> 파일이 존재하지 않습니다.");
			
		}else {
			// 파일이 존재할 시
			
			// 3) ObjectMapper 객체 생성
			ObjectMapper mapper = new ObjectMapper();
			// 4) ObjectMapper 클래스를 통해 파일의 자료을 ArrayList 타입으로 변환
			ArrayList<HashMap<String, String>> list = mapper.readValue(file, ArrayList.class);
			// 5) 읽어온 파일의 자료를 JSON 문자열로 변환
			String jsonResult = mapper.writeValueAsString(list);
			
			// 6) 응답
			resp.setContentType("application/json");
			resp.getWriter().print(jsonResult);
		}
	
	}
	
}
