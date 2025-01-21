// [1] 대기명단 등록
const add = () => {
	// 1) HTML 에서 값 가져오기
	let telInput = document.querySelector(".telInput");
	let countInput = document.querySelector(".countInput")
	
	// 2) 입력받은 값 가져오기
	let tel = telInput.value;
	let count = countInput.value;
	
	// 3) 객체화
	let obj = {
		tel : tel,
		count : count
	}
	
	// 4) fetch 함수를 통해 서블릿에게 처리 요청 -> BODY 통신
	const option = {
		method : `POST`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)	// BODY 로 보낼 데이터를 문자열 타입으로 변환
	}
	fetch(`/DH2024_web1/day03/waiting2`, option)
		.then(res => res.json())	// 응답받은 자료 JSON 타입으로 변환
		.then(data => {
			if(data == true){		// 응답이 true 라면
				alert("등록 성공")
				findAll()			// 출력 메소드 새로 고침
			}else{					// 응답이 false 라면
				alert("등록 실패")
			}
		})
		.catch(e => {console.log(e)}) // 예외처리
	
}
// [2] 대기명단 출력
const findAll = () => {
	// 1) 출력할 위치
	let tbody = document.querySelector("tbody");
	let html = ``;
	
	// 2) fetch 함수를 이용해 서블릿에게 처리 요청
	const option = {method : `GET`}	// GET 은 기본값으로 생략 가능
	fetch(`/DH2024_web1/day03/waiting2`, option)
		.then(res => res.json())	// 응답받은 데이터를 JSON 타입으로 변환
		.then(data => {
			data.forEach(obj => {	// for 문 대신 .forEach 함수 사용
				
				html += `<tr>
							<td>${obj.num}</td>
							<td>${obj.tel}</td>
							<td>${obj.count}</td>
							<td>
								<button onclick="up(${obj.num})">수정</button>
								<button onclick="del(${obj.num})">삭제</button>
							</td>
						</tr>`
			})
		
		// 3) 지정한 위치에 출력	
		tbody.innerHTML = html;
		})
		.catch(e => {console.log(e)}) // 예외처리
}
findAll()
// [3] 대기명단 수정(인원수)
const up = (num) => {	// 1) 수정할 PK 키를 매개변수로 받기
	// 2) 수정할 값 받기
	let newTel = prompt(">> 수정할 전화번호")
	let newCount = prompt(">> 수정할 인원수")
	
	// 3) 객체화
	let obj = {
		num : num,
		tel : newTel,
		count : newCount
	}
	
	// 4) fectch 함수를 이용하여 서블릿에게 처리 요청 -> BODY 통신
	const option = {
		method : `PUT`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)	// BODY 에게 보낼 데이터를 문자열 타입으로 변환
	}
	fetch(`/DH2024_web1/day03/waiting2`, option)
		.then(res => res.json()) 	// 응답받은 데이터 JSON 타입으로 변환 	
		.then(data => {
			if(data == true){   	// 응답이 true 라면
				alert("수정 성공")
				findAll();		    // 출력 메소드 새로 고침
			}else{				    // 응답이 false 라면
				alert("수정 실패")
			}
		})
		.catch(e => {console.log(e)}) // 예외처리	
}
// [4] 대기명단 삭제
const del = (num) => {	// 1) 삭제할 PK 키를 매개변수로 받기
	// 2) fetch 함수를 이용하여 서블릿에게 처리 요청 -> 쿼리스트링 통신
	const option = {method : `DELETE`}
	fetch(`/DH2024_web1/day03/waiting2?num=${num}`, option)
		.then(res => res.json())	// 응답받은 데이터를 JSON 타입으로 변환
		.then(data => {
			if(data == true){	// 응답이 true 라면
				alert("삭제 성공")
				findAll()		// 출력 메소드 새로 고침
			}else{				// 응답이 false 라면
				alert("삭제 실패")
			}
		})
		.catch(e => {console.log(e)}) // 예외처리			
}