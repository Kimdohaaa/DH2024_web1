// 주의점 : 함수 선언 시 내장 함수와 겹칠 수 있음

// [1] 등록 함수
const visitWrite = () => {
	// 1) HTML 로 부터 input dom 객체 가져오기
	let contentInput = document.querySelector(".contentInput");
	let ageInput = document.querySelector(".ageInput");
	
	// 2) 입력받은 값 가져오기
		// . value : 마크업의 value 속성
	let content = contentInput.value;
	let age = ageInput.value;
	
	// 3) 객체화
	let dataObj = {'content' : content, 'age' : age}
	
	// 4) fetch 를 이용하여 서블릿에게 처리 요청 -> BODY 사용
	let option = {
		method : `POST`
	   , headers : {"Content-Type" : "application/json"}
	   , body : JSON.stringify(dataObj) // BODY 에 보낼 자료를 문자열 타입으로 반환	
	}
	fetch(`/DH2024_web1/day03/visit2`, option)
		.then(res => res.json())	// 응답받은 BODY 자료를 json 타입으로 반환 	
		// 5) 결과에 따른 화면 구현
		.then(data => {				// 반환된 BODY 자료 활용
			if(data == true){
				alert("등록 성공");	// 등록 성공 시
				visitFindAll(); 	// 등록 성공시 안내문구와 테이블에 출력
			}else {
				alert("등록 실패")		// 등록 실패 시
			}})

}
// [2] 출력 함수
const visitFindAll= () => {
	// 1) 어디에 -> <tbody>
	let tbody = document.querySelector("tbody");
	// 2) 무엇을 -> fetch 로부터 받은 자료를
	let html = ``;
		// fetch 를 이용하여 서블릿에게 처리 요청 -> BODY 사용요청
		const option = {method : `GET`}
		fetch(`/DH2024_web1/day03/visit2`, option)
			.then(res => res.json())		// 통신 응답 성공 시 json 타입으로 변환
			.then(data => {
				// for(let i = 0; i < data.length; i++){} // -> 일반 for문을 이용한 방법
				data.forEach(obj => {		// -> forEach() 함수 사용
					console.log(obj);
					
					html += `<tr>
								<td>${obj.num}</td>					
								<td>${obj.content}</td>
								<td>${obj.age}</td>
								<td>
									<button onclick="visitUpdate(${obj.num})"> 수정 </button>
									<button onclick="visitDelete(${obj.num})"> 삭제 </button>
								</td>
							</tr>`
				})
			// 3) 출력
				// . innerHTML : 지정한 마크업에 html 문자열을 대입하는 속성
			tbody.innerHTML = html;
			})
			.catch(e => {console.log(e)})	// 예외처리	
	
}	
visitFindAll();	// 최초 실행

// [3] 수정 함수
const visitUpdate = (num) => {	// 1) 수정할 PK 키를 매개변수로 전달받음
;
	// 2) 수정할 내용 받기
	let contentIn = prompt("수정할 content를 입력하세요.")
	let ageIn = prompt("수정할 age 를 입력하세요.")

	// 3) 객체화
	let dataObj = {
		num : num,
		content : contentIn,
		age : ageIn
	}
		
	// 4) fetch 를 이용하여 서블릿에게 처리 요청 -> BODY 사용
	let option = {
		method : `PUT`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(dataObj)
	}
	fetch(`/DH2024_web1/day03/visit2`, option)
		.then(res => res.json()) // 응답받은 데이터를 JSON 타입으로 변환
		.then(data => {
			if(data == true){	// 만약 응답이 true 라면
				alert("수정 성공")
				visitFindAll()	// table 새로 고침
			}else{				// 만약 응답이 false 라면
				alert("수정 실패")
			}
		})
	
}
// [4] 삭제 함수
const visitDelete = (num) => {	// 1) 삭제할 PK 키를 매개변수로 받음
	
	// 2) fetch 를 이용하여 서블릿에게 처리 요청 -> 쿼리스트링 사용
	let option = {method : `DELETE`}
	fetch(`/DH2024_web1/day03/visit2?num=${num}`, option)
		.then(res => res.json())	// 응답받은 데이터를 JSON 타입으로 변환
		.then(data => {
			if(data == true){	// 만약 응답이 true 이면
				alert("삭제 성공");
				visitFindAll()	// table 새로 고침	
			}else{				// 만약 응답이 false 이면
				alert("삭제 실패")
			}
		})
		.catch(e => {console.log(e)})	// 예외 처리
}





