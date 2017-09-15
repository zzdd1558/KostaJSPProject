$(document).ready(function() {
	console.log("ready");
	
	$(document).on("click","#removeBtn",function(){
		let command = $(this).attr("data-command");
		let idx = $(this).attr("data-idx");
		let check = confirm("삭제하시겠습니까?");
		let that = this;
		if(check){
			$.ajax({
				type : "POST",
				url : "../manageConcert",
				datatype : "text",
				data : {
					"idx" : idx,
					"command" : command
				},
				success : function(data) {
					alert(data);
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