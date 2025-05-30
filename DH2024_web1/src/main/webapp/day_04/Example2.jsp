<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h5> [1] onclick 을 통한 람다식 함수 호출 </h5>
		<button onclick="func1()">func1</button>

		<h5> [2] fetch 함수를 이용한 HTTP 요청 통신 </h5>
		<button onclick="func2()">func2(GET)</button>
		<button onclick="func3()">func3(POST)</button>
		<button onclick="func4()">func4(PUT)</button>
		<button onclick="func5()">func5(DELETE)</button>
		
		<h5> [3] fetch 함수를 이용한 HTTP queryString 요청 통신 </h5>
		<button onclick="func6()">func6(GET)</button>
		<button onclick="func7()">func7(POST)</button>
		<button onclick="func8()">func8(PUT)</button>
		<button onclick="func9()">func9(DELETE)</button>
		
		<h5> [4] fetch 함수를 이용한 HTTP HEADER BODY 요청 통신</h5>
		<button onclick="func10()">func10(POST)</button>
		<button onclick="func11()">func11(PUT)</button>
		<span>GET / DELET 는 관레적으로 BODY 에서 사용하지 않음</span>
		
		<h5> [5] fetch 함수를 이용한 HTTP HEADER BODY 응답 통신</h5>
		<button onclick="func12()">func12(GET)</button>
		<button onclick="func13()">func13(POST)</button>
		<button onclick="func14()">func14(PUT)</button>
		<button onclick="func15()">func15(DELETE)</button>
			
	</div>
	
	<!-- JS 호출 -->
	<script src="Example2.js"></script>

</body>
</html>