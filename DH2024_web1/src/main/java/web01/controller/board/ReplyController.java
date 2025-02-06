package web01.controller.board;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web01.model.dao.BoardDao;
import web01.model.dto.ReplyDto;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet {
	
	// [1] 댓글 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("REPLY POST");
		
		// [1] REQUEST 데이터 형변환
		ObjectMapper mapper = new ObjectMapper();
		ReplyDto replyDto = mapper.readValue(req.getReader(), ReplyDto.class);
		
		// [2] 세션에 저장된 로그인된 회원번호 가져오기
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginMno");
		
		// [3] 로그인 상태라면 형변환 후 DTO 에 SET
		if(obj != null) {
			int loginMno = (Integer)obj;
			replyDto.setMno(loginMno);
		}
		
		// [4] DAO 에게 전달 후 리턴 받기
		boolean result = BoardDao.getInstance().reply(replyDto);
		
		// [5] RESPONSE
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// [2] 게시물 별 댓글 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("REPLY GET");
		
		
	}
}
