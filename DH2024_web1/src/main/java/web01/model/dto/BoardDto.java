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
}
