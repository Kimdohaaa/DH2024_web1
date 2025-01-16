package day_02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/visit")
// 기존 Controller 역할 + 매핑 역할 (서블릿을 이용한 매핑)
public class VisitController extends HttpServlet{

	// 쿼리스트링을 이용
	// [1] POST(C) : 방문록 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 1] 사용자가 HTTP 로 부터 POST 메소드 요청");
	
		// 1) URL 상의 쿼리스트링 매개변수를 가져온다.(등록할 데이터) -> 설계 : 내용 / 나이
		String content = req.getParameter("content"); 
		// int age = req.getParameter("age"); // 오류 : .getParameter 메소드는 String 타입만 가능하기 때문에 오류발생
		int age = Integer.parseInt(req.getParameter("age")); // .getParameter 메소드를 사용하기 위해 형변환
		
		// 2) 매개변수를 DAO 에게 전달하고 결과를 받는다.
		boolean result = VisitDao.getInstance().write(content, age);
		System.out.println(result);
	}
	// [2] GET(R) : 방문록 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 2] 사용자가 HTTP 로 부터 GET 메소드 요청");
	}
	// [3] PUT(U) : 방문록 수정
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 3] 사용자가 HTTP 로 부터 PUT 메소드 요청");
	}
	// [4] DELETE(D) : 방문록 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 4] 사용자가 HTTP 로 부터 DELETE 메소드 요청");
		
		// 1) URL 상의 쿼리트링 매개변수를 가져온다.(삭제할 PK 키)
		int num = Integer.parseInt(req.getParameter("num")); // .getParameter 메소드 사용을 위해 형변환
		
		// 2) 매개변수를 DAO 에게 전달하고 결과를 받는다.
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}
}
