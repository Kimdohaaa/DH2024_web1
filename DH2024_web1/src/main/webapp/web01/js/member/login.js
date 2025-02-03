console.log('login.js open');
// [1] 로그인 요청함수
const onLogin = () => {
	// 1. HTML INPUT DOM 가져오기
	const midInput = document.querySelector('.midInput');
	const mpwdInput = document.querySelector('.mpwdInput');
	
	// 2. INPUT 입력값 가져오기
	const mid = midInput.value;
	const mpwd = mpwdInput.value;
	
	// 3. 유효성 검사
	// ~~~ 생략 ~~~ //

	// 4. 객체화
	const obj = {
		mid : mid,
		mpwd : mpwd
	}
	
	// 5. BACK 으로 보낼 옵션 지정
	const option = {
		method : 'POST',
		headers : {"Content-Type" : 'application/json'},
		body : JSON.stringify(obj)	// JSON 타입으로 설계했기 때문에 형변환 O	
	}	
	
	// 6. Fatch 메소드를 통해 값 전송 / 반환 하기
	fetch("/DH2024_web1/member/login", option)
		.then(res => res.json())
		.then(data => {
			if(data > 0){
				alert('로그인 성공');
				location.href = "../index.jsp";	// 성공 시 메인페이지로 이동
			}else{
				alert('로그인 실패');
				location.href = "signup.jsp"; // 실패 시 회원가입 페이지로 이동
			}
		})
		.catch(e => {console.log(e)})	// 예외처리
}

