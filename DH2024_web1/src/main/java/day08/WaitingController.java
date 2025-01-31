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
		
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");

		   
		if (list == null) {
			list = new ArrayList<>();
			result = true;
		}
		
		list.add(map);

		session.setAttribute( "list", list );
		
		session.setAttribute("wno", map.get("wno"));

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
		
		String jsonResult = mapper.writeValueAsString(list);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		System.out.println(jsonResult);	
	}
	
	// 대기 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Delete");
	
		boolean result = false;
		
		String delete = req.getParameter("wno");
		
		HttpSession session = req.getSession();
		
		
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");
		
		if (list != null && delete != null) {
	        Iterator<HashMap<String, String>> iterator = list.iterator();
	        while (iterator.hasNext()) {
	            HashMap<String, String> map = iterator.next();
	            if (map.get("wno").equals(delete)) {
	                iterator.remove();
	                result = true;
	                break; 
	            }
	        }
	    }
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Put");
		
		boolean result = false;
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		String wno = map.get("wno");
		
		HttpSession session = req.getSession();
				
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)session.getAttribute("list");
		
		
	    if (list != null) {
	        for (HashMap<String, String> index : list) {
	            if (index.get("wno").equals(wno)) {
	                index.put("wcount", map.get("wcount"));
	                session.setAttribute("list", list);
	                result = true;
	                break;
	            }
	        }
	    }

		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
}
