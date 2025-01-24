// [3] 게시물 상세 조회
const find = () => {
	let urlSearch = new URLSearchParams(location.search);
	let  bno = urlSearch.get('bno')

	let find = document.querySelector("#find");
	let html = ``;
	
	fetch(`/DH2024_web1/day05/view?bno=${bno}`)
		.then(res => res.json())
		.then(obj => {
			
				
				html += `글번호 : ${obj.bno}<br/>
						제목 : ${obj.bTitle}</br>
						내용 : ${obj.bContent}</br>
						작성자 : ${obj.bWriter}</br>
						작성일 : ${obj.bDate}</br>
						조회수 : ${obj.bView}</br>
						<a href="update.jsp?bno=${obj.bno}"> 수정 </a>
						<a onclick="boardD(${obj.bno})" > 삭제 </a>
						`
			
		find.innerHTML = html;
		})

	
}
find();

// [3] 게시물 수정
const boardU = () => {
	let urlSearch = new URLSearchParams(location.search);
	let  bno = urlSearch.get('bno')

	let titleUp = document.querySelector(".titleUp");
	let contentUp = document.querySelector(".contentUp")
	let pwdUp = document.querySelector(".pwdUp");
	
	let title = titleUp.value;
	let content = contentUp.value;
	let pwd = pwdUp.value;
	
	let obj = {
		bno : bno,
		bTitle : title,
		bContent : content,
		bPwd : pwd
	}
	
	const option = {
		method : `PUT`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	}
	
	fetch(`/DH2024_web1/day05/board`, option)
		.then (res => res.json())
		.then( data => {
			if(data == true){
				alert("수정 성공")
				window.location.href = "http://192.168.40.34:8080/DH2024_web1/day_05/board.jsp";
			}else{
				alert("수정 실패")
			}
		})
		.catch(e => {console.log(e)})
}

const boardD = (bno) => {
	let pwd = prompt("비밀번호를 입력하세요.")
	
	let obj = {
		bno : bno ,
		bPwd : pwd	
	}
	const option = {
		method : `DELETE`,
		body : JSON.stringify(obj)
	}
	
	fetch(`/DH2024_web1/day05/board`, option)
		.then(res => res.json())
		.then(data => {
			if(data == true){
				alert("삭제 성공")
				window.location.href = "http://192.168.40.34:8080/DH2024_web1/day_05/board.jsp";
			}else{
				alert("삭제 실패")
			}
		})
}
