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
	        	더조은 SIGN UP PAGE
	        </h1>
	        <p class="col-lg-10 fs-4">
	        	다양한 서비스를 제공합니다.
	        </p>
	      </div>
	      
	      <div class="col-md-10 mx-auto col-lg-5">
	      
	        <form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
	      	  
	      	  <!-- form-date 타입으로 전송할 경우 속성명을 'name' 속성으로 사용/구분 -->
	          <div class="form-floating mb-3">
	            <input type="text" name="mid" class="form-control" id="floatingInput" placeholder="계정아이디">
	            <label for="floatingInput">계정 아이디</label>
	          </div>     
	      
	          <div class="form-floating mb-3">
	            <input type="password" name="mpwd" class="form-control" id="floatingPassword" placeholder="계정비밀번호">
	            <label for="floatingPassword">계정 비밀번호</label>
	          </div>

			  <div class="form-floating mb-3">
	            <input type="password" class="form-control" id="floatingPassword" placeholder="계정비밀번호확인">
	            <label for="floatingPassword">계정 비밀번호 확인</label>
	          </div>
	          
	          <div class="form-floating mb-3">
	            <input type="text" name="mname" class="form-control" id="floatingInput" placeholder="계정아이디">
	            <label for="floatingInput">계정 닉네임</label>
	          </div>
	          	    
	          <div class="form-floating mb-3">
	            <input type="text" name="mphone" class="form-control" id="floatingInput" placeholder="계정연락처">
	            <label for="floatingInput">계정 연락처</label>
	          </div>
	          
	          <div class="form-floating mb-3">
	            <input type="file" name="uploadfile" class="form-control" id="floatingInput" placeholder="계정프로필">
	            <label for="floatingInput">계정 프로필</label>
	          </div>	     	      
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onSignUp()">회원가입</button>
	      	
	          <hr class="my-4">
	      
	          <small class="text-body-secondary"><a class="nav-link" href="#">아이디 찾기</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">비밀번호 찾기</a></small>
	      
	        </form>
	      
	      </div>
    </div>
    
    <script src="/DH2024_web1/web01/js/member/signup.js"></script>
</body>
</html>