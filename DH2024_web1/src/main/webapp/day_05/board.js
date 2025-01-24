// [1] 게시물 증록
const boardC = () => {
	let titleIn = document.querySelector(".titleIn");
	let contentIn = document.querySelector(".contentIn");
	let writerIn = document.querySelector(".writerIn");
	let pwdIn = document.querySelector(".pwdIn");
	
	let bTitle = titleIn.value;
	let bContent = contentIn.value;
	let bWriter = writerIn.value;
	let bPwd = pwdIn.value;
	
	let obj = {
		bTitle : bTitle,
		bContent : bContent,
		bWriter : bWriter,
		bPwd : bPwd
	}
	
	const option = {
		method : `POST`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)	// BODY 로 보낼 데이터를 문자열 타입으로 변환
	}
		
	fetch(`/DH2024_web1/day05/board`, option)
		.then(res => res.json())
		.then(data => {
			if(data == true){
				alert("등록 성공")
				window.location.href = "http://192.168.40.34:8080/DH2024_web1/day_05/board.jsp";
			}else{
				alert("등록 실패")
			}
		})
		.catch(e => {console.log(e)})
}

// [2] 게시물 전체 조회
const findAll = () => {
	let tbody = document.querySelector("tbody")
	let html = ``;
	
	fetch(`/DH2024_web1/day05/board`)
		.then(res => res.json())
		.then(data => {
			data.forEach(obj => {
				
				html += `<tr>
							<td>${obj.bno}</td>
							<td><a href="view.jsp?bno=${obj.bno}" onclick="find(${obj.bno})">${obj.bTitle}</a></td>
							<td>${obj.bDate}</td>
							<td>${obj.bWriter}</td>
							<td>${obj.bView}</td>
						</tr>`
			})
			
			tbody.innerHTML = html;
		})
		.catch(e => {console.log(e)})
}
findAll()	







