<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> DAY_03 VISIT2 화면 구현</h3>
	
	<div>
		<h4> [1] 방문록 작성 </h4>
		내용 : <input class="contentInput"/> <br/>
		나이 : <input class="ageInput" /> <br/>
		<button type = "button" onclick="visitWrite()"> 등록 </button>	
	</div>
	
	<div>
		<h4> [2] 방문록 목록 </h4>
		<table border="1">
			<thead> 
				<tr>
					<th>num</th>
					<th>content</th>
					<th>age</th>
					<th>etc</th>
				</tr>	
			</thead>
			<tbody>
				<!-- innerHTML -->
			</tbody>
		</table>
	</div>

	<script src="task1.js"></script>
</body>
</html>