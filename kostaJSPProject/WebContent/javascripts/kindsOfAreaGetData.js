$(document).ready(function() {
	
	/**
	 * 동적으로 만들어진 태그들에게 이벤트를 주려면 on을 사용
	 */
	
	// .cityEvent클릭시 지역별 공연정보 가져오기
	$(document).on("click", ".cityEvent", function() {
		/** 속성값 출력 테스트 console.log */
		/* console.log($(this).attr('data-item')); */
		
		// 누른 버튼에 대한 data-item 속성값 가져오기.
		let cityNum = $(this).attr('data-item');

		$.ajax({
			type : "POST",
			/**url 전송 servlet 경로 src/team.controller/GetConcertDataController.java */
			url : "getKindsOfData.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : {
				"cityNum" : cityNum,
				"command" : "area"
			},
			datatype : "json",
			success : function(data) {
				/** 
				 * 화면에 출력해주는 함수에 콜백으로 넘어온 변수data을 매개변수로 domController()실행
				 * domController함수는 WebContent/startGetAllData.js에 존재
				 * */
				domController(data);
			},
			error : function(e) {
				alert("에러발생" + e);
			}
		});
		w3_close();
	});

});



// sidebar open
function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}

// sidebar close
function w3_close() {
	document.getElementById("mySidebar").style.display = "none";
}