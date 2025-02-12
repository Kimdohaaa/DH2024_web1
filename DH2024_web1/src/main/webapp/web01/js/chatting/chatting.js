// WS(Web Socket) //
console.log("cahtting.js open")

// [1] WebSocket 클래스를 이용한 클라이언트 소켓 구현
	// let/const 객체명 = new WebSocket("서버 소켓 주소")
	// WebSocket 과 fetch 는 비동기 접속 
	// => 접속 요청 후 응답이 올 때까지 대기하지 않고 JS 코드를 계속 실행
let clientsocket = new WebSocket('ws://localhost:8080/DH2024_web1/chatsocket');


// [2-1] 클라이언트 소켓 -메세지전송-> 서버 소켓
// WebSocket 은 비동기식으로 접속 요청 후 접속 완료 응답 전에 실행 했으므로 오류 발생 O
// clientsocket.send('서버 소켓 안농1'); // 오류 발생
	    								 
// [2-2] 클라이언트 소켓 -메세지전송-> 서버 소켓
// JS 실행 시 접속 완료 후 버튼을 누르기 때문에 오류 발생 X
const onMsgSend = () => {
	
	// 1) 사용자가 입력한 값 가져오기
	const msginput = document.querySelector(".msginput")
	const msg = msginput.value;
	
	// 2) 서버 소켓에게 입력받은 메세지 보내기
	clientsocket.send(msg)
}

// [3] 서버 소켓 -메세지전송-> 클라이언트 소켓
clientsocket.onmessage = ( (event) => {
	console.log("서버 소켓이 보낸 메세지")
	console.log(event);
	console.log(event.data)	// "클라이언트 소켓 안농"

	// 1) 받은 메세지를 HTML 에 출력
	let msgbox = document.querySelector(".msgbox")
	let	html = `<div> 메세지 : ${event.data}`;
	msgbox.innerHTML += html;
})



