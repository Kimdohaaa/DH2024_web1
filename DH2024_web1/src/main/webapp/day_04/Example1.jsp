<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> JSP 파일 </h3>
	<h3> JSP 파일은 서블릿과 다르게 자동 경로 설정됨 -> http://localhost:8080/프로젝트명/day_04/파일명.jsp</h3>
	
	<div>
		<button onclick = "func1(3,4)">선언적 함수 실행</button>
		<button onclick = "func2(3,5)">익명 함수 실행</button>
		<button onclick = "func3(3,6)">람다식 함수 실행</button>
	</div>
	<!-- JS 파일 호출 -->
	<script src="Example1.js"></script>
</body>
</html>