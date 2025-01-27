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
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bPwd;
	private int bView;
	private String bDate;
}
