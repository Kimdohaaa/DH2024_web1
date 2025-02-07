console.log("view.js open")

// [1] 조회할 게시물번호 PK 키 (bno) 가져오기
	// 관례적으로 게시물번호 등은 쿼리스트링 사용
const findBno = () => {
	// 쿼리스트링 내 매개변수 가져오기
	const bno = new URL(location.href).searchParams.get("bno");
	console.log(bno)
		
	// 쿼리스트링 보내기
	fetch(`/DH2024_web1/board/view?bno=${bno}`) // GET 생략
		.then(r => r.json())
		.then(data => {
			
			console.log(data)
			
			// response 값을 출력할 DOM 객체 생성 / 출력
			document.querySelector(".titlebox").innerHTML = data.btitle;
			document.querySelector(".contentbox").innerHTML = data.bcontent;
			document.querySelector(".midbox").innerHTML = data.mid;
			document.querySelector(".viewbox").innerHTML = data.bview;
			document.querySelector(".datebox").innerHTML = data.bdate;
					
		})
		.catch(e => {console.log(e)})	// 예외처리
}
findBno(); // JS 실행 시 최초 실행