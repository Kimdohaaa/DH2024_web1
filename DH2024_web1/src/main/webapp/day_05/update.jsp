<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/day_05/header.jsp"/>	
	
	<div>
		<h3> 게시물 개별 수정 : 새로운 내용 입력 후 수정 버튼을 클릭하세요!</h3>
		제목 : <input class="titleUp"/> <br/>
		내용 : <input class="contentUp"/> <br/>
		비밀번호 : <input class="pwdUp"/> <br/>
 
		<a onclick="boardU()"> 수정 </a>
	</div>
	
	<jsp:include page="/day_05/footer.jsp"/>	
	
	<script src="view.js"></script>
</body>
</html>