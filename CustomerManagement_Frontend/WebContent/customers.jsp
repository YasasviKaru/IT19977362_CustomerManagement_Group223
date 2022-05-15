<%@page import="com.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management System</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/customers.js"></script> 
<link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
</head>
<body>
	<!-- As a heading -->
	<nav class="navbar navbar-dark" style="background: #990000;">
		<h3 style="color: white">Customer Management System</h3>
	</nav>


	<div class="container">

		<form id="frmCustomer" name="frmCustomer"
			style="margin-top: 20px; margin-left: 25%; width: 500px;">

			<div class="form-group">
				<label>First Name</label> <input type="text" name="firstName" id="firstName"
					style="margin-bottom:15px;" class="form-control" placeholder="First Name" size="30px" required>
			</div>

			<div class="form-group">
				<label>Last Name</label> <input type="text" name="lastName"
					id="lastName" style="margin-bottom:15px;" class="form-control" placeholder="Last Name"
					size="30px" required>
			</div>

			<div class="form-group">
				<label>Account Number</label> <input type="text" name="accountNumber"
					id="accountNumber" style="margin-bottom:15px;" class="form-control" placeholder="Account Number"
					size="30px" required>
			</div>

			<div class="form-group">
				<label>Email</label> <input type="text" name="email" id="email"
					style="margin-bottom:15px;" class="form-control" placeholder="Email" size="30px" required>
			</div>
			
			<div class="form-group">
				<label>NIC</label> <input type="text" name="nic" id="nic"
					style="margin-bottom:15px;" class="form-control" placeholder="NIC" size="30px" required>
			</div>
			
			<div class="form-group">
				<label>Mobile</label> <input type="text" name="mobile" id="mobile"
					style="margin-bottom:15px;" class="form-control" placeholder="Mobile" size="30px" required>
			</div>
			
			<div class="form-group">
				<label>Address</label> <input type="text" name="address" id="address"
					style="margin-bottom:15px;" class="form-control" placeholder="Address" size="30px" required>
			</div>
			
			<div class="form-group">
				<label>User Name</label> <input type="text" name="userName" id="userName"
					style="margin-bottom:15px;" class="form-control" placeholder="User Name" size="30px" required>
			</div>	
			
			<div class="form-group">
				<label>Password</label> <input type="password" name="password" id="password"
					style="margin-bottom:15px;" class="form-control" placeholder="Password" size="30px" required>
			</div>
 
			<div class="form-group" align="right">
				<input id="btnSave" name="btnSave" type="button" value="Save" style="margin-bottom:15px;" class="btn btn-primary">
				<input type="hidden" id="hidCustomerIDSave" name="hidCustomerIDSave" value="">
			</div>

		</form>
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		<div id="divCustomersGrid">
		<%
			Customer customerObj = new Customer();
			out.print(customerObj.readCustomers());
		%>
		</div>
	</div>

</body>
</html>
