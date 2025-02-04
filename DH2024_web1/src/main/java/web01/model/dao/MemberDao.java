package web01.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web01.model.dto.MemberDto;
import web01.model.dto.PointDto;

//@Getter // -> 클래스 내 모든 멤버변수에 어노테이션으로 getter 지정
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
				// 룸북 라이브러리를 통해 디폴트 생성자 코드 생성 , private 적용(디폴트 : 패키지)
public class MemberDao extends Dao{
	// 하위클래스 extends 상위클래스  
	// + 싱글톤 s 
	@Getter	// 지정한 멤버변수에 어노테이션으로 getter 지정
			// 롬복 라이브러리 어노테이션을 사용해 싱글톤 간소화
	private static MemberDao instance = new MemberDao();

	// 싱글톤 e
	// [1] 회원가입 SQL 처리 메소드 
	public boolean signup( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql = "insert member(mid,mpwd,mname,mphone,mimg) value (?,?,?,?,?)";
			
			// [2] DB와 연동된 곳에 SQL 기재한다. 		- 연동된 DB 에 SQL 기재하는 방법 : conn.prepareStatement( SQL )
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
			ps.setString(5, memberDto.getMimg());
			
			// [3] 기재된 SQL를 실행하고 결과를 받는다. . 	- 기재된 SQL 을 실행하는 방법 : ps.executeUpdate()
			int count = ps.executeUpdate();
			
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { 
				return true; 
			}
		}catch( SQLException e ) { System.out.println( e ); }
		
		return false;
		
	} // f end
	
	// [2] 로그인 SQL 처리 메소드
	public int login( MemberDto memberDto ) {
		// int : SQL로 조회된 회원번호를 반환하기 위해서
		try {
			// [1] SQL 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps =  conn.prepareStatement(sql);
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( rs.next() ) {
				int mno = rs.getInt("mno");
				return mno;
			}
		}catch( SQLException e ) { System.out.println( e ); }
		
		return 0;
	} // f end  "		
	
	// [3] 내정보 보기 SQL 처리 메소드 
    public MemberDto myInfo( int loginMno ) {
    	    try {
                    String sql ="select p.mno , m.mid, m.mname, m.mphone, m.mdate, m.mimg , p.pcount, p.pname"
                    		+ "	from member m join point p on m.mno = p.mno where p.mno = ? ";
                    // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); 
                    // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
                    ResultSet rs = ps.executeQuery(); 
                    MemberDto memberDto = new MemberDto();
                    
                    // [3] 기재된 SQL 실행하고 결과를 받는다.
                    if( rs.next() ) { 
                    		// [4] 결과에 따른 처리 및 반환를 한다.
                            memberDto.setMno(rs.getInt("mno"));
                            memberDto.setMid( rs.getString("mid") );
                            memberDto.setMname( rs.getString("mname" ) );
                            memberDto.setMphone( rs.getString("mphone") );
                            memberDto.setMdate( rs.getString("mdate") );
                            memberDto.setMimg(rs.getString("mimg"));
                    
                            return memberDto;
                    }
            }catch(SQLException e ) { System.out.println(e);}
            
            return null; // 조회된 회원정보가 없을때. null 반환한다
    } // f end
    
    // [4] 현재 로그인된 회원의 포인트 내역
    public ArrayList<PointDto> pointList( int loginMno ) {
    	ArrayList<PointDto> list = new ArrayList<PointDto>();
            try {
                    String sql ="select p.mno , m.mid, m.mname, m.mphone, m.mdate, m.mimg , p.pcount, p.pname"
                    		+ "	from point p join member m on m.mno = p.mno where p.mno = ? ";
                    // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); 
                    // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
                    ResultSet rs = ps.executeQuery(); 
                    // [3] 기재된 SQL 실행하고 결과를 받는다.
                    while( rs.next() ) { 
                    	PointDto pointDto =  new PointDto(); 
                        
                    	// [4] 결과에 따른 처리 및 반환를 한다.
                            pointDto.setPname(rs.getString("pname"));
                            pointDto.setPcount(rs.getInt("pcount"));
                            
                            System.out.println(pointDto.getPcount());
                            System.out.println(pointDto.getPname());
                            
                            list.add(pointDto);
                    }
            }catch(SQLException e ) { System.out.println(e);}
            
            return list; // 조회된 회원정보가 없을때. null 반환한다
    } // f end
    
    // [5] 회원탈퇴
    public boolean delete( int loginMno ) {
		try {
			String sql = "delete from member where mno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , loginMno );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end "					
	
    // [6] 회원수정  SQL 처리 메소드
	public boolean update( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql = "update member set mpwd = ? , mname = ? , mphone = ? where mno = ?";
			// [2] DB와 연동된 곳(conn)에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement( sql );
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMpwd() );
			ps.setString( 2 , memberDto.getMname() );
			ps.setString( 3 , memberDto.getMphone() );
			ps.setInt( 4 , memberDto.getMno() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { return true; } // 수정 성공 했을때.
		}catch (SQLException e) {		System.out.println( e ); }
		return false; // 수정 실패 했을때.
	} // f end							

	// 포인트 조회
	public void point(int mno) {
		try {
			String sql = "select * from point";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			boolean state = false;
			while(rs.next()) {
				int i = rs.getInt("mno");
				if(i == mno) {
					state = true;
					break;
				}
			}
			
			if(state == true) {
				pointUp(mno);
			}else if(state == false) {
				pointIn(mno);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	// [7] 회원가입 포인트 지급
	public boolean pointIn(int mno) {
		try {

			String sql = "insert into point (pname, pcount, mno) values ('회원가입','100', ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			
			
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	// [8] 로그인 포인트 지급
	public boolean pointUp(int mno) {
		try {
			String sql = "insert into point (pname, pcount, mno) values ('로그인','1', ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println();
		}
		return false;
	}
	
	// [9] 로그인된 회원의 정보 조회(아이디 / 전화번호 / 프로필 / 현재 총 포인트)
	public MemberDto totalP(int loginMno) {
		
		try {
			String sql = "select p.mno , m.mid, m.mname, m.mphone, m.mdate, m.mimg , sum( p.pcount ) total"
					+ "	from member as m join point as p on m.mno = p.mno where p.mno = ? group by  m.mno, m.mid, m.mname, m.mphone, m.mdate, m.mimg";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				MemberDto memberDto = new MemberDto();
				
				memberDto.setMphone( rs.getString("mphone") );
                memberDto.setMid(rs.getString("mid"));
                memberDto.setMimg(rs.getString("mimg"));
                memberDto.setTotal(rs.getInt("total"));
                
                return memberDto;
                
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}









