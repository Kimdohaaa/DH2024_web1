package day_05;

import java.io.IOException;


import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardController extends HttpServlet {
	
	// [1] 게시물 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> POST METHOD");
		
		// 1) 요청
		ObjectMapper mapper = new ObjectMapper();
		
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);	
		// 2) 응답 
		boolean result = BoardDao.getInstance().create(boardDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// [2] 게시물 전체 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// [3] 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PUT METHOD");
		
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		boolean result = BoardDao.getInstance().update(boardDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);		
	}
	
	// [4] 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> DELETEMETHOD");
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		boolean result = BoardDao.getInstance().delete(boardDto);
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}
