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
		<h3> 게시판 : 커뮤니티를 제공합니다. </h3>
		<!-- 클릭 시 writer.jsp 로 이동 -->
		<a href="/DH2024_web1/day_05/write.jsp"> 글쓰기 </a>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			
			<tbody>
				
			</tbody>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"/>
	
	<script src="board.js"></script>
	
</body>
</html>