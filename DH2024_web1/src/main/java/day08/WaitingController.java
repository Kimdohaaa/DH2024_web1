package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet{
	
	// private ArrayList<HashMap<String, String>> list = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting POST");
		
		
		// 상태를 저장할 변수 선언 //
		boolean result = false;
		
		// [1] 요청
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		map.put("wno", "wno");
		map.put("wcount", "wcount");
		map.put("wphone", "wphone");
		
		ArrayList<HashMap<String, String>> list = null;
		list.add(map);
		// [] 세션 객체에서 값 가져오기
		Object object =  req.getSession().getAttribute("list");
		
		// [] 세션 객체가 null  이면
		if( object == null ) {
			
			list = new ArrayList<>();
		// [] 세션 객체가 !null 이면
		}else {
			// list 에 세션 객체의 속성값 대입
			list = (ArrayList<HashMap<String, String>>)object;
		}
		
		
		// System.out.println(map);
		// list.add(map);

		
		req.setAttribute( "list", list );

		resp.setContentType("application/json");
		resp.getWriter().print(result);
		//		
//	
//		HttpSession session = req.getSession();
//		session.setAttribute("wno", map.get("wno"));
//		session.setAttribute("wphone", map.get("wphone"));
//		session.setAttribute("wcount", map.get("wcount"));
//		
//		System.out.println(session.getAttribute("wno"));
//		System.out.println(session.getAttribute("wphone"));
//		System.out.println(session.getAttribute("wcount"));
//		
//		Object object = session.getAttribute("wno");
//		if(object != null) {
//			result = true;
//		}
//
//		resp.setContentType("application/json");
//		resp.getWriter().print(result);
	}
	
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
		
		
		//	
//		HashMap<String,String> map = new HashMap<String, String>();
//		
//		HttpSession session = req.getSession();
//		
//		map.put("wno", session.getAttribute("wno")+ "");
//		map.put("phone", session.getAttribute("wphone" )+ "");
//		map.put("wcount", session.getAttribute("wcount" )+ "");
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		String jsonResult = mapper.writeValueAsString(list);
//		
//		resp.setContentType("application/json");
//		resp.getWriter().print(jsonResult);
//		System.out.println(jsonResult);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Delete");
		
		String delete = req.getParameter("wno");
		
		boolean result = false;
		
		
		HttpSession session = req.getSession();
		
		
		if(delete.equals(session.removeAttribute("wno"))) {
			result = true;
		}
		/*
		for(int i = 0; i < list.size(); i++) {
			HashMap<String, String> index = list.get(i);
				
			if(index.get("wno").equals(delete)) {
				list.remove(i);
				result = true;
	
				session.removeAttribute("wno");
				session.removeAttribute("wphone");
				session.removeAttribute("wcount");
			}
		}
	
		*/
		resp.setContentType("application/json");
		resp.getWriter().print(result);
			}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> Waiting Put");
		
		boolean result = false;
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
	
		
		HttpSession session = req.getSession();
		
		for(int i = 0; i < list.size(); i++) {
			HashMap<String, String> index = list.get(i);
				
			if(index.get("wno").equals(map.get("wno"))) {
				map.put("wcount", map.get("wcount"));

				session.setAttribute("wcount", map.get("wcount"));

				result = true;
				break;
			}
		}
		
		if(result == true) {
			resp.setContentType("application/json");
			resp.getWriter().print(result);
		}
		
		System.out.println(list);
		
		
	}
}
