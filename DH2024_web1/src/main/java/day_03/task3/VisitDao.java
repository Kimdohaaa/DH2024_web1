package day_03.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day_03.task3.VisitDao;
import day_03.task3.VisitDto;

public class VisitDao {
	private Connection conn;
	// 싱글톤
	private VisitDao() {
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
	private static VisitDao instance = new VisitDao();
	public static VisitDao getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	// [1] 방문록 등록 SQL 처리
	public boolean write(VisitDto visitDto) {
		try {
			String sql = "insert into visit(content,age) value (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getContent());
			ps.setInt(2, visitDto.getAge());
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [2] 방문록 출력 SQL 처리
	public ArrayList<VisitDto> findAll() {
		ArrayList<VisitDto> list = new ArrayList<VisitDto>();
		try {
			String sql = "select * from visit";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				VisitDto visitDto = new VisitDto();
				visitDto.setNum(rs.getInt("num"));
				visitDto.setContent(rs.getString("content"));
				visitDto.setAge(rs.getInt("age"));
				
				list.add(visitDto);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	// [3] 방문록 수정 SQL 처리
	public boolean update(VisitDto visitDto) {
		try {
			String sql = "update visit set content = ? , age = ? where  num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, visitDto.getContent());
			ps.setInt(2, visitDto.getAge());
			ps.setInt(3, visitDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	// [4] 방문록 삭제 SQL 처리
	public boolean delete(int num) {
		try {
			String sql = "delete from visit where num =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
}
