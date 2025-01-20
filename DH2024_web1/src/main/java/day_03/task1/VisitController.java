package day_03.task1;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit")
public class VisitController extends HttpServlet{
	// [1] doPost : 방문록 등록 -> 등록은 주로 BODY 사용
	// 			HTTP POST BODY : http:// localhost8080:/DH2024_web1/day03/visit
	// 			content - type : application/json
	//			body : {"content" : "안녕! 방문록", "age" : "40"}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 1) body 에 JSON 을 DTO 파싱(변환)하기 위한 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();	
		// 2) // req.getReader() -변환-> DTO 객체
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);	
		// 3) DTO 객체 출력 : VisitDto [content=안녕! 방문록, age=40]
		System.out.println(visitDto);	
		// 4) DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
		System.out.println(result);
	}
	
	// [2] doDelete : 방문록 삭제 -> 삭제는 주로 queryString 사용
	// 			HTTP DELETE queryString : http:// localhost8080:/DH2024_web1/day03/visit?bno=삭제할 번호
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> DELETE METHOD");
		
		// 1) queryString 의 매개변수 를 파싱하기 
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num : " + num);
		// 2) DAO 처리
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}
}
