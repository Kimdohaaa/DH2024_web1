console.log("board.js open")

/* <카테고리별 출력 코드>
// [1] URL 경로상에 있는 게시판의 cno (카테고리 PK 키) 구하기
	// http://localhost:8080/DH2024_web1/web01/board/board.jsp?cno=1
// 1. URL 상의 쿼리스트링 매개 변수 구하기
console.log(new URL(location.href).searchParams)
	// new URL(location.href).get("매개변수명")
console.log(new URL(location.href).searchParams.get("cno"))	

// [2] 지정한 카테고리 별 게시물 조회 요청
const findall = () => {
	// 쿼리스트링 내 매개변수 가져오기
	const cno = new URL(location.href).searchParams.get("cno");
	
	// URL 상의 쿼리스트링 매개변수 controller 로 전달
	fetch(`/DH2024_web1/board?cno=${cno}` ) // GET 생략
		.then(res => res.json())
		.then(data => {
			console.log(data)
			// data 를 출력할 구역 DOM 객체 가져오기
			const boardlist = document.querySelector(".boardlist > tbody");
			
			let html = ``;
			
			// 전체 출력이기 때문에 반복문을 이용하여 출력
			data.forEach((board) => {
				html += `<tr> 
							<td> ${board.bno} </td>
							<td> <a href="view.jsp?bno=${board.bno}"> ${board.btitle} </a></td>
							<td> ${board.mid} </td>
							<td> ${board.bdate} </td>
							<td> ${board.bview} </td> 
						</tr>`
			})
			// HTML 에 출력
			boardlist.innerHTML = html;
		})
		.catch(e => {console.log(e)}) // 예외처리

}
findall() // JS 실행 시 최초 실행
*/

// <카테고리별 출력 + 페이징 처리 코드>
const findall = () => {
	// 백엔드에 카테고리번호(cno) 와 페이지 번호(pno)를 쿼리스트링으로 전송

	
	// 쿼리스트링 내 매개변수 가져오기 (+ Page 처리)
	const cno = new URL(location.href).searchParams.get("cno"); // 현재 카테고리 번호 가져오기
	let page = new URL(location.href).searchParams.get("page") // 현재 페이지 번호 가져오기
	
	if(page == null){
		page = 1;
	}	// 만약 페이지 번호가 URL 상에 존재하지 않으면 1 페이지 

	// URL 상의 쿼리스트링 매개변수 controller 로 전달
	fetch(`/DH2024_web1/board?cno=${cno}&page=${page}` ) // GET 생략
		.then(res => res.json())
		.then(data => {
			console.log(data)
			// data 를 출력할 구역 DOM 객체 가져오기
			const boardlist = document.querySelector(".boardlist > tbody");
			
			let html = ``;
			
			// 전체 출력이기 때문에 반복문을 이용하여 출력
			data.forEach((board) => {
				html += `<tr> 
							<td> ${board.bno} </td>
							<td> <a href="view.jsp?bno=${board.bno}"> ${board.btitle} </a></td>
							<td> ${board.mid} </td>
							<td> ${board.bdate} </td>
							<td> ${board.bview} </td> 
						</tr>`
			})
			// HTML 에 출력
			boardlist.innerHTML = html;
			getPageBtn(page) // 페이징 버튼 생성 함수 실행
		})
		.catch(e => {console.log(e)}) // 예외처리
	
}
findall()	//  JS  실행 시 최초 실행

// 페이지 버튼 생성 함수 (rptlanf cnffur gn qksqhr)
const getPageBtn = (page) => {	// 현재 페이지 번호 매개변수로 가져오기
	
	// page 가 문자열로 들어오기 때문에 형변환
	page = parseInt(page);
	
	
	let cno = new URL(location.href).searchParams.get("cno");
	
	// 1. 어디에
	let pageBtnBox = document.querySelector(".pagebtnbox");
	
	// 2. 무엇을	
	let html = ``;
	
	// 이전 버튼 (삼항 연산자 추가 : 만약 페이지가 1보다 작으면 page = 0 / 크면 현재 페이지 번호)
	html += `<li class="page-item">
						<a class="page-link" href="board.jsp?cno=${cno}&page=${page <= 1? 1: page-1}">
							이전
						</a>
					</li>`
	// 1 ~ 10 까지 버튼 생성 반복
		// 필요한 데이터 : 최대페이지 , 현재 페이지의 버튼의 시작번호 , 현재 페이지의 버튼의 끝번호 구하기
		// 버튼 시작 번호 : ((page - 1)/ 페이지 당 버튼 수) * 페이지 당 버튼 수 + 1
		// 버튼 끝 번호 : 시작버튼 + (페이지 당 버튼 수  - 1)
	for(let index = 1; index <= 10; index++){
		html += `<li class="page-item">
					<a class="page-link" href="board.jsp?cno=${cno}&page=${index}">
						${index}
					</a>
				</li>`		
	}
	
	// 다음 버튼 (만약 페이지가 최대페이지면 페이지는 해당 페이지)
	html += `<li class="page-item">
						<a class="page-link" href="board.jsp?cno=${cno}&page=${page+1}">
							다음
						</a>
					</li>`	
	// 3. 출력
	pageBtnBox.innerHTML = html;	
}







