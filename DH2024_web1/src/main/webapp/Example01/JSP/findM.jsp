<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='../CSS/find.css'>
</head>
<body>

	<jsp:include page='/Example01/JSP/header.jsp'/>
	
	<div id="wrap">
		<h3> 회원 목록 조회 / 수정</h3>
		<div class="content">
			<table border="1" class="findTable">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>가입일자</th>
						<th>고객등급</th>
						<th>거주지역</th>
					</tr>
				</thead>
				
				<tbody id="findMbody">
				
				</tbody>
			</table>
		</div>
	</div>
	
	<script src="../JS/findM.js"></script>

</body>
</html>