package web01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// LOMBOK 라이브러리 어노테이션으로 생성자 / getter / setter / ToString 자동 생성 
@NoArgsConstructor	
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDto {
	// 멤버 변수
	private int mno;		// 회원번호
	private String mid;		// 아이디 
	private String mpwd;	// 비밀번호
	private String mname;	// 이름
	private String mphone;	// 연락처 
	private String mdate;	// 가입일 
	private String mimg; 	// 프로필 사진
	private int mpoint;
	
}		