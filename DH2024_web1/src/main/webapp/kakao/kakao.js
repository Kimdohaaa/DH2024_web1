/*
// [1] 마커 생성 //
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
	
	console.log(message) // 선택한 위치 위도 , 경도 출력
	
	// 활용 : 위도 , 경도 를 DB 처리하여 사용
	
	
    // var resultDiv = document.getElementById('clickLatlng'); 
    // resultDiv.innerHTML = message;
    
});
*/



/*
// [2] 마커에 클릭이벤트 등록하기 //
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  
// 마커를 표시할 위치입니다 
var position =  new kakao.maps.LatLng(33.450701, 126.570667);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
  position: position,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
});

// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// marker.setClickable(true);

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      //infowindow.open(map, marker);  
	  
	  // *** 커스텀 ***
	  alert('마커 클릭')
	  
	  // 활용 : 사용자가 마커 클릭 시 사이드바 생성 등의 이벤트 추가
});
*/


/*
// [3] 여러개 마커에 이벤트 등록하기 //

// 1) HTML 의 div 가져오기
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	// 2) 최초 실행 시 지도의 중심 좌표와 확대 레벨 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 3) 설정된 지도 정보를 map 변수에 저장 (지도를 표시할 div, 옵션(지도 좌표 , 확대레벨)) 하여 객체화 
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        title: '카카오', 
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    },
	{	// 학원 위치에 마크업 추가
		title : '더조은 컴퓨터 학원 부평점',
		latlng : new kakao.maps.LatLng(37.4910841087311, 126.72057774665798)
	}
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });

	// *** 커스텀 ***
	// 마커 클릭 이벤트 등록
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      //infowindow.open(map, marker);  
		  
		  // *** 커스텀 ***
		  console.log(marker)
		  
		  alert(`${positions[i].title} 을 클릭`)
		  
		  // 활용 : 사용자가 마커 클릭 시 사이드바 생성 등의 이벤트 추가
	});	
	
}
*/

// [4] 마커 클러스터러 사용하기 //
// => jQuery (JS 라이브러리) 가 있어야 사용 가능
// => ?libraries=clusterer 필요 (카카오지도의 클러스터 기능을 사용하기 위해)
// => 클러스터러 : 근접한 곳에 있는 여러 개의 마커를 하나의 도형으로 표현하는 것

// 1) 카카오 지도의 중심좌표와 확대레벨 설정
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
       center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
       level : 14 // 지도의 확대 레벨 
   });
   
   // 마커 클러스터러를 생성합니다 
   var clusterer = new kakao.maps.MarkerClusterer({
       map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
       averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
       minLevel: 10 // 클러스터가 실행될 레벨 지정
   });

   
   // *** 커스텀 ***
   // $ : jQuery 문법으로 HTTP 통신 메소드 접근자 -> JS 의 fetch() , axios() , ajax() 등 와 같은 기능 
   // => 형식 : $.get('통신할 HTTP 주소', function(data){ RESPONSE 된 값으로 실행할 코드 })
   
   // 2) 공공 데이터 포털에서 받은 값으로 커스텀
   
   // 2-1) fetch 사용
   fetch("https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=35&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D")
   	.then(r => r.json())
	.then( data => {
		console.log(data)	
		// 데이터에서 좌표 값을 가지고 마커를 표시합니다
		 // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
		 let markers = data.data.map((position) => { // map start
			
			// 마커 1개 생성 후 변수에 저장
			let marker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)})
			
			// 위 변수에 저장된 마커의 클릭 이벤트 등록
			kakao.maps.event.addListener(marker, 'click', function() {
			    
				alert(`${position.약국명} 클릭`)
				document.querySelector(".약국명").innerHTML = position.약국명
				document.querySelector(".전화번호").innerHTML = position.전화번호
				document.querySelector(".주소").innerHTML = position.소재지도로명주소
				
				// 사이드바 js 에서 사이드바 생성 버튼 자동 클릭 기능
				document.querySelector(".사이드바").click(); 
			 });
			
			// 마커 이벤트 등록 후 리턴
			return marker;
		 }) // map end

		// 클러스터러에 마커들을 추가합니다
		clusterer.addMarkers(markers);	
		
		})
		.catch(e => {console.log(e)})

   /*
   // 2-2) jQuery get 상요
   $.get("https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=35&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D", function(data) {
       
		console.log(data)	
		// 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.data).map(function(position) {
           return new kakao.maps.Marker({
               position : new kakao.maps.LatLng(position.위도, position.경도)
           });
       });

       // 클러스터러에 마커들을 추가합니다
       clusterer.addMarkers(markers);
   });
   */
   
   
   
   
// 활용 : Geolocation API 를 통해 현재 페이지에 접속된 좌표를 가져와 중심 좌표로 지정 가능 //'
   