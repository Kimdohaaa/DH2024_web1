<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- 회원가입 페이지 -->
	<h1> 회원가입 페이지 </h1>
	
	<!-- 부트스트랩 -->
	<div class="container col-xl-10 col-xxl-8 px-4 py-5">
	    <div class="row align-items-center g-lg-5 py-5">
	      <div class="col-lg-7 text-center text-lg-start">
	        <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3">
	        	더조은 LOGIN PAGE
	        </h1>
	        <p class="col-lg-10 fs-4">
	        	다양한 서비스를 제공합니다.
	        </p>
	      </div>
	      
	      <div class="col-md-10 mx-auto col-lg-5">
	      
	        <form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
	      	  
	      	  <!-- JSON 타입으로 전송하기 위해 ID 속성 사용 -->
	          <div class="form-floating mb-3">
	            <input type="text" class="form-control midInput" id="floatingInput" placeholder="계정아이디">
	            <label for="floatingInput">계정 아이디</label>
	          </div>     
	      
	          <div class="form-floating mb-3">
	            <input type="password" class="form-control mpwdInput" id="floatingPassword" placeholder="계정비밀번호">
	            <label for="floatingPassword">계정 비밀번호</label>
	          </div>
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onLogin()">로그인</button>
	      	
	          <hr class="my-4">

	          <small class="text-body-secondary"><a class="nav-link" href="signup.jsp">회원가입</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">아이디 찾기</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">비밀번호 찾기</a></small>
	      
	        </form>
	      
	      </div>
    </div>
    
    <script src="/DH2024_web1/web01/js/member/login.js"></script>
</body>

</html>