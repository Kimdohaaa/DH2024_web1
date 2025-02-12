<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div>
	
		<div class="msgbox">
		
		</div>
	
		<textarea class="msginput"></textarea>	

		<button type="button" class="btn btn-primary" onclick="onMsgSend()"> 전송 </button>
	
	</div>

	<script src="/DH2024_web1/web01/js/chatting/chatting.js"></script>
</body>
</html>