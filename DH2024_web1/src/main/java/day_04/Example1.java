package day_04;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day04/example1")
public class Example1 extends HttpServlet{

	// [1] 쿼리스트링 예시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		
		// 1) 매개변수 가져오기
		String value1 = req.getParameter("value1");
		int value2 = Integer.parseInt(req.getParameter("value2"));
		
		// 2) 확인
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		
		// 3) HTTP HEADER BODY 에 응답
		boolean result = true;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// [2] HTTP HEADER BODY 방식
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 1) 요청 : HTTP HEADER BODY 의 JSON 타입 -변환-> DTO 객체
		ObjectMapper mapper = new ObjectMapper();
		ValueDto valueDto = mapper.readValue(req.getReader(), ValueDto.class);
		
		// 2) 응답 : HTTP HEADER BODY 에게 DTO 객체 -변환-> JSON 타입 응답 
		ValueDto result = new ValueDto("강호동", 23);
		
		String jsonResult = mapper.writeValueAsString(result); // JSON 타입으로 변환

		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);	// JSON 타입으로 변환한 값이 대입된 변수를 응답
	}
}
