package day_05;

import java.io.IOException;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/view")
public class ViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> GET METHOD");
		try {
			int bno = Integer.parseInt(req.getParameter("bno"));
			BoardDto result = BoardDao.getInstance().find(bno);
		
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(result);
			
			resp.setContentType("application/json");
			resp.getWriter().print(jsonResult);
			
		}catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		
	}
}
