// console.log('info.js open');

// [1] 현재 로그인된 회원정보 요청 함수(내 정보 조회)
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

// [2] 회원수정 페이지 이동
const onUpdate = () => {
	
	location.href = "update.jsp";	// update.jsp 페이지로 이동
									// 세션을 사용하기 때문에 쿼리스트링으로 PK 키를 넘기지 않아도 됨
			
}



// [4] 회원 탈퇴
const onDelete = () => {
	
	// 유효성 검사 (탈퇴 확인)
	let result =  confirm('정말 탈퇴하시겠습니까?')	
	if(result == false){
		return;	// 만약 취소 버튼 클릭 시 탈퇴 요청 취소
	}

		// fetch
	fetch("/DH2024_web1/member/info", {method : `DELETE`}) 		
		.then(res => res.json())
		.then(data => { 
			if(data == true){
				alert('회원탈퇴 성공')
				location.href ="/DH2024_web1/web01/index.jsp"
			}else{
				alert('회원탈퇴 실패 : 관리자에게 문의')
			}
		}).catch(e => {console.log(e)})
}