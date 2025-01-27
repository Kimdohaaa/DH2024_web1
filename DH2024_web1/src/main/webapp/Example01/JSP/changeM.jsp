<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='../CSS/add.css'>
</head>
<body>

	<jsp:include page='/Example01/JSP/header.jsp'/>
	
	<div id = wrap>
		<h3> 홈쇼핑 회원 목록</h3>
		
		<div id="content">
			<table border="1" class="addtable">
				<thead class="addhead">
					<tr><th>회원번호(자동발생)</th></tr>
					<tr><th>회원성명</th></tr>
					<tr><th>회원전화</th></tr>
					<tr><th>회원주소</th></tr>
					<tr><th>가입일자</th></tr>
					<tr><th>고객등급(A:VIP, B:일반, C:직원)</th></tr>
					<tr><th>도시코드</th></tr>
				</thead>
				
				<tbody class="addbody">
					<tr><td><input class="mnoCh" placeholder="자동발생 됩니다."/></td></tr>
					<tr><td><input class="mnameCh"/></td></tr>
					<tr><td><input class="mphoneCh"/></td></tr>
					<tr><td><input class="maddrCh"/></td></tr>
					<tr><td><input class="mdateCh"/></td></tr>
					<tr><td><input class="mgradeCh"/></td></tr>
					<tr><td><input class="mcityCh"/></td></tr>
				</tbody>
			</table>
			<div class="addBtn">
				<button onclick="changeM()">수정</button>
				<button onclick="window.location.href='findM.jsp'"> 조회 </button>
			</div>			
		</div>
		
	</div>

		
	<script src="../JS/member.js"></script>

</body>
</html>