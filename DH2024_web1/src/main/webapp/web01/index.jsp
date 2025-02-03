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
	<jsp:include page="header.jsp"></jsp:include>
		<h1> 메인 페이지 </h1>
		
		<!-- 캐러셀 부트스트랩 -->
		
		<!-- 이미지 -->
		<div id="carouselExample" class="carousel slide">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/DH2024_web1/img/img01.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/DH2024_web1/img/img02.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/DH2024_web1/img/img03.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/DH2024_web1/img/img04.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  
		  <!-- 좌/우 버튼 -->
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
</body>
</html>