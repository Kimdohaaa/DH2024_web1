console.log("write.js open")

// summer note 를 실행하는 코드
$(document).ready(function() {
	// summer note 원하는 값으로 커스텀
  $('#summernote').summernote({
	placeholder : '게시물 내용 입력칸', 
	height : 500,
	lang : 'ko-KR'	// 한글 
  });
});

// [1] 글 등록
const onWrite = () => {
	
	const cnoselect = document.querySelector(".cnoselect");
	const titleinput = document.querySelector(".titleinput");
	const contentinput = document.querySelector(".contentinput");
	
	const cno = cnoselect.value;
	const btitle = titleinput.value;
	const bcontent = contentinput.value;

	console.log(cno)	
	console.log(btitle)	
	console.log(bcontent)	
	
	const obj = {
		cno : cno,
		btitle : btitle,
		bcontent : bcontent,
	}
	
	console.log(obj)
	
	const option = {
		method : `POST`,
		headers : {'Content-Type' : "application/json"},
		body : JSON.stringify(obj)
	}
	
	fetch(`/DH2024_web1/board`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert("등록 성공")
			}else{
				alert("등록 실패")
			}
		})
		.catch(e => {console.log(e)})
}