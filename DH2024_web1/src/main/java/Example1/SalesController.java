package Example1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example1/sales")
public class SalesController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> SALES GET ");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<HashMap<String, String>> result = TotalDao.getInstance().findS();
		
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("appliation/json");
		resp.getWriter().print(jsonResult);
	}
}
