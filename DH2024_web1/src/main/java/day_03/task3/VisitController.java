package day_03.task3;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet {
	/*
	설계
	[1] 방문록 등록 -> POST 
		- 매개변수 : BODY ({"content" : "안녕"  , "age" : 40})
		- 리턴갑 : application/json (true/false)
	[2] 방문록 출력 -> GET 
		- 매개변수 : X	
		- 리턴값 : application/json ({"num" : 3 , "content" : "수정안녕" , "age" : 30})
	[3] 방문록 수정 -> PUT 
	 	- 매개변수 : BODY ({"num" : 3 , "content" : "수정안녕" , "age" : 30})
	 	- 리턴값 : application/json (true/false)
	[4] 방문록 삭제 -> DELETE 
	 	- 매개변수 : 쿼리스트링 ?num=1
	 	- 리턴값 : application/json (true/false)
	*/
	
	//*** HTTP BODY 방식 ***//
	// [1] 방문록 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 1) HTTP 로부터 요청받은 HTTP HEADER BODY(본문) 가져오기
		ObjectMapper mapper = new ObjectMapper();	// 라이브러리를 사용하기 위한 인스턴스 생성
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);	// .getReader() -변환-> DTO 객체
		
		// 2) DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
		
		// 3) DAO 결과를 HTTP HEADER BODY 로 응답보내기
		resp.setContentType("application/json"); // 응답할 자료의 타입 명시
		resp.getWriter().print(result);	// 자료 응답하기
	}
	
	// [2] 방문록 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		
		// 1) DAO 처리
		ArrayList<VisitDto> result = VisitDao.getInstance().findAll();
		
		// 2) ★ 자바객체(DTO) -변환-> JSON 형식의 문자열 ★
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);

		// 3) DAO 결과를 HTTP HEADER BODY(본문)으로 응답 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// [3] 방문록 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		
		// 1) HTTP 로부터 요청받은 HTTP HEADER BODY(본문) 가져오기
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		
		// 2) DAO 처리
		boolean result = VisitDao.getInstance().update(visitDto);
		
		// 3) DAO 결과를 HTTP HEADER BODY 로 response
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	//*** 쿼리스트링 방식 ***//
	// [4] 방문록 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> DELETE METHOD");
		
		// 1) HTTP 로 부터 요청받은 HTTP queryString 의 매개변수 가져오기
		int num = Integer.parseInt(req.getParameter("num"));
		// 2) DAO 처리
		boolean result = VisitDao.getInstance().delete(num);
		// 3) 응답하기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
