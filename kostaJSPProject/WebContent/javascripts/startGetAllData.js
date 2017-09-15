$(document).ready(function() {
	
	/** 
	 * id가 openNav인 태그를 클릭했을시
	 * ajax를통해 dom control
	 * */
	$("#openNav").click(function(){
		$('#mySidebar > a').remove();
		let nav = $("#mySidebar");
		$.ajax({
			type : "POST",
			url : "getAllData.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			datatype : "json",
			success : function(data) {
				console.log('1'+data.first.length);
				console.log('2'+data.first[0]);
				console.log('3'+data.first[1]);
				console.log('4'+data.first[2]);
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
