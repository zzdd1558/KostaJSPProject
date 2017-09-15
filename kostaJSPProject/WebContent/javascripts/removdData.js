$(document).ready(function() {
	console.log("ready");
	
	/**
	 *  #removeBtn 클릭시 삭제할꺼냐는 confirm 띄어주고 
	 *  확인 true 취소 false 로 구별해 삭제 또는 취소 하는 이벤트 
	 */
	
	$(document).on("click","#removeBtn",function(){
		
		/** 클릭한 삭제 버튼 속성에 대한 정보 가져오기.*/
		let command = $(this).attr("data-command");
		let idx = $(this).attr("data-idx");
		let table = $(this).attr("data-table");
		
		/** 삭제 여부 체크 확인 true 취소 false*/
		let check = confirm("삭제하시겠습니까?");
		
		/** success 부분에서 this를 사용하면
		 *  confirm 에 대한 this로 바뀌기 때문에 클릭한 this에 대한 정보를 
		 *  let that에 담아 success 에서 사용함으로써 비동기 삭제. 
		 * 
		 * */
		let that = this;
		if(check){
			$.ajax({
				type : "POST",
				/** 경로 파일 :  src/team.controller/ManageConcertController.java*/
				url : "../manageConcert",
				datatype : "text",
				data : {
					"table" : table,
					"idx" : idx,
					"command" : command
				},
				success : function(data) {
					alert(data);
					/** 메소드 체이닝을 이용해서 선택한 버튼의 부모의 부모 태그 삭제.*/
					$(that).parent().parent().remove();
				},
				error : function(e) {
					alert("에러발생" + e);
				}
			});
			
		}else{
			alert("취소되었습니다.");
		}
	});
});