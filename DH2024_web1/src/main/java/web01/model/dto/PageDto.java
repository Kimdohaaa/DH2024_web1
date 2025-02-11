package web01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDto { // 페이징 처리된 데이터들의 이동 객체 (자바 내부적으로 사용하는 DTO)
	private int page;		// 현재 페이지 저장 변수
	private int totalpage; 	// 전체 페이지 개수 저장 변수
	private int startbtn; 	// 버튼의 시작번호 저장 변수
	private int endbtn; 	// 버튼의 끝 번호 저장 변수
	private Object data; 	// 페이징된 자료 저장 변수
	private int totalcount; // 전체 자료의 개수 (모든 타입의 자료를 저장할 수 있도록 Object 타입 사용)
}
