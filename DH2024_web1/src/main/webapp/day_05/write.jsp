<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	<div>
		<h3> 게시물 작성 : 작성 후 등록 버튼을 클릭하세요! </h3>
		
		제목 : <input class="titleIn"/> <br/>
		내용 : <input class="contentIn"/> <br/>
		작성자 : <input class="writerIn"/> <br/>
		비밀번호 : <input class="pwdIn"/> <br/>
		
		<button onclick="boardC()"> 등록 </button>
	</div>
	
	<jsp:include page="footer.jsp"/>
	
	<script src="board.js"></script>
</body>
</html>