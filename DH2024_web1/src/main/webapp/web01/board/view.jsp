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
	
	<div  class="container">

		<div style="text-align : center;">
			작성자 : <span class="midbox"> 작성자 구역 </span>
			조회수 : <span class="viewbox"> 조회수 구역 </span>
			작성일 : <span class="datebox"> 작성일 구역 </span>
		</div>
		
		<div style="text-align : center; font-size : 30px;" class="titlebox">
		
		</div>

		<div style="text-align : center;" class="contentbox">
		
		</div>
		
		<div style="text-align : center;" class="replybox">
			<table style="text-align: center" border="1" class="reply table">
				<thead>
					<tr>
						<th>번호</th>
						<th>내용</th>
						<th>작성일</th>
						<th>작성자</th>
					</tr> 
				</thead>
				
				<tbody class="reply">
				
				</tbody>
			
			</table>
		</div>
		
		<div style="text-align: center">
			<textarea class="replyin" style="width: 1000px; height: 100px"> </textarea>
			<button class="btn btn-primary" type="button" onclick="onReply()">등록</button>
		
		</div>
		
	</div>
	
	<script src="/DH2024_web1/web01/js/board/view.js" type="text/javascript"></script>
</body>
</html>