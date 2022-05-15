$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	var status = validateCustomerForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidCustomerIDSave").val() == "") ? "POST" : "PUT";
	$.ajax({
		url : "CustomerAPI",
		type : type,
		data : $("#frmCustomer").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onCustomerSaveComplete(response.responseText, status);
		}
	});
});

function onCustomerSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divCustomersGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidCustomerIDSave").val("");
	$("#frmCustomer")[0].reset();
}

$(document).on("click", ".btnUpdate", function(event) {
	$("#hidCustomerIDSave").val($(this).data("userid")); //change
	$("#firstName").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#lastName").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#accountNumber").val($(this).closest("tr").find('td:eq(2)').text());
	$("#email").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#nic").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#mobile").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#address").val($(this).closest("tr").find('td:eq(6)').text()); 
	$("#userName").val($(this).closest("tr").find('td:eq(7)').text()); 
	$("#password").val($(this).closest("tr").find('td:eq(8)').text()); 
});

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "CustomerAPI",
		type : "DELETE",
		data : "userID=" + $(this).data("userid"),  //change
		dataType : "text",
		complete : function(response, status) {
			onCustomerDeleteComplete(response.responseText, status);
		}
	});
});

function onCustomerDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divCustomersGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENT-MODEL================================================================
function validateCustomerForm() {
	// First Name
	if ($("#firstName").val().trim() == "") {
		return "Insert First Name.";
	}
	// Last Name
	if ($("#lastName").val().trim() == "") {
		return "Insert Last Name.";
	}
	// Account Number-------------------------------
	if ($("#accountNumber").val().trim() == "") {
		return "Insert Account Number.";
	}
	// Email-------------------------------
	if ($("#email").val().trim() == "") {
		return "Insert Email.";
	}
	// NIC-------------------------------
	if ($("#nic").val().trim() == "") {
		return "Insert NIC.";
	}
	// Mobile-------------------------------
	if ($("#mobile").val().trim() == "") {
		return "Insert Mobile.";
	}
	// Address-------------------------------
	if ($("#address").val().trim() == "") {
		return "Insert Address.";
	}
	// User Name-------------------------------
	if ($("#userName").val().trim() == "") {
		return "Insert User Name.";
	}
	// Password-------------------------------
	if ($("#password").val().trim() == "") {
		return "Insert Password.";
	}

	return true;
}
