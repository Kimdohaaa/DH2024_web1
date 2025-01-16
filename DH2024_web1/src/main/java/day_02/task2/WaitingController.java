package day_02.task2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day02/waiting")
public class WaitingController  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 1] POST 메소드 요청");
		
		String tel = req.getParameter("tel");
		int count = Integer.parseInt(req.getParameter("count"));
		
		boolean result = WaitingDao.getInstance().add(tel, count);	
		System.out.println(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 2] DELETE 메소드 요청");
		
		int num = Integer.parseInt(req.getParameter("num"));
		
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println(result);
	}
}
