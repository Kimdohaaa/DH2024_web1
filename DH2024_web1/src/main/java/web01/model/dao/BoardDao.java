package web01.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web01.model.dto.BoardDto;
import web01.model.dto.ReplyDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BoardDao extends Dao{
	
	// 싱글톤 s 
	@Getter	// 지정한 멤버변수에 어노테이션으로 getter 지정
			// 롬복 라이브러리 어노테이션을 사용해 싱글톤 간소화
	private static BoardDao instance = new BoardDao();

	// 싱글톤 e

	
	// [1] 게시물 등록
	public boolean write(BoardDto boardDto) {
		try {
			// [1] SQL 문 작성
			String sql = "insert into board (btitle, bcontent, mno, cno) values (?,?,?,?)";
			
			// [2] DB 로 전송
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			
			// [3] 결과 받기
			int count = ps.executeUpdate();
			
			// [4] insert 가 됐으면 true 리턴
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [2] 게시물 카테고리 별 전체 출력
	public ArrayList<BoardDto> findAll(int cno) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select b.* , m.mid"
					+ "	from board b join member m on b.mno = m.mno where b.cno = ? order by bno asc";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setMid(rs.getString("mid"));
				
				list.add(boardDto);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	// [3] 게시물 수정
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle= ? ,bcontent = ? where bno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);;
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [4] 게시물 삭제
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// [5] 댓글 등록
	public boolean reply( ReplyDto replyDto) {
		try {
			String sql = "insert into reply (rcontent, mno , bno) values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, replyDto.getRcontent());
			ps.setInt(2, replyDto.getMno());
			ps.setInt(3, replyDto.getBno());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	// [6] 게시물 개별 조회
	public BoardDto findByBno(int bno) {
		try {
			String sql = "select b.* ,m.mid , c.cname from board b join member m on b.mno = m.mno"
					+ "	join category c on b.cno = c.cno where b.bno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMid(rs.getString("mid"));
				boardDto.setCname(rs.getString("cname"));
				
				return boardDto;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// [7] 게시물 별 댓글 출력
	public ArrayList<ReplyDto> findReply(int bno) {
		ArrayList<ReplyDto> rList = new ArrayList<ReplyDto>();
		try {
			String sql = "select m.mid , r.* from reply r join board b on b.bno = r.bno join member m on r.mno = m.mno where b.bno =?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ReplyDto replyDto = new ReplyDto();
				
				replyDto.setRno(rs.getInt("rno"));
				replyDto.setRcontent(rs.getString("rcontent"));
				replyDto.setRdate(rs.getString("rdate"));
				replyDto.setMid(rs.getString("mid"));
				
				rList.add(replyDto);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return rList;
	}
}
