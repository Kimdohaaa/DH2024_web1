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
import web01.model.dto.PageDto;

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
	
	// [2] 게시물 카테고리 별 전체 조회 (+ 페이징 처리)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BOARD GET");
		
		// JS 에서 쿼리스트링으로 보낸 cno 가져오기 / 형변환
		int cno = Integer.parseInt(req.getParameter("cno"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		// * 페이징 처리에 필요한 자료 
			// 1. 한 페이지 당 출력할 게시물 개수 (매개변수로 사용자가 선택한 값 받기 or 지정하기)
			int display = 5;	// 5 개로 지정
			// 2. 페이지 당 조회할 게시물의 시작 번호
			int startRow = (page-1) * display;
			// 예시] 게시물 10 개 존재 : 0 ~ 9 번 게시물 존재
			//		=> 1 페이지 : 0 ~ 4 번 게시물 출력 
			// 		=> 2 페이지 : 5 ~ 9 번 게시물 출력
			// 3. 게시물의 전체 페이지 개수
			int totalSize = BoardDao.getInstance().TotalSize(cno);
			// 4. 전체  페이지 개수 계산 (총 페이지 개수 : 전체 게시물 수 / 페이지 당 게시물 수 => 나머지 존재 시 + 1)
			int totalPage = 0;
			if(totalSize % display == 0) { // 나머지가 없다면
				totalPage = totalPage / display;
			}else {	// 나머지가 있다면
				totalPage = totalPage /display +1;	// 몫 + 1
			}
			// 5. 페이지 당 버튼 개수
			int btnSize = 5;
			// 6. 시작 버튼 번호 구하기 ((page - 1)/ 페이지 당 버튼 수) * 페이지 당 버튼 수 + 1
			int startBtn = ((page - 1) / btnSize) * btnSize + 1;
			// 7. 끝 버튼 번호 구하기 (시작버튼 + (페이지 당 버튼 수  - 1))
			int endBtn = startBtn + (btnSize - 1);
			// * 끝 번호가 전체 페이지 수 보다 커지면 안되므로 끝번호가 전체 페이지 수 보다 커질 경우 끝 번호를 전체 페이지 수로 지정
			if(endBtn > totalPage) {
				endBtn = totalPage;
			}
			
		// [1] 전체 출력이기 때문에 배열 변수를 생성하여 DAO 에서 결과 받기 
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno, startRow, display);
		
		
			// 8. 페이징 DTO 인스턴스 생성
			PageDto pageDto = new PageDto();
			pageDto.setTotalcount(totalSize);	// 조회된 전체 게시물 수
			pageDto.setPage(page);				// 현재 페이지
			pageDto.setTotalpage(totalPage);	// 전체 페이지 수
			pageDto.setStartbtn(startBtn);		// 페이징 버튼 시작 번호
			pageDto.setEndbtn(endBtn);			// 페이징 버튼 끝 번호
			pageDto.setData(result);			// 페이징 처리된 데이터 (어떤 데이터가 들어올지 알 수 없기 때문에 DTO 생성 시 Object 타입으로 생성함)
			
		// [2] DAO 에서 반환받은 결과 JSON 타입으로 형변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(pageDto);	// 페이징 처리 결과를 담은 PageDto 반환
		
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
