package day_05;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day_05.BoardDto;

public class BoardDao {
	private Connection conn;
	// 싱글톤
	private BoardDao() {
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
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	// [1] 게시물 등록
	public boolean create(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle,bcontent,bwriter,bpwd) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getbTitle());
			ps.setString(2, boardDto.getbContent());
			ps.setString(3, boardDto.getbWriter());
			ps.setString(4, boardDto.getbPwd());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [2] 게시물 전체 조회
	public ArrayList<BoardDto> findAll() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setbTitle(rs.getString("btitle"));
				boardDto.setbContent(rs.getString("bcontent"));
				boardDto.setbWriter(rs.getString("bwriter"));
				boardDto.setbDate(rs.getString("bdate"));
				boardDto.setbView(rs.getInt("bview"));
				
				list.add(boardDto);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	// [3] 게시물 상세 조회
	public BoardDto find(int bno) {
		
		try {
			String sql = "select * from board where bno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setbTitle(rs.getString("btitle"));
				boardDto.setbContent(rs.getString("bcontent"));
				boardDto.setbWriter(rs.getString("bwriter"));
				boardDto.setbDate(rs.getString("bdate"));
				boardDto.setbView(rs.getInt("bview"));
				
				return boardDto;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// [4] 게시물 수정
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle = ?, bcontent = ? where bno = ? and bpwd = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getbTitle());
			ps.setString(2, boardDto.getbContent());
			ps.setInt(3, boardDto.getBno());
			ps.setString(4, boardDto.getbPwd());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [5] 게시물 삭제
	public boolean delete(BoardDto boardDto) {
		try {
			String sql = "delete from board where bno = ? and bpwd= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, boardDto.getBno());
			ps.setString(2, boardDto.getbPwd());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
}
