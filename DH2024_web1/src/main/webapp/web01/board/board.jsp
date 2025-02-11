<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header.jsp 연결 -->
	<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="container">
	<button onclick="location.href='write.jsp'" type="button" class="btn btn-primary"> 작성하기 </button>
		<table class="table boardlist">
			<thead>
				<tr>
					<th> 번호 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 작성일 </th>
					<th> 조회수 </th>
				</tr>
			</thead>
			
			<tbody>
			
			</tbody>
		</table>
		
		<!-- 부트스트랩 페이지네이션 -->		
		<nav aria-label="Page navigation example">
		  <ul class="pagination pagebtnbox">
		
		  </ul>
		</nav>
	</div>

	<script src="/DH2024_web1/web01/js/board/board.js" type="text/javascript"></script>
</body>
</html>