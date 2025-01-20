package day_03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day_03.task2.WaitingDto;

public class WaitingDao {
	private Connection conn;
	// 싱글톤
	private WaitingDao() {
		try {
			// DB 연도을 위해 mysql-con~~jar 파일을 src -> main -> web-inf -> lib 에 add build 하기
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0120"
					,"root" , "1234"
					);
		}catch (Exception e) {
			System.out.println("DB 연동 실패" + e);
		}
	}
	private static WaitingDao instance = new WaitingDao();
	public static WaitingDao getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	public boolean add(WaitingDto dto) {
		try {
			String sql = "insert into waiting(tel, count) values (?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setInt(2, dto.getCount());
		
			int i = ps.executeUpdate();
			
			if(i == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	public boolean delete(int num) {
		try {
			String sql = "delete from waiting where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
}

