<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page = "header.jsp" />
		<div>
		<table border ="1">
			<thead>
				<tr>
					<th> 순번 </th> <th> 차량번호 </th> <th> 차량위치 </th>  <th> 상태 </th> <th> 시간 </th> <th> 요금 </th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td> 1 </td> <td> 220어2543 </td> <td> 9 </td> <td> 입차 </td> <td> 2025.01.23 15:45:00 </td> <td> X </td> 
				</tr>
				<tr>
					<td> 2 </td> <td> 531어5894 </td> <td> 12 </td> <td> 출차 </td> <td> 2025.01.23 15:46:35 </td> <td> 12,000원 </td>
				</tr>
			</tbody>
		</table>
		</div>
		
		<script src="admin.js"></script>
</body>
</html>