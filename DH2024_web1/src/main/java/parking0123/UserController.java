package parking0123;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day06/user")
public class UserController extends HttpServlet{
	String[] parking = new String[20];
	
	// 입차
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> user POST");
		
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(), ParkingDto.class);
		int state = 0;
		resp.setContentType("application/json");
			
		
		for(int i = 0; i < parking.length; i++) {
			if(parking[i] != null && parking[i].equals(parkingDto.getCnum())) {
				state = 1;
				break;
			}
		}
		if(parking[parkingDto.getClot()-1] != null) {	
			state = 2;
		}
		if(state == 0 ) {

			parking[parkingDto.getClot()-1] = parkingDto.getCnum();
		
			boolean result = ParkingDao.getInstance().inCar(parkingDto);
		
			if(result) {
				state = 0 ;
			}else {
				state = 3;
			}
		}
		System.out.println(state);
		resp.getWriter().print(state);
	}
}
