package day_03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet{

	// 쿼리스트링 방식 //
	// [1] doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		
		// 1) 응답할 데이터
		boolean result = true;
		// 2) HTTP 를 이용한 헤더 정보 추가 (Content-type)
			// .setContentType(데이터를 보낼 때 타입을 명시)
		resp.setContentType("application/json");
		// 3) HTTP 를 이용한 요청에 따른 응답 자료 보내기 : true
		resp.getWriter().print(result);
	}
	
	// [2] doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 1) 응답할 데이터
		String result = "JAVA";
		// 2) HTTP 를 이용한 헤더 정보 추가 
			// ★ 주의점 : 문자열 1개는 application/json 으로 타입변환 불가
			//        -> text/plain 사용
		resp.setContentType("text/plain"); 
		// 3) 응답받기
		resp.getWriter().print(result);
	}
	
	// [3] doPut
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		
		// 1) 응답할 데이터
		int result = 30;
		// 2) HTTP 를 이용한 헤더 정보 추가 
		resp.setContentType("application/json");
		// 3) 응답받기
		resp.getWriter().print(result);
	}

	// [4] doDelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> DELETE METHOD");
		
		// 1) 응답할 데이터
		DataDto result = new DataDto("유재석" , 30);
		// 2) *** DTO -변환-> JSON ***
		ObjectMapper mapper = new ObjectMapper();	// 라이브러리 사용을 위해 인스턴스 생성
		String jsonResult = mapper.writeValueAsString(result); 	// .writeValueAsString(변환할 객체) : 객체를 String 타입으로 변환
		// 3) HTTP 를 이용한 헤더 정보 추가 
		resp.setContentType("application/json");
		// 4) 응답받기
		resp.getWriter().print(jsonResult);
	
		//*** JS 는 DTO 를 사용하지 않기 때문에 JS 로 응답하기 전에 DTO 객체를 String 으로 변환해줌 ***//
	}
	
	// .setContentType() 메소드를 통해 데이터를 보낼 타입을 명시했기 때문에 BODY 에 응답값이 출력됨 //
}
