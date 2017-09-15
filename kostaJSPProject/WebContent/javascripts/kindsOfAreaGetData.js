$(document).ready(function() {


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
	/**
	 * 동적으로 만들어진 태그들에게 이벤트를 주려면 on을 사용
	 */
	
	// 지역별 공연정보 가져오기
	$(document).on("click", ".cityEvent", function() {
		/** 속성값 출력 테스트 console.log */
		/* console.log($(this).attr('data-item')); */
		let cityNum = $(this).attr('data-item');

		$.ajax({
			type : "POST",
			url : "getKindsOfData.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : {
				"cityNum" : cityNum
			},
			datatype : "json",
			success : function(data) {
				console.log(data);
				console.log(data.result);
				$("#div-content > div").remove();
				
				let div = $("#div-content");
				for (let i = 0; i < data.result.length; i++) {
					div.append(`<div class="w3-row-padding w3-padding-16 w3-center inner-div${i}">`);
					for (let j = 0; j < data.result[i].length; j++) {
						let innerDiv = $(`.inner-div${i}`);
						let rs = data.result[i];
						innerDiv.append(`
						<div class="w3-quarter">
								<div class="img-quarter w3-border w3-padding">
									<img src="./images/${cityNumToName[rs[j].cityNum]}/${rs[j].imageUri}.jpg" alt="${rs[j].name}" class="img-hello">
								</div>
								<h3>${rs[j].typeName} - ${rs[j].name}</h3>
								<h5>장소 : ${rs[j].place}</h5>
								<p>${rs[j].startDate} ~ ${rs[j].endDate}</p>
								<p>${rs[j].startTime} - (${rs[j].runningTime}분)</p>
								<p>출연진 : ${rs[j].cast}</p>
						</div>
						`)
						
					}
					div.append(`</div>`);
				}
			},
			error : function(e) {
				alert("에러발생" + e);
			}
		});
		w3_close();
	});

});


// sidebar 열기/닫기
function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
	document.getElementById("mySidebar").style.display = "none";
}