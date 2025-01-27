package web01.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web01.model.dao.MemberDao;
import web01.model.dto.MemberDto;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	// [1] 로그인(POST)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> LOGIN MEMBER POST");
		
		// [1] HTTP HEADER BODY 자료(JSON) 을 자바(DTO) 로 받기
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		
		// [2] 유효성 검사
		// [3] DAO 에게 데이터 전달 / 응답 받기
		int loginMno = MemberDao.getInstance().login(memberDto);
		
		// [4] ★ 로그인 성공 시 세션 처리 ★
		if(loginMno > 0) {
			// 세션 : 톰캣 서버의 저장소 / 메모리
			// 1) HttpSession 객체 생성(이미 톰캣 서버에 생성(브라우저 요청 시 생성됨)되어 있는 세션 객체 불러오기)
			HttpSession session = req.getSession();
			// 2) 현재 로그인 성공한 회원번호를 세션 속성에 등록 -> 톰캣 서버의 데이터 저장
			session.setAttribute("loginMno", loginMno);
			// 3) 세션 객체의 활성화 유지 시간 지정
			session.setMaxInactiveInterval(60*10); 	// 세션 객체의 활성화 시간을 10 분으로 지정
		}
		
		// [5] HTTP HEADER BODY 에게 객체(DTO)를 JS(JSON) 타입으로 반환
		resp.setContentType("application/json");
		resp.getWriter().print(loginMno);
		
	}
	
	// [2] 로그아웃(DELETE)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> LOGOUT MEMBER DELETE");
		
		// [1] 세션 객체 생성(이미 톰캣 서버에 생성(브라우저 요청 시 생성됨)되어 있는 세션 객체 불러오기)
		HttpSession session = req.getSession();
		
		// [2] 세션의 속성값 불러오기
		Object object = session.getAttribute("loginMno");
		
		// [3] 로그아웃 상태를 저장하는 boolean 타입 변수 생성
		boolean logOut = false;
		
		// [4] 세션에 속성값 존재 시 속성값 제거
		if(object != null) {	// 만약 세션의 속성값이 존재한다면
			session.removeAttribute("loginMno");	// 세션의 속성값 지우기
			logOut = true;	// 로그아웃 상태 변수를 true 로 변경
		}
		
		// [5] 로그아웃의 결과를 HTTP HEADER BODY 에게 객체(DTO)타입을 JS(JSON) 타입으로 변환한 후 반환
		resp.setContentType("application/json");
		resp.getWriter().print(logOut);	
	}
}
