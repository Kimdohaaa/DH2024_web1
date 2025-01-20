package day_03;

import java.io.IOException;
import java.sql.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet{
	// JSON 자료의 문자열 타입을 DTO 로 변환 (JS 는 JSON 을 사용하고 JAVA 는 DTO 를 사용하기 때문)
	// 라이브러리 다운받을 때 : https://mvnrepository.com //
	
	// [1] doPost
	// 		HTTP POST BODY : http://localhost:8080/day03/example3
	// 	    content - type : application/json
	//		body: {"data1" : "유재석", "data2" : "40"}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		// System.out.println(req.getReader().readLine().charAt(0)); // 단순한 문자열을 읽어옴
		// 다운받은 라이브러리를 통해 DTO 로 변환하기
		
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper 인스턴스 생성
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);	// req.getReader() 객체 -변환-> DTO 객체
			// .readValue(JSON 데이터 자료 , 변환할 객체 타입.class);
		System.out.println(dataDto);	// DTO 출력 : DataDto [data1=유재석, data2=40]
	}
	
	// [2] doPut
	// 		HTTP PUT BODY : http://localhost:8080/day03/example3
	//		content - type : application/json
	//		body: {"data1" : "유재석", "data2" : "40"}	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		// System.out.println(req.getReader().readLine());
		
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);	// req.getReader() -변환-> DTO 객체
		System.out.println(dataDto);	// DTO 출력 : DataDto [data1=유재석, data2=40]
	}
	
	//*** doGet , doDelete 는 body 를 사용하지 않기 때문에 쓰지 않음 ***//
}
