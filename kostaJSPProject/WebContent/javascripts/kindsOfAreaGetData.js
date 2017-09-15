$(document).ready(function() {
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
				
				console.log(data.result[0]);
				$("#div-content div").remove();
				
				let div = $("#div-content");
				for (let i = 0; i < data.result.length; i++) {
					div.append(`<div class="w3-row-padding w3-padding-16 w3-center inner-div${i}">`);
					for (let j = 0; j < data.result[i].length; j++) {
						let innerDiv = $(`.inner-div${i}`);
						innerDiv.append(`
						<div class="w3-quarter">
								<div class="img-quarter w3-border w3-padding">
									<img src="./images/1_Seoul/1_baritone.jpg" alt="${data.result[i].name}" class="img-hello">
								</div>
								<h3>제목 안녕하세용</h3>
								<h5>장소 : 서울덪더갲더개ㅑ저대ㅑ겆대ㅑ거ㅐㅑㄷㅈ거</h5>
								<p>2017-09-15 ~ 2017-09-15 time : 00:00:00</p>
								<p>출연진 : ㅈㄷ거ㅑㅐㅈ더개ㅑㅈ더ㅗ갣좩조대ㅑ괘ㅑㅈㄷ괘ㅑㄷㅈㄱ</p>
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