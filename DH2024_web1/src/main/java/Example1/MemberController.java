package Example1;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example1/member")
public class MemberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> MEMBER POST");
		
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		
		int memberCheck = memberCheck(memberDto);
		
		System.out.println(memberDto.getMgrade());
		
		resp.setContentType("application/json");
		
		if(memberCheck == 0) {
			if(memberDto.getMgrade().equals("A")) {
				memberDto.setMgrade("VIP");
			}else if (memberDto.getMgrade().equals("B")) {
				memberDto.setMgrade("일반");
			}else if (memberDto.getMgrade().equals("C")) {
				memberDto.setMgrade("직원");
			}
			System.out.println(memberDto.getMgrade());
			
			boolean result = TotalDao.getInstance().addM(memberDto);
			
			if(result) {
				resp.getWriter().print(memberCheck);
			}
		}
		if(memberCheck == 1) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 2) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 3) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 4) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 5) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 6) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 7) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 8) {
			resp.getWriter().print(memberCheck);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> MEMBER GET");	
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<MemberDto> result = TotalDao.getInstance().findAll();
		
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> MEMBER PUT");
		
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		
		int memberCheck = memberCheck(memberDto);
		System.out.println(memberDto);
		resp.setContentType("application/json");
		if(memberCheck == 0) {
			if(memberDto.getMgrade().equals("A")) {
				memberDto.setMgrade("VIP");
			}else if (memberDto.getMgrade().equals("B")) {
				memberDto.setMgrade("일반");
			}else if (memberDto.getMgrade().equals("C")) {
				memberDto.setMgrade("직원");
			}
			System.out.println(memberDto.getMgrade());
			
			boolean result = TotalDao.getInstance().addM(memberDto);
			
			if(result) {
				resp.getWriter().print(memberCheck);
			}
		}
		if(memberCheck == 1) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 2) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 3) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 4) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 5) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 6) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 7) {
			resp.getWriter().print(memberCheck);
		}
		if (memberCheck == 8) {
			resp.getWriter().print(memberCheck);
		}

	}
	
	public int memberCheck(MemberDto memberDto) {
		
		if(memberDto.getMname().equals("")) {
			return 1;
		}
		
		String[] phone = memberDto.getMphone().split("-");
		if(phone.length != 3 && memberDto.getMphone().length() != 13) {
			return 2;
		}

		if(memberDto.getMaddr().equals("")) {
			return 3;
		}
		
		String[] date = memberDto.getMdate().split("-");
		if(date.length != 3) {
			return 4;
		}
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);

		if(month < 1 || month > 12) {
			return 5;
		}
		if(day < 1 || day > 31) {
			return 6;
		}
		if(!memberDto.getMgrade().equals("A") && !memberDto.getMgrade().equals("B") && !memberDto.getMgrade().equals("C")) {
			return 7;
		}
		if(memberDto.getMcity().equals("")) {
			return 8;
		}
		
	
		return 0;
	}
}












