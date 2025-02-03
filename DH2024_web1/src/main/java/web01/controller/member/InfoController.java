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

@WebServlet("/member/info")
public class InfoController extends HttpServlet{
	// [1] 내정보 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> INFO GET");
		
		// 정보를 저장할 인스턴스 생성 //
		MemberDto result = null;
		
		// [1] 세션
			// 1) 세션 객체 가져오기
		HttpSession session = req.getSession();
		
			// 2) 세션 객체 내 loginMno 속성값 가져오기
		Object object = session.getAttribute("loginMno");
		
		// [2] 만약 세션 객체에 지정한 속성값이 존재하면 int 타입으로 다운캐스팅 후 DAO 에게 전달
		if(object != null) {
			// 1) 다운캐스팅
			int loginMno = (Integer)object;
			// 2) DAO 에게 현재 로그인된 회원 번혼 전달(세션 객체에 있음) / 응답 받기
			result = MemberDao.getInstance().myInfo(loginMno);	
		}
		
		// [3] 자바(DTO) 타입 -변환-> JS(JSON) 타입
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		
		// [4] HTTP HEADER BODY 에게 JSON 타입으로 반환
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// [2] 회원 탈퇴
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> MEMBER DELETE");
		// 정보를 저장할 변수 생성 //
		boolean result = false;
		
		// [1] 세션 객체 가져오기 (현재 로그인된 회원번호)
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		
		// [3] 만약 세션 객체에 지정한 속성값이 존재 시 int 타입으로 다운캐스팅 후 DAO 에게 전달
		if(object != null) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().delete(loginMno);
			
			// [4] 만약 회원 탈퇴 성공 시 세션 값을 제거하여 자동 로그아웃			
			if(result == true) {
				session.removeAttribute("loginMno");
			}
		}
		
		// [5] HTTP HEADER BODY 에게 JSON 타입으로 결과 반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// [3] 회원 정보 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> MEMBER PUT");

		boolean result = false;
		
		// [1] HTTP HEADER BODY 자료(JSON) 자바(DTO) 타입으로 요청 받기
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		
		// [2] 유효성 검사
		
		// [3] 세션 객체 가져오기 (현재 로그인된 회원번호)
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		
		// [4] 만약 세션 객체에 지정한 속성값이 존재 시 int 타입으로 다운캐스팅 후 DAO 에게 전달
		if(object != null) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno); // 세션 객체에서 조회된 loginMno 를 DTO 에 set
			result = MemberDao.getInstance().update(memberDto);
		}

		// [5] HTTP HEADER BODY 에게 JSON 타입으로 결과 반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
}





