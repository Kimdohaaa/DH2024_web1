<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  부트스트랩 CSS  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!--  내가 만든 CSS  -->
<link href="/DH2024_web1/web01/css/index.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg">
  	<div class="container">
    	<!-- 로고  -->
    	<a class="navbar-brand" href="/DH2024_web1/web01/index.jsp">
    		<img class="header_logo" src="/DH2024_web1/img/logo.jpg">
    	</a>
	    
	    <!--  반응형 토큰(버튼) : 디바이스 크기가 작아지면 메뉴를 보여주는 버튼  -->
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    
	    <!-- 메뉴 박스  -->
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    
	     <!--  메뉴 리스트  -->
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	    	<!--  메뉴 항목  -->
	        <li class="nav-item">
	          <a class="nav-link" href="/DH2024_web1/web01/member/login.jsp">로그인</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/DH2024_web1/web01/member/signup.jsp">회원가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">게시판</a>
	        </li>
	        
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            제품
	          </a>
	    
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	    
	        </li>
	      </ul>
	      <form class="d-flex" role="search">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<!--  부트스트랩 JS  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>