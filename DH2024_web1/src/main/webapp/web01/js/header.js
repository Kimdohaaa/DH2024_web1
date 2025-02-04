console.log('header.js open');
// [1] 로그인 정보 요청 함수
const getLoginInfo = () => {
	
	// 로그인 상태에 따라 header 를 다르게 출력하기 위해
	let loginMenu = document.querySelector('.loginmenu');
	let html = ``;
	
	
	const option = {method : 'GET'}	// 생략 가능 -> 'GET' 이 기본값이기 때문
	
	fetch('/DH2024_web1/member/point', option)
		.then(res => res.json())
		.then(data => {
			console.log(data); // 주의점 : 코드 변경 후 서버가 자동 재실행 시 세션 초기화(로그아웃)됨
			if(data == null){
				  // 비로그인 상태일 경우 
				   html += `<li class="nav-item">
					          <a class="nav-link" href="/DH2024_web1/web01/member/login.jsp">로그인</a>
					        </li>
					        <li class="nav-item">
					          <a class="nav-link" href="/DH2024_web1/web01/member/signup.jsp">회원가입</a>
					        </li>`	
				}else{
					// 로그인 상태일 경우
					html += `	<li class="nav-item">
							    	<a class="nav-link" href="#""><img class="header_profile" src="/DH2024_web1/upload/${data.mimg}"/>${data.mid} 님</a>
								</li> 
								<li>
									 포인트 : ${data.total} 
								</li>
								<li class="nav-item">
									 <a class="nav-link" href="/DH2024_web1/web01/member/info.jsp">마이페이지</a>
								</li>
								<li class="nav-item">
							    		 <a class="nav-link" href="#" onclick="onLogout()">로그아웃</a>
								</li>
							
							`
				
			}
			loginMenu.innerHTML = html;
		})	
		.catch(e => {console.log(e)})
}
getLoginInfo(); // JS 가 열렸을 때 최초 1번 실행

// [2] 로그아웃
const onLogout = () => {
	
	// 세션을 통해 로그아웃하도록 설계했기 때문에 값 반환받기만 	
	fetch("/DH2024_web1/member/login", {method : 'DELETE'})
		.then(res => res.json())
		.then(data => {
			if(data == true){
				alert('로그아웃 성공')
				location.href = "/DH2024_web1/web01/index.jsp"	// 로그아웃 성공 시 메인페이지로 이동
			}else{
				alert('회원정보가 없습니다.')
			}
		})
		.catch(e => {console.log(e)})	
	
}