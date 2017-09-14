$(document).ready(function() {
	$("#openNav").click(function(){
		$(".cityNav").remove;
		let nav = $("#mySidebar");
		$('.cityNav').remove();
		
		$.ajax({
			type : "POST",
			url : "getAllData",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			datatype : "json",
			success : function(data) {
				
				nav.append(`<a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-right cityNav">x</a>`);
	            for(let i = 0; i< data.first.length; i++){
	            	let query = `<a href='#${ data.first[i].cityNum }' onclick='w3_close()' class='w3-bar-item w3-button cityNav'>${ data.first[i].cityName}</a>`;
	                nav.append(query);
	            }
	            nav.append(`<a href="#about" onclick="w3_close()" class="w3-bar-item w3-button cityNav">만든사람</a> `);
			},
			error : function(e) {
				alert("에러발생" + e);
			}
		});
	});
	
	$("[href^='#']").click(function(){
		console.log(`click`);
	})
});

//Script to open and close sidebar
function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
	document.getElementById("mySidebar").style.display = "none";
}