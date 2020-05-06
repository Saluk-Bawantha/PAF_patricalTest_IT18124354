$(document).on("click", ".btnUpdate", function(event) { 
	
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIdUpdate').val());
	$("#Phone").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Address").val($(this).closest("tr").find('td:eq(2)').text());
	$("#Specialization").val($(this).closest("tr").find('td:eq(3)').text());
	$("#Email").val($(this).closest("tr").find('td:eq(4)').text());
	$("#Name").val($(this).closest("tr").find('td:eq(5)').text());

	
	$("#alertSuccess").text().trim() == "Data Retrived"

});



$(document).ready(function () {
	 document.forms['form'].reset();
	 
});

$(document).ready(function() { 
	
	if($("#alertSuccess").text().trim() == ""){
		$("#alertSuccess").hide();
	}
	
	$("#alertError").hide(); 
	
});

$(document).on("click", "#btnSave", function(event) { 
	
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text(""); 
	$("#alertError").hide(); 
	
	var status = validateItemForm(); 
	
	if (status != true)  {  
		$("#alertError").text(status);  
		$("#alertError").show();  
		return; 	
		} 
	
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
	
	$.ajax( { 
		url : "DoctorAPI", 
		type : type,  
		data : $("#form").serialize(),  
		dataType : "text",  
		complete : function(response, status) 
		{   
			onItemSaveComplete(response.responseText, status);  
		
		} 
	}); 
	
});

function onItemSaveComplete(response, status) {  
	
	var resultSet = JSON.parse(response); 
	 
	if (resultSet.status.trim() == "success") {  
		
		$("#alertSuccess").text("Successfully saved.");  $("#alertSuccess").show(); 
		 
		 $("#divItemsGrid").html(resultSet.data); 
	
	} else if (resultSet.status.trim() == "error") 
	
	{  
		$("#alertError").text(resultSet.data); 
		$("#alertError").show(); 
		
	}
	else if (status == "error") {
		
		$("#alertError").text("Error while saving.");  
		$("#alertError").show(); 
	}
	 else 
	 {  
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
	 }
	
	$("#hidItemIDSave").val(""); 
	$("#form")[0].reset(); 
}


$(document).on("click", ".btnRemove", function(event) { 
	
	
	$.ajax( { 
		url : "DoctorAPI",   
		type : "DELETE",   
		data : "Appoid=" + $(this).data("appid"),   
		dataType : "text",   
		complete : function(response, status) 
		{   
			onItemDeleteComplete(response.responseText, status);  
		
		} 
	}); 
	
});

function onItemDeleteComplete(response, status) {  
	
	var resultSet = JSON.parse(response); 
	 
	if (resultSet.status.trim() == "success") {  
		
		$("#alertSuccess").text("Successfully deleted."); 
		$("#alertSuccess").show(); 
		 
		 $("#divItemsGrid").html(resultSet.data); 
	
	} else if (resultSet.status.trim() == "error") 
	
	{  
		$("#alertError").text(resultSet.data); 
		$("#alertError").show(); 
		
	}
	else if (status == "error") {
		
		$("#alertError").text("Error while deletingdeleting.");  
		$("#alertError").show(); 
	}
	 else 
	 {  
		 $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 
	 }
	
}



	
	

function validateItemForm() {  
	
	if ($("#Phone").val().trim() == "") {  
		
		return "Please Enter Doctor name !!!";
	} 
	
	if ($("#Address").val().trim() == "") {  
		 
		return "Please Enter Doctor's Address !!!";
	} 
	
	if ($("#Specialization").val().trim() == "") {  

	return "Please Enter Doctor's Specialization !!!";
	} 
	
	if ($("#Email").val().trim() == "...") {  

		return "Please Enter Doctor Email !!!";
	} 
	
	if ($("#Name").val().trim() == "...") {  

		return "Please Enter Doctor Name !!! ";
	}
	
	
	return true; 
	 
	}
