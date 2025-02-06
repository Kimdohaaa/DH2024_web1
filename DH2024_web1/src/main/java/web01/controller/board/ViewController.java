package web01.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web01.model.dao.BoardDao;
import web01.model.dto.BoardDto;
import web01.model.dto.ReplyDto;

@WebServlet("/board/view")
public class ViewController extends HttpServlet{
	
	// [1] 게시물 개별 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VIEW GET");

		// 쿼리스트링 값 받아오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		// 개별 게시물 조회
		BoardDto boardDto = BoardDao.getInstance().findByBno(bno);
		
		// 해당 게시물의 댓글 리스트 조회 후 BoardDto 멤버변수에 SET
		ArrayList<ReplyDto> replyDto = BoardDao.getInstance().findReply(bno);		
		boardDto.setReplyList(replyDto);
		
		// JSON 으로 response 하기 위해 형변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(boardDto);
		
		// response
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}
