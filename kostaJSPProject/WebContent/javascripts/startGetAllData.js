$(document).ready(function() {
	
	documentReady();
	
	/**
	 * id가 openNav인 태그를 클릭했을시 ajax를통해 dom control
	 */
	$("#openNav").click(function(){
		// 다시 눌렀을시 중복되어 계속 생성됨으로 지워주고 다시 생성
		$('#mySidebar > a').remove();
		let nav = $("#mySidebar");
		$.ajax({
			type : "POST",
			
			/** src/team.comtroller/GetAllDataController.java*/
			url : "getAllData.do",
			/** contentType json 설정*/
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			datatype : "json",
			
			/** 비동기 성공시 #mySidebar 동적 생성*/
			success : function(data) {
				nav.append(`<a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-right">x</a>`);
	            for(let i = 0; i< data.first.length; i++){
	            	let query = `<a href='#' data-item='${ data.first[i].cityNum }' class='w3-bar-item w3-button cityEvent'>${ data.first[i].cityName}</a>`;
	                nav.append(query);
	            }
	            nav.append(`<a href="#about" id="test" class="w3-bar-item w3-button">만든사람</a> `);
			},
			error : function(e) {
				alert("에러발생" + e);
			}
		});
	});
});

/** 페이지 로딩시 랜덤으로 12개의 콘서트 정보 만들어주기.*/
function documentReady(){
	$.ajax({
		type : "POST",
		url : "getKindsOfData.do",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		datatype : "json",
		data : {
			"command" : "start"
		},
		success : function(data) {
			domController(data);
		},
		error : function(e) {
			alert("에러발생" + e);
		}
	});
}


/** 페이지에 뿌려주는 타입이 같아서 하나의 함수로 정의 */
function domController(data){
	$("#div-content > div").remove();
	$("#h3Tag").remove();
	let div = $("#div-content");
	
	/** length가 0보다 작으면 표현할 데이터가 없음*/
	if(data.result.length <= 0){
		div.append(`<div class="w3-row-padding w3-padding-16 w3-center inner-div">`);
		div.append(`<h3 id="h3Tag"> 데이터가 존재하지 않습니다 </h3>`);
		div.append(`</div>`);
	}else{ /** 0보다 크면 데이터 있음.*/
		for (let i = 0; i < data.result.length; i++) {
			div.append(`<div class="w3-row-padding w3-padding-16 w3-center inner-div${i}">`);
			for (let j = 0; j < data.result[i].length; j++) {
				let innerDiv = $(`.inner-div${i}`);
				let rs = data.result[i];
				/** 콘서트 하나에 대한 데이터를 생성하는 html 문장 */
				innerDiv.append(`
				<div class="w3-quarter">
						<div class="img-quarter w3-border w3-padding">
							<img src="./images/${cityNumToName[rs[j].cityNum]}/${rs[j].imageUri}.jpg" alt="${rs[j].name}" class="img-hello">
						</div>
						<h3>${rs[j].typeName} </h3>
						<h4>${rs[j].name}</4>
						<h5>장소 : ${rs[j].cityName} - ${rs[j].place}</h5>
						<p>${rs[j].startDate} ~ ${rs[j].endDate}</p>
						<p>${rs[j].startTime} - (${rs[j].runningTime}분)</p>
						<p>출연진 : ${rs[j].cast}</p>
				</div>
				`);
			}
			div.append(`</div>`);
		}
	}
}

/** city_num에 따른 폴더명 설정. */
const cityNumToName = {
	    1 : "1_Seoul",
	    2 : "2_Incheon",
	    3 : "3_Deajeon",
	    4 : "4_Gwangju",
	    5 : "5_Gyeonggi",
	    6 : "6_Jeonla",
	    7 : "7_Busan",
	    8 : "8_Daegu",
	    9 : "9_Ulsan",
	    10 : "10_Chungcheong",
	    11 : "11_Gyeongsang",
	    12 : "12_Gangwon",
	    13 : "13_Jeju",
	};