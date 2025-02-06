package web01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 룸북 어노테이션을 이용하여 DTO 구성
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDto {
	private int bno ;
	private String btitle;
	private String bcontent;
	private int bview;
	private String bdate;
	private int mno;
	private int cno;
	
	// + HTML 에 출력 시 작성자의 회원번호가 아닌 아이디를 출력하기 위한 멤버변수
	private String mid;
}
