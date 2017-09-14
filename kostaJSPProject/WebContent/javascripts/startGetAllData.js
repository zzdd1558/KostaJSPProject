$(document).ready(function() {
	$.ajax({
		type : "POST",
		url : "getAllData",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			id : "zzdd1558",
			pw : "admin"
		},
		datatype : "json",
		success : function(data) {
			alert(data);

		},
		error : function(e) {

			alert("에러발생");
		}
	});
});