// 입차
const inCar = () => {
	let inCnum = document.querySelector(".inCnum");
	let inClot = document.querySelector(".inClot");
	
	let cnum = inCnum.value;
	let clot = inClot.value;
	
	let obj = {
		cnum : cnum,
		clot : clot
	}
	let option = {
		method : `POST`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	}
	
	fetch("/DH2024_web1/day06/user", option)
		.then(res => res.json())
		.then(data => {
			if(data == 0){
				alert("주차 성공")
			}else if(data == 1){
				alert("이미 존재하는 차량번호 입니다.")
			}else if(data == 2){
				alert("해당 자리에 이미 주차된 차량이 있습니다.")
			}
		})
		.catch(e => {console.log(e)})
}