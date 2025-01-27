package web01.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web01.model.dto.MemberDto;

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
	// 1. 회원가입 SQL 처리 메소드 
	public boolean signup( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql = "insert member(mid,mpwd,mname,mphone) value (?,?,?,?)";
			
			// [2] DB와 연동된 곳에 SQL 기재한다. 		- 연동된 DB 에 SQL 기재하는 방법 : conn.prepareStatement( SQL )
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
			
			// [3] 기재된 SQL를 실행하고 결과를 받는다. . 	- 기재된 SQL 을 실행하는 방법 : ps.executeUpdate()
			int count = ps.executeUpdate();
			
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
		
	} // f end 							
}