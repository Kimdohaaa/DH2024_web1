package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet{
	
	// 대기 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting POST");
		// 상태를 저장할 임시 변수
		boolean result = false;
		
		// 값 가져오기
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		
		// 세션 객체 -변환-> ArrayList<HashMap<String, String>>
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");

		// 입력값 대입   
		if (list == null) {
			list = new ArrayList<>();
			result = true;
		}
		
		list.add(map);

		session.setAttribute( "list", list );
		
		session.setAttribute("wno", map.get("wno"));

		// 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		System.out.println(list);
	}
	
	// 대기 전체 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Get");
		
		ArrayList<HashMap<String, String>> list = null;
		
		Object object =  req.getSession().getAttribute("list");
		
		if( object == null ) {
			list = new ArrayList<HashMap<String,String>>();
		}else {
			list = (ArrayList<HashMap<String,String>>)object;
		}

		ObjectMapper mapper = new ObjectMapper();
		
		// JSON 타입으로 변환
		String jsonResult = mapper.writeValueAsString(list);
		
		// 응답
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		System.out.println(jsonResult);	
	}
	
	// 대기 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Delete");
		// 상태를 저장할 변수
		boolean result = false;
		
		// 쿼리스트링으로 값 받아오기
		String delete = req.getParameter("wno");
		
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		
		// 세션 객체 -변환-> ArrayList<HashMap<String, String>>
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");
		
		// 배열 순회를 통해 쿼리스트링으로 입력 받은 값 DELETE
		if (list != null && delete != null) {
	        Iterator<HashMap<String, String>> iterator = list.iterator();
	        while (iterator.hasNext()) {	// 모든 값 조회
	            HashMap<String, String> map = iterator.next();
	            if (map.get("wno").equals(delete)) {	// 만약 쿼리스트링으로 입력받은 값과 같으면 
	                iterator.remove();	// DELETE
	                result = true;		// 상태를 저장하는 변수 true 로 변경
	                break; 				// 반복 종료
	            }
	        }
	    }
		
		// 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Put");
		// 상태를 저장할 변수
		boolean result = false;
		// 요청받기
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		String wno = map.get("wno");
		
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
				
		// 세션 객체 -변환-> ArrayList<HashMap<String, String>>
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");
		
		// 배열 순회
	    if (list != null) {
	        for (HashMap<String, String> index : list) {
	            if (index.get("wno").equals(wno)) {	// 입력받은 값과 같으면
	                index.put("wcount", map.get("wcount"));	// 값 변경
	                session.setAttribute("list", list);		// 세션 값 변경
	                result = true;							// 상태를 저장하는 변수 true 로 변경
	                break;									// 반복 종료
	            }
	        }
	    }
	    
	    
	    // 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
}
