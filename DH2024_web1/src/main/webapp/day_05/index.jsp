<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- index.jsp 에 header.jsp 파일 포함하기  -->
	<jsp:include page="header.jsp"/>
	<div> 
		<h3> 메인 페이지 : 다양한 페이지를 제공합니다. </h3>
	</div>

	<!-- index.jsp 에 footer.jsp 파일 포함하기  -->
	<!-- 해당 파일이 동일한 폴더 내 존재하기 때문에 파일명 / 프로젝트 경로 둘 다 가능 -->
	<jsp:include page="footer.jsp"/>
	<jsp:include page="/day_05/footer.jsp"/>	

</body>
</html>