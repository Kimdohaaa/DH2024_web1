package Example1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TotalDao {
	private Connection conn;
	// 싱글톤
	private TotalDao() {
		try {
			// DB 연도을 위해 mysql-con~~jar 파일을 src -> main -> web-inf -> lib 에 add build 하기
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0122" 
					,"root" , "1234"
					);
		}catch (Exception e) {
			System.out.println("DB 연동 실패" + e);
		}
	}
	private static TotalDao instance = new TotalDao();
	public static TotalDao getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	// [1] 회원등록
	public boolean addM(MemberDto memberDto) {
		try {
			String sql = "insert into member(mno, mname, mphone, maddr, mdate, mgrade, mcity) "
						+ "values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getMno());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setString(4, memberDto.getMaddr());
			ps.setString(5, memberDto.getMdate());
			ps.setString(6, memberDto.getMgrade());
			ps.setString(7, memberDto.getMcity());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(">> 회원 C" +  e);
		}
		
		return false;
	}
	// [2] 회원출력
	public ArrayList<MemberDto> findAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			String sql = "select * from member";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				
				memberDto.setMno(rs.getInt("mno"));
				memberDto.setMname(rs.getString("mname"));
				memberDto.setMphone(rs.getString("mphone"));
				memberDto.setMaddr(rs.getString("maddr"));
				memberDto.setMdate(rs.getString("mdate"));
				memberDto.setMgrade(rs.getString("mgrade"));
				memberDto.setMcity(rs.getString("mcity"));

				list.add(memberDto);
				
			}
		}catch (SQLException e) {
			System.out.println(">> 회원 R" + e);
		}
		
		return list;
	}
	// [3] 회원수정
	public boolean updateM(MemberDto memberDto) {
		try {
			String sql = "update member set mname = ? , mphone = ? , maddr = ?, mdate =?,"
						+ " mgrade = ? , mcity = ? where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMname());
			ps.setString(2, memberDto.getMphone());
			ps.setString(3, memberDto.getMaddr());
			ps.setString(4, memberDto.getMdate());
			ps.setString(5, memberDto.getMgrade());
			ps.setString(6, memberDto.getMcity());
			ps.setInt(7, memberDto.getMno());
			
			int count =  ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(">> 회원 U" + e);
		}
		
		return false;
	}
	
	
	// [4] 매출 조회
	public ArrayList<HashMap<String, String>> findS() {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		try {
			String sql = "select s.mno , m.mname , m.mgrade, SUM(s.sprice) total from sales s"
					+ "	join member m on s.mno = m.mno group by s.mno, m.mname, m.mgrade order by total desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				
				map.put("mno", rs.getInt("mno") + "");
				map.put("mname" , rs.getString("mname"));
				map.put("mgrade" , rs.getString("mgrade"));
				map.put("total", rs.getInt("total") + "");
				
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println(">> 매출 R" + e);
		}
		
		return list;
	}
	
}
