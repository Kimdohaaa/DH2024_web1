package day_02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example1")
public class Example1 extends HttpServlet{ 
// 이클립스는 코드가 변경 / 수정 시 자동으로 빌드 됨
	// - 서블릿 안에 코드 변경 시 자동으로 리로드 됨 -> Crl + F11 하지 않아도됨
	// - 주의점 : 새로운 서블릿은 새로운 매핑HTTP 주소가 서버에 등록되어야 하기 때문에 수동 restart 해야 함
	
	
	
	// 자바 클래스를 서블릿 클래스로 만들기
	/*
	1) 현재 클래스가 HTTPServlet 을 상속받도록 해준다
	2) @WebServlet("HTTP 주소")
	3) HTTP 요청 받은 방법 정의
		- doPost()
		- doGet()
		- doPut()
		- doDelete()
	*/ 

	// RestFul 구축 : POST(C) / GET(R) / PUT(U) / DELETE(D)
	
	// [1] POST : doPost()
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP 프로토콜 통신이 POST 통신 방법으로 요청 왔습니다. 코드수수수수정");
	}
	// [1] GET : doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP 프로토콜 통신이 GET 방법으로 요청 왔습니다.");
	}
	// [3] PUT : doPut()
	@Override
	protected void doPut(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println(">> HTTP 프로토콜 통신이 PUT 방법으로 요청 왔습니다.");
	}
	// [4] DELETE : doDelete()
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP 프로토콜 통신이 DELETE 방법으로 요청 왔습니다. 코드수정");
	}
}
	
