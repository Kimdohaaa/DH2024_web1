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
		<h3> 회원 매출 조회</h3>
		<div class="content">
			<table border="1" class="findTable">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>고객등급</th>
						<th>매출</th>
					</tr>			
				</thead>
				
				<tbody id="findSbody">
				
				</tbody>
			</table>
		</div>
	</div>
	

	
	<script src="../JS/findS.js"></script>

</body>
</html>