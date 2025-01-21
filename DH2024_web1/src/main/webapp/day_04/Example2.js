// [1] 람다식 함수 선언
	// const 상수명 = () => {}
const func1 = ( ) => {
	console.log(`func1 execute`)
}

// [2] 람다식 함수 선언 안에서 fetch 함수 활용
	// fetch 함수 : HTTP 비동기 통신을 제공하는 함수

// 2-1. 통신할 서블릿 URL 주소 통신
const func2 = ( ) => {
	// fetch(`HTTP URL`) : 지정한 HTTP URL 과 매핑 
	// day02 의 example1 서블릿 클래스의 get 메소드 매핑
	fetch(`http://localhost:8080/DH2024_web1/day02/example1`);
}
const func3 = () => {
	// doPost METHOD 와 매핑
	fetch(`/DH2024_web1/day02/example1`, {method : `POST`})
}
const func4 = () =>{
	// doPut METHOD 와 매핑
	fetch(`/DH2024_web1/day02/example1`, {method : `PUT`})
}
const func5 = () =>{
	// doDelete METHOD 와 매핑
	fetch(`/DH2024_web1/day02/example1`, {method : `DELETE`})
}

// 2-2. 쿼리스트링 통신
const func6 = () =>{
	// day02 의 exmaple2 서블릿 클래스의 GET 메소드와 매핑
	let name = `유재석`;
	let age = 20;
	// 백틱 템플릿 사용
	fetch(`/DH2024_web1/day02/example2?name=${name}&age=${age}`);
}
const func7 = () =>{
	// day02 의 exmaple2 서블릿 클래스의 POST 메소드와 매핑
	let name = `신동엽`;
	let age = 30;
	const option = {method : `POST`};
	fetch(`/DH2024_web1/day02/example2?name=${name}&age=${age}`, option);
}
const func8 = () => {
	// day02 의 exmaple2 서블릿 클래스의 PUT 메소드와 매핑
	let name = `강호동`;
	let age = 90;
	const option = {method : `PUT`};
	fetch(`/DH2024_web1/day02/example2?name=${name}&age=${age}`, option);
}
const func9 = () => {
	// day02 의 exmaple2 서블릿 클래스의 DELETE 메소드와 매핑
	let name = `서장훈`;
	let age = 55;
	const option = {method : `DELETE`};
	fetch(`/DH2024_web1/day02/example2?name=${name}&age=${age}`, option);
}


// 2-3. HTTP HEADER BODY 요청 통신
const func10 = () => {
	// day03 의 example3 서블릿의 POST 메소드와 매핑
	let object = {data1 : `유재석`, data2 : 50}
	const option = {
		method : `POST`
	   ,headers : {"Content-Type"  : "application/json"}
	   ,body : JSON.stringify(object) // HTTP 통신은 문자열 타입만 가능하기 때문에 문자열로 형변환
	}
	fetch(`/DH2024_web1/day03/example3`,option)
}
const func11 = () => {
	// day03 의 example3 서블릿의 PUT 메소드와 매핑
	let object = {data1 : `신동엽`, data2 : 99};
	const option = {
		method : `PUT`
	   ,headers : {"Content-Type" : "application/json"}
	   ,body : JSON.stringify(object)
	}
	fetch(`/DH2024_web1/day03/example3`, option)
}

// 2-4. HTTP HEADER BODY 응답 통신 
const func12 = () => {
	const option = {method : `GET`};
	fetch(`/DH2024_web1/day03/example5`,option)
		// response 객체를 application/json 타입으로 변환
		// -> 해당 서블릿이 json 타입으로 응답했기 때문에 json 으로 타입변환
		.then(response => response.json())	
		.then(data => {console.log(data);})
		// 예외처리 -> 통신 실패 시
		.catch(error => {console,log(error)})
}
const func13 = () => {
	const option = {method : `POST`};
	fetch(`/DH2024_web1/day03/example5`,option)
		// response 객체를 text/plain 타입으로 변환
		// -> 해당 서블릿이 text 타입으로 응답했기 때문에 text 로 타입변환
		.then(response => response.text())
		.then(data => {console.log(data)})
		// 예외처리 -> 통신 실패 시
		.catch(error => {console,log(error)})
}
const func14 = () => {
	const option = {method : `PUT`}
	fetch(`/DH2024_web1/day03/example5`,option)
		// response 객체를 application/json 타입으로 변환
		// -> 해당 서블릿이 json 타입으로 응답했기 때문에 json 으로 타입변환
		.then(response => {response.json()})
		.then(data => {console.log(data)})
		// 예외처리 -> 통신 실패 시
		.catch(error => {console,log(error)})
}
const func15 = () => {
	const option = {method : `DELETE`}
	fetch(`/DH2024_web1/day03/example5`,option)
		// response 객체를 application/json 타입으로 변환
		// -> 해당 서블릿이 json 타입으로 응답했기 때문에 json 로 타입변환
		.then(res => {res.json()})
		.then(data => {console.log(data)})
		// 예외처리 -> 통신 실패 시
		.catch(e => {console.log(e)})
}
/*
*** fetch 함수 ***
	- fetch 함수 : HTTP 비동기 통신을 제공하는 함수 
	- URL
		1. 통신할 서블릿 URL 주소
		2. 쿼리스트링 	
		- fetch(`HTTP URL`,{옵션}) : 지정한 HTTP URL 과 매핑 
		- fetch(`HTTP URL`,{옵션}) : 지정한 HTTP URL 과 매핑하여 지정한 옵션과 통신 
									-> URL 프로젝트명부터 작성 가능
	- 옵션 
		1. method
			1) fetch(`HTTP URL`, {method : `POST`})
			2) fetch(`HTTP URL`, {method : `GET`})	-> GET 은 기본값으로 생략 가능
			3) fetch(`HTTP URL`, {method : `PUT`})
			4) fetch(`HTTP URL`, {method : `DELETE`})	

		2. headers
			- {"Content=Type" : "application/json"}		
		3. body
			- 전송할 객체
			
	-> 변수에 옵션을 넣어서 변수명으로 사용 가능

	- 참고
		1. 백틱템플릿
		2. JSON 문자열 타입변환 
			- JSON.parse() : 문자열 타입 -변환-> JSON 타입
			- JSON.stringify() : JSON 타입 -변환-> 문자열타입
*** then 함수 ***
	- then 함수 : 다음 함수를 실해시키는 함수
	- fetch(`HTTP URL`, 옵션)
		.then(응답객체명 => 응답객체.타입())	-> 응답객체를 지정한 타입으로 변환(응답하는 서블릿이 응답한 타입으로 변환하기)
		.then(타입변환된자료 => {실행코드})
		
		-> 응답객체
			1) 응답객체.json() -> application/json
			2) 응답객체.text() -> text.plain
*/