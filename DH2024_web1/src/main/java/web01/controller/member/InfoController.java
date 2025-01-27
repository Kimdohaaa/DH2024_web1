package web01.controller.member;

import java.io.IOException;

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
		
		// [2] 만약 세션 객체에 지정한 속성값이 존재하면 int 타입으로 다운캐스팅
		if(object != null) {
			// 1) 다운캐스팅
			int loginMno = (Integer)object;
			// 2) DAO 에게 현재 로그인된 회원 번혼 전달(세션 객체에 있음) / 응답 받기
			result = MemberDao.getInstance().myInfo(loginMno);	
		}
		
		// [3] HTTP HEADER BODY 에게 JSON 타입으로 반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
