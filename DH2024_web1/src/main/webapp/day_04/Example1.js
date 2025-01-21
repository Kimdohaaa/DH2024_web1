console.log(`Example1.js 실행`);

// [1] JS 자료형
console.log(3);		// Number 타입(정수)
console.log(3.14);	// Number 타입(실수)
console.log(true);	// boolean 타입(논리)
console.log(null);	// null 타입(객체가 없다.)
console.log(undefined)	// 정의되지 않았다.
console.log("Hello");	// String 타입("")
console.log('Hello');	// String 타입('')
console.log(`Hello`);	// String 타입(``)
console.log([3,3.14,true,`Hello`]);	// Array 타입([])
console.log(function 함수명(){})		// function 타입(Method)
console.log({"속성명1" : 3
			, "속성명2" : 3.14
			, "속성명3" : true
			, "속성명4" : `Hello`})	// object 타입({})
			
// [2] JS 함수
// 2-1. 선언적 함수 : function 함수명(매개변수명, 매개변수명){실행코드;}
function func1(a,b){	// 함수 선언
	console.log(`func1 실행`);
	let c = a+ b;
	return c;
}	
let result1 = func1 (3,4);	// 함수 호출
// 2-2. 익명 함수 : function (매개변수명, 매개변수명){실행코드;}
	// -> 이름이 없는 함수
let func2 = function(a,b){	// 변수를 통해 선언
	console.log(`func2 실행`);
	let c = a+b;
	return c;
} 
const funcC2 = function(a,b){	// 상수를 통해 선언
	console.log(`funcC2 실행`);
	let c = a+b;
	return c;
}	
let result2 = func2(3,5);	// 함수 호출
let resultC2 = funcC2(3,6) 	// 함수 호출
// 2-3. 람다식(화살표) 함수 : (매개변수명, 매개변수명) => {실행코드;}
let func3 = (a,b) => {		// 변수를 통해 선언
	console.log(`func3 실행`);
	let c = a+b;
	return c;
}
const funcC3 = (a,b) => {	// 상수를 통해 선언
	console.log(`funcC3 실행`);
	let c = a+b;
	return c;
}
let result3 = func3(3,7);	// 함수 호출
let resultC3 = funcC3(3,8) 	// 함수 호출


console.log(result1);
console.log(result2);
console.log(resultC2);
console.log(result3);
console.log(resultC3);


// [3] 람다식 함수의 활용처
const words = [`사과`, `수박`, `딸기`, `오렌지`];
// 예] 배열 순회
// 1) 일반 for 문 사용
for(let i = 0; i < words.length; i++){
	console.log(words[i]);
}
// 2) forEach 함수 사용(람다식 함수를 활용한) : 배열 내 요소를 하나씩 반복변수명에 대입
	// 배열변수명.forEach((반복변수명) => {실행문}) 
words.forEach((word) => {console.log(word)});
// 3) map 함수 사용(람다식 함수를 활용한) : 배열 내 요소를 하나씩 반복변수명에 대입
	// 배열변수명.map((반복변수명) => {실행문})
words.map((word) => {console.log(word)});

// * forEach 함수와 map 함수의 차이점 *//
let newWords1 = words.forEach((i) => {return i;})
console.log(newWords1);	// undefined 출력 -> forEach 함수는 return 을 지원하지 않기 때문
let newwords2 = words.map((i) => {return i;})
console.log(newwords2);	// [`사과`, `수박`, `딸기`, `오렌지`] 출력 -> map 함수는 return 을 지원하기 때문

