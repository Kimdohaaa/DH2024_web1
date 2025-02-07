package web01.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web01.model.dao.BoardDao;
import web01.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{

	// [1] 게시물 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BOARD POST");
	
		// [1] 요청받은 JSON 타입 -변환-> DTO
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		// [2] 현재 세션에 로그인된 회원번호 가져오기
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		
		if(object != null) {
			// [3] 형변환
			int loginMno = (Integer)object;
			
			// [4] DTO 에 SET
			boardDto.setMno(loginMno);
		}	
		// [5] DAO 에 전달 후 결과 받기
		boolean result = BoardDao.getInstance().write(boardDto);
		
		// [6] 응답할 DTO 타입 -변환-> JSON
		resp.setContentType("application/json");
		
		// [7] 응답
		resp.getWriter().print(result);
	}
	
	// [2] 게시물 카테고리 별 전체 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BOARD GET");
		
		// JS 에서 쿼리스트링으로 보낸 cno 가져오기 / 형변환
		int cno = Integer.parseInt(req.getParameter("cno"));
		
		// [1] 전체 출력이기 때문에 배열 변수를 생성하여 DAO 에서 결과 받기
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno);
		
		// [2] DAO 에서 반환받은 결과 JSON 타입으로 형변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		
		// [3] RESPONSE
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// [3] 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BOARD PUT");
		
		// [1] REQUEST 받은 JSON 타입 데이터 DTO 로 형변환
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
	
		// [2] DAO 에 전달 후 결과 반환 받기
		boolean result = BoardDao.getInstance().update(boardDto);
		
		// [3] RESPONSE 
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	// [4] 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BOARD DELETE");
		
		// [1] 쿼리스트링으로 받은 값 INT 타입으로 형변환
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		// [2] DAO 에 전달 후 결과 반환 받기
		boolean result = BoardDao.getInstance().delete(bno);
		
		// [3] RESPONSE
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
}
