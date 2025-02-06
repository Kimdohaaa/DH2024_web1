package web01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReplyDto {
	private int rno;
	private String rcontent;
	private String rdate;
	private int mno;
	private int bno;
	private String mid;
}
