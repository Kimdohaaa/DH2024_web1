package web01.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web01.model.dao.MemberDao;
import web01.model.dto.MemberDto;

@WebServlet("/member/singup")
public class SignUpController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> SINGUP POST");
		
		// [1] HTTP 요청의 HEADER BODY 자료(JSON) 를 자바(DTO)로 받기 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(">> memberDto Check : " + memberDto); // 확인

		// [2] 유효성 검사
		// [3] DAO 에게 전달 / 응답 받기
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		// [4] HTTP 로 response(응답) 할 객체(DTO) 타입을 JS(JSON) 타입으로 변환
		resp.setContentType("application/json");
		
		// [5] HTTP HEADER BODY 로 response
		resp.getWriter().print(result);
	}
}
