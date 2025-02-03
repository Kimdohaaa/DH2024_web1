console.log('signup.js')

// [1] 회원가입 요청 함수
const onSignUp = () => {
	// 1. 요청받은 자료 가져오기(form 단위->첨부파일을 백으로 보내기 위해)
						  // multipart/form-data 타입
						  // form-date 타입으로 전송할 경우 속성명을 'name' 속성으로 사용/구분	
	const signupform = document.querySelector('#signupform');
	console.log(signupform);
	
	// 2. .fetch() 메소드를 이용한 multipart/form-data 타입 전송
	//2-1) 전송할 form 을 바이트(바이너리/스트림) 데이터로 변환
		// FormData 클래스 사용(라이브러리) : Dom 객체 -변환-> 바이트 타입
	const signupformData = new FormData(signupform);
	// signupformData.append("속성명", "값");	-> HTML form 에 없는 데이터 추가하는 법
	// 2-2) fetch 옵션 지정
	const option = {
		method : 'POST',
		// Content-Type 생략 시 자동으로 multipart/form-data 타입(기본값) 지정
		body : signupformData	// multipart/form-data 타입이기 때문에 JSON 으로 형변환 X
	}	
	
	fetch("/DH2024_web1/member/signup", option)
		.then(res => res.json()) // 응답은 JSON 타입으로 받도록 설계함
		.then(data => {
			if(data == true){
				alert('회원가입 성공');
				// 회원가입 성공 시 로그인 페이지로 전환
				location.href="login.jsp";
			}else{
				alert('회원가입 실패');
			}
		})
		.catch(e => {console.log(e)})	// 예외처리(fetch 통신 오류 발생 시)
}
