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
			<div class="parkingLot">
				
			</div>
			<div>
				차량 번호 : <input class="inCnum"/> <br />
				차량 위치 : <input class="inClot"/> <br />
				<button onclick="inCar()">입차</button>
				<button>출차</button>
			</div>
		</div>
	
	
	<script src="user.js"></script>
	
</body>
</html>