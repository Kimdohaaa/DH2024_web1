console.log("board.js open")
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
			const boardlist = document.querySelector(".boardlist");
			
			let html = ``;
			
			// 전체 출력이기 때문에 반복문을 이용하여 출력
			data.forEach((board) => {
				html += `<tr> 
							<td> ${board.bno} </td>
							<td> ${board.btitle} </td>
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
