package web01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//룸북 어노테이션을 이용하여 DTO 구성
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PointDto {
	private int pno;
	private String pname;
	private int pcount;
	private int mno;
	private String pdate;
}
