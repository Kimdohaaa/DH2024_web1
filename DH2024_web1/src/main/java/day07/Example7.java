package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET METHOD");
		
		// [1] 톰캣 내에 있는 세션 객체 호출 및 생성(첫 HTTP 생성)
		HttpSession httpSession = req.getSession();
		
		System.out.println(httpSession); // HTTP 를 요청한 클라이언트 브라우저의 세션 객체 주소
										 // org.apache.catalina.session.StandardSessionFacade@6bf3907f(주소 변경 X)
										 // 다른 브라우저 사용 시 주소가 변경됨 -> 컴퓨터 / 브라우저 마다 서로 다른 메모리 공간 생성 가능
		
		// [2] 세션 객체의 주요 메소드
		// 1) .getAttributeNames() : 세션 객체 내 모든 속성을 Collections 객체로 반환
		System.out.println(httpSession.getAttributeNames()); 
			// 첫번째 요청 : org.apache.catalina.session.StandardSessionFacade@7647c286
			// 두번째 요청 : org.apache.catalina.session.StandardSessionFacade@7647c286
		// 2) .getCreationTime() : 세션 객체가 만들어진 시간 반환 -> 시/분/초로 환산 필요
		System.out.println(httpSession.getCreationTime()); 
			// 첫번째 요청 : 1737705709563
			// 두번째 요청 : 1737705709563
		
		// 3) .getId() : 주소값이 아닌 세션 객체의 식별자 반환
		System.out.println(httpSession.getId()); 
			// 첫번재 요청 : 482DDCD0052B16D438F06DC40DE34A7A
			// 두번재 요청 : 482DDCD0052B16D438F06DC40DE34A7A
		
		// 4) .getLastAccessedTime() : 마지막 세션 객체 사용 시간
		System.out.println(httpSession.getLastAccessedTime()); 
			// 첫번째 요청 : 1737705709568
			// 두번째 요청 : 1737705710635
		
		// 5) .isNew() : 새로 만들어진 세션인지 여부 반환(boolean)
		System.out.println(httpSession.isNew()); 
			// 첫번째 요청 : true
			// 두번째 요청 : false
		
		// [3] 세션 객체의 속성명 / 속성값 저장
			// .setAttribute(key, value) : 세션 객체의 key(속성명) / value (속성값) 를 entry(한쌍)으로 저장
		httpSession.setAttribute("세션속성1", "유재석");
		
		// [4] 세션 객체의 지정한 속성명의 값 호출
			// .getAttribute(key0 : 세션 객체의 지정한 속성명의 값 호출
		Object obj = httpSession.getAttribute("세션속성1");
		System.out.println((String)obj); // 유재석
		
		// [5] 세션 객체의 지정한 속성명 제거
			// .removeAttribute(key) : 세션 객체의 지정한 속성명 제거
		httpSession.removeAttribute("세션속성1");
	
	}
}
