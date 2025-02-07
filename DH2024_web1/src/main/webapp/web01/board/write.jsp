<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- summer note 환경 설정 (CSS) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css" />

</head>
<body>
	<!-- header.jsp 연결 -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div class="container">
	
		<form>
			<select class="form-select cnoselect">	
				<!-- value 로 cno 값 지정 -->
				<option value="1">뉴스</option>
				<option value="2">이벤트</option>
				<option value="3">FAQ</option>
				<option value="4">튜토리얼</option>
				<option value="5">사용자리뷰</option>
			</select>
			<input type="text" class="form-control titleinput"/>
			<!-- summer note 사용을 위한 id 와 name -->
			<textarea id="summernote" name="editordata" rows="" cols="" class="form-control contentinput"></textarea>
			<button onclick="onWrite()" type="button" class="btn btn-primary">등록</button>
		</form>
	</div>
	
	<!-- summer note 환경 설정 (JQuery 라이브러리 JS)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- summer note 환경 설정 (JS)  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js"></script>
	<!-- summer note 한국어 사용을 위한 JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js" ></script>	


	<script src="/DH2024_web1/web01/js/board/write.js" type="text/javascript"></script>
	
	<!-- summer note 사용 주의점  -->
	<!-- 버전 호환 여부 -->
	<!-- JS 를 불러오는 순서 주의 (내가 만든 JS 를 가장 아래 입력) -->
	
	
	<!-- 
		sumer note 사용 시 등록한 이미지를 바이트 타입으로 변환하여 사진 자체를 DB 에 저장함 
		(DB 의 long 타입의 용량이 4기가 까지 저장되기 때문에 용량이 큰 첨부파일은 등록 불가) 
		=> 
	-->
	
</body>
</html>