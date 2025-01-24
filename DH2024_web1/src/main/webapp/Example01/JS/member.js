// [1] 회원등록
const addM = () => {
	let mnoIn = document.querySelector(".mnoIn");
	let mnameIn = document.querySelector(".mnameIn");
	let mphoneIn = document.querySelector(".mphoneIn");
	let maddrIn = document.querySelector(".maddrIn");
	let mdateIn = document.querySelector(".mdateIn");
	let mgradeIn = document.querySelector(".mgradeIn");
	let mcityIn = document.querySelector(".mcityIn");
	
	let mno = mnoIn.value;
	let mname = mnameIn.value;
	let mphone = mphoneIn.value;
	let maddr = maddrIn.value;
	let mdate = mdateIn.value;
	let mgrade = mgradeIn.value;
	let mcity = mcityIn.value;
	
	let obj = {
		mno : mno,
		mname : mname,
		mphone : mphone,
		maddr : maddr,
		mdate : mdate,
		mgrade : mgrade,
		mcity : mcity
	}
	
	const option = {
		method :  `POST`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	}
	
	fetch("/DH2024_web1/example1/member", option)
		.then(res => res.json())
		.then(data => {
			if(data == 0){	// 각 항목 별 유효성 검사를 위해 int(controller) 로 변경하기
				alert("회원등록이 완료되었습니다!")
			}else if(data == 1){
				alert("회원성명이 입력되지 않았습니다.")
			}else if(data == 2){
				alert("회원전화를 바르게 입력하세요.")
			}else if(data == 3){
				alert("회원주소가 입력되지 않았습니다.")
			}else if(data == 4){
				alert("가입일자를 바르게 입력하세요.")
			}else if(data == 5){
				alert("가입일자 월을 바르게 입력하세요.")
			}else if(data == 6){
				alert("가입일자 일을 바르게 입력하세요.")
			}else if(data == 7){
				alert("고객등급을 바르게 입력하세요.")
			}else if(data == 8){
				alert("도시코드가 입력되지 않았습니다.")
			}
		})
		.catch(e => {console.log(e)})
		
}

// [2] 회원수정
const changeM = () => {
	let urlSerch = new URLSearchParams(location.search);
	let mno = urlSerch.get("mno");
	
	
	let mnameCh = document.querySelector(".mnameCh");
	let mphoneCh = document.querySelector(".mphoneCh");
	let maddrCh = document.querySelector(".maddrCh");
	let mdateCh = document.querySelector(".mdateCh");
	let mgradeCh = document.querySelector(".mgradeCh");

	let mcityCh = document.querySelector(".mcityCh");
	console.log(mnameCh, mphoneCh, maddrCh, mdateCh, mgradeCh, mcityCh);

	/*
	if (!mnameCh || !mphoneCh || !maddrCh || !mdateCh || !mgradeCh || !mcityCh) {
	    alert("필수 필드가 누락되었습니다. 페이지를 확인해 주세요.");
	    return;
	}
		*/		
	let mname = mnameCh.value;
	let mphone = mphoneCh.value;
	let maddr = maddrCh.value;
	let mdate = mdateCh.value;
	let mgrade = mgradeCh.value;
	let mcity = mcityCh.value;
	/*
	if (!mname || !mphone || !maddr || !mdate || !mgrade || !mcity) {
	  alert("모든 필드를 입력해 주세요!");
	  return;
	}
	*/
		
	let obj = {
		mno : mno,
		mname : mname,
		mphone : mphone,
		maddr : maddr,
		mdate : mdate,
		mgrade : mgrade,
		mcity : mcity
	}
	
	const option = {
		method : `PUT`,
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	}		
	
	fetch("/DH2024_web1/example1/member", option)
		.then(res => res.json())
		.then(data => {
			if(data == 0){	// 각 항목 별 유효성 검사를 위해 int(controller) 로 변경하기
				alert("회원수정이 완료되었습니다!")
			}else if(data == 1){
				alert("회원성명이 입력되지 않았습니다.")
			}else if(data == 2){
				alert("회원전화를 바르게 입력하세요.")
			}else if(data == 3){
				alert("회원주소가 입력되지 않았습니다.")
			}else if(data == 4){
				alert("가입일자를 바르게 입력하세요.")
			}else if(data == 5){
				alert("가입일자 월을 바르게 입력하세요.")
			}else if(data == 6){
				alert("가입일자 일을 바르게 입력하세요.")
			}else if(data == 7){
				alert("고객등급을 바르게 입력하세요.")
			}else if(data == 8){
				alert("도시코드가 입력되지 않았습니다.")
			}
		})

}
















	