package day_02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example2")	// 매핑
public class Example2 extends HttpServlet{

	// [1] GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 1] 사용자가 서버로부터 GET 메소드를 요청");
		
		// 쿼리스트링의 매개변수를 가져오기
			// [1] .getParameter("URL 경로상의 매개변수명"); : 매개변수명의 값을 String 타입으로 반환  / 값이 없다면 null 반환
		System.out.println(" [1-1] URL ? 뒤에 있는 'name' 라는 매개변수의 값 가져오기");
		System.out.println(req.getParameter("name"));
		System.out.println(" [1-2] URL ? 뒤에 있는 'age' 라는 매개변수의 값 가져오기");
		System.out.println(req.getParameter("age"));
		
	}
	
	// [2] POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 2] 사용자가 서버로부터 POST 메소드를 요청");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s", name , age);
		
	}
	
	// [3] PUT
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 3] 사용자가 서버로부터 PUT 메소드를 요청");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s", name , age);

	}
	
	// [4] DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 4] 사용자가 서버로부터 DELETE 메소드를 요청");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.printf("name : %s , age : %s", name , age);
		
	}
}
