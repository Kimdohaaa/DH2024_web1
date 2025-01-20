package day_03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import day_03.task2.WaitingDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 1] POST 메소드 요청");
		
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto dto = mapper.readValue(req.getReader(), WaitingDto.class);
		System.out.println(dto);
		boolean result = WaitingDao.getInstance().add(dto);
	
	}
		
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 2] DELETE 메소드 요청");
		try {
			int num = Integer.parseInt(req.getParameter("num"));
			boolean result = WaitingDao.getInstance().delete(num);
			System.out.println(result);

		}catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
