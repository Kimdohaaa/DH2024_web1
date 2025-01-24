package parking0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingDao {
	private Connection conn;
	private static ParkingDao instance = new ParkingDao();
	private ParkingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0123",
					"root", "1234" );
		}catch( Exception e ) {System.out.println(e);}
	}
	public static ParkingDao getInstance() {return instance;}
	
	// 입차
	public boolean inCar(ParkingDto parkingDto) {
		try {
			String sql = "insert into parking (cnum, clot, state) values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parkingDto.getCnum());
			ps.setInt(2, parkingDto.getClot());
			ps.setBoolean(3, true);
			
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println("inCar" + e);
		}
		
		return false;
	}
}
