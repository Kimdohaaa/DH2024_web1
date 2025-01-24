<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page='/Example01/JSP/header.jsp'/>
	
	<div>
		<table border="1">
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
	
	<jsp:include page='/Example01/JSP/footer.jsp'/>
	
	<script src="../JS/findS.js"></script>

</body>
</html>