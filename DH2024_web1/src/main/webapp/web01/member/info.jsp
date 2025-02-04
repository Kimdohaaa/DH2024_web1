<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/DH2024_web1/web01/css/info.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- 회원가입 페이지 -->
	<h1> 회원가입 페이지 </h1>
	
	<!-- 부트스트랩 -->
	<div class="container col-xl-10 col-xxl-8 px-4 py-5">
	    <div class="row align-items-center g-lg-5 py-5">
	      
	      <div class="col-md-10 mx-auto col-lg-5">
	      
	        <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
	      	  
	         <div class="form-floating mb-3 mimgbox">
				<img src="" class="mimg"/> 
	          </div>     
	      	  
	      	  <!-- form-date 타입으로 전송할 경우 속성명을 'name' 속성으로 사용/구분 -->
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mid" class="form-control mid" id="floatingInput" placeholder="계정아이디">
	            <label for="floatingInput">계정 아이디</label> 
	          </div>     
	 
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mname" class="form-control mname" id="floatingInput" placeholder="계정아이디">
	            <label for="floatingInput">계정 닉네임</label>
	          </div>
	          	    
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mphone" class="form-control mphone" id="floatingInput" placeholder="계정연락처">
	            <label for="floatingInput">계정 연락처</label>
	          </div>
	          
	          <!--  disabled input 막기 -->
	          <!--  readonly : 읽기 모드(수정금지) -->
	          
	          
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onUpdate()">회원 수정</button>
	      	  
	      	  <hr class="my-4">
	      	  
	      	  <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onDelete()">회원 탈퇴</button>
	      	
	          
	     
	        </form>
	      
	      </div>
    </div>
    
    <script src="/DH2024_web1/web01/js/member/info.js"></script>
</body>
</html>