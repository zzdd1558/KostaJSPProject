$(document).ready(function() {
	/**
	 * 동적으로 만들어진 태그들에게 이벤트를 주려면 on을 사용
	 */
	
	//지역별 공연정보 가져오기
	$(document).on("click", ".cityEvent", function() {
		/** 속성값 출력 테스트 console.log */
		/*console.log($(this).attr('data-item'));*/
		
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