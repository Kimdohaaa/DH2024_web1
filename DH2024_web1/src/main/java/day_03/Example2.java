package day_03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example2")
public class Example2 extends HttpServlet{

	// queryString 방식이 아닌 HTTP body(본문) 활용
	//*** HTTP body(본문) 은 POST / PUT MEHTOD 에서 사용 지원 ***//
	
	// [1] doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		System.out.println(req.getReader());	// 요청 할 때 마다 객체가 바뀜(=> HTTP 는 무상태이다.)
		System.out.println(req.getReader().readLine()); 	// readLine() : HTTP 본문의 내용들을 한줄 읽어서 반환하는 메소드
	}
	
	// [2] doPut
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		System.out.println(req.getReader());
		System.out.println(req.getReader().readLine());
	}
	
}
