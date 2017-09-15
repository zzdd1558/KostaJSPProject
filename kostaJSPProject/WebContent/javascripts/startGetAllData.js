$(document).ready(function() {
	
	documentReady();
	/**
	 * id가 openNav인 태그를 클릭했을시 ajax를통해 dom control
	 */
	$("#openNav").click(function(){
		$('#mySidebar > a').remove();
		let nav = $("#mySidebar");
		$.ajax({
			type : "POST",
			url : "getAllData.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			datatype : "json",
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

function domController(data){
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
}
