package day_03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet{
	
	// [1] doGet
	//			HTTP GET URL : http://local:8080/DH2024_web1/day03/exmaple4
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		
		// 쿼리스트링 방식 //
		// 1) 응답할 데이터
		boolean result = true;	
		// 2) 응답하기 : true 응답
		resp.getWriter().print(result);	// .getWriter().print(보낼 데이터);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
	
	// [2] doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 쿼리스트링 방식 //
		// 1) 응답할 데이터
		String result = "JAVA";
		// 2) 응답하기 : "JAVA" 응답
		resp.getWriter().print(result); // .getWriter().print(보낼 데이터); 
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
	
	// [3] doPut
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		
		// 쿼리스트링 방식 //
		// 1) 응답할 데이터
		int result = 30;
		// 2) 응답하기 : 30 응답
		resp.getWriter().print(result);	
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
	
	// [4] doDelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> DELETE METHOD");
		
		// 쿼리스트링 방식 //
		// 1) 응답할 데이터
		DataDto result = new DataDto("유재석", 40);
		// 2) 응답하기 : DataDto [data1=유재석, data2=40]
		resp.getWriter().print(result);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
		// ★ 주의점 : JS 는 DTO 타입을 쓰지 않기 때문에 DTO 타입으로 응답불가 -> JSON 을 이용한 형변환 필요 ★ //
	}
	
	
}
