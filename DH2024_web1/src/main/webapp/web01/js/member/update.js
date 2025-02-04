console.log('update.js open')

// [1] 현재 로그인된 회원정보 요청 함수(내 정보 조회) -> 보통 정보 수정 시 기존 정보를 출력해줌
const getMyInfo = () => {
	
	// 1. fetch 욥션
	fetch("/DH2024_web1/member/info") // GET 생략(기본값이기 때문)		
		.then(res => res.json())
		.then(data => {
			if(data != null){ // 만약 로그인 상태라면
				// 특정 DOM 에 정보 출력
				document.querySelector(".mid").value = data.mid;
				document.querySelector(".mname").value = data.mname;
				document.querySelector(".mphone").value = data.mphone;	
				
					// mimg 는 이미지 이기 때문에 value 속성이 아닌 src 속성과 이미지가 있는 경로 사용
				document.querySelector(".mimg").src = `/DH2024_web1/upload/${data.mimg}`;			
			}
		})
		.catch(e => {console.log(e)})	// 예외처리

	}
getMyInfo(); // JS 실행 시 최초 한 번 실행

// 회원 수정
const onUpdate = () => {
	
	// 1. 수정할 데이터 받기
	const mpwdIn = document.querySelector(".mpwd");
	const mnameIn = document.querySelector(".mname");
	const mphoneIn = document.querySelector(".mphone");
	
	const mpwd = mpwdIn.value;
	const mname = mnameIn.value;
	const mphone = mphoneIn.value;

	// 2. 수정 정보 객체화
	const obj  = {
		mpwd : mpwd,
		mname : mname,
		mphone : mphone
	}	

	// fetch 를 통해 back 으로 전달
	const option = {
		method : `PUT`,
		headers : {"Content-Type" : 'application/json'},
		body : JSON.stringify(obj)
	}

	fetch("/DH2024_web1/member/info", option)
		.then(res => res.json())
		.then(data => {
			if(data == true){
				alert('회원정보 수정 완료')
				location.href = "info.jsp"
			}else{
				alert('회원정보 수정 실패')
				location.href = "info.jsp"
			}
			
		})	
		.catch(e => {console.log(e)})
			
}








