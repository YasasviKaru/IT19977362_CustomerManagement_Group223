package com;
import java.sql.*;

public class Customer {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String readCustomers() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table width = 115%;><tr><th>First Name</th><th>Last Name</th><th>Account Number</th>"
					+ "<th>Email</th><th>NIC</th><th>Mobile</th><th>Address</th><th>User Name</th><th>Password</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String userID = Integer.toString(rs.getInt("userID"));
				String firstName = rs.getString("firstName") ;
				String lastName = rs.getString("lastName");
				String accountNumber = Integer.toString(rs.getInt("accountNumber"));
				String email = rs.getString("email");
				String nic = rs.getString("nic");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				
				// Add into the html table
				output += "<tr><td><input id='hidCustomerIDUpdate' name='hidCustomerIDUpdate' type='hidden' value='" + userID
						+ "'>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + accountNumber + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + userName + "</td>";
				output += "<td>" + password + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-userID='"
						+ userID + "'>" + "</td></tr>";
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the customers.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String insertCustomer(String firstname, String lastname, String accountnumber, String email, String nic, String mobile, String address, String username, String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into customer(`userID`,`firstName`,`lastName`,`accountNumber`,`email`,`nic`,`mobile`,`address`,`userName`,`password` )"

					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, firstname);
			preparedStmt.setString(3, lastname);
			preparedStmt.setInt(4,Integer.parseInt(accountnumber));
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, nic);
			preparedStmt.setString(7, mobile);
			preparedStmt.setString(8, address);
			preparedStmt.setString(9, username);
			preparedStmt.setString(10, password);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newCustomers = readCustomers();
			output = "{\"status\":\"success\", \"data\": \"" + newCustomers + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the customer.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
		
		public String updateCustomer(String firstname, String lastname, String accountnumber, String email, String nic, String mobile, String address, String username, String password) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				
				// create a prepared statement
				String query = "UPDATE customers SET firstName=?,lastName=?,accountNumber=?,email=?,nic=?,mobile=?,address=?,userName=?,password=? WHERE userID =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, firstname);
				preparedStmt.setString(3, lastname);
				preparedStmt.setInt(4,Integer.parseInt(accountnumber));
				preparedStmt.setString(5, email);
				preparedStmt.setString(6, nic);
				preparedStmt.setString(7, mobile);
				preparedStmt.setString(8, address);
				preparedStmt.setString(9, username);
				preparedStmt.setString(10, password);
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newCustomers = readCustomers();
				output = "{\"status\":\"success\", \"data\": \"" + newCustomers + "\"}";
			} catch (Exception e) {
				output = "{\"status\":\"error\", \"data\":\"Error while updating the customer.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String deleteCustomer(String userID ) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				
				// create a prepared statement
				String query = "delete from customer where userID =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(userID ));
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newCustomers = readCustomers();
				output = "{\"status\":\"success\", \"data\": \"" + newCustomers + "\"}";
			} catch (Exception e) {
				output = "{\"status\":\"error\", \"data\":\"Error while deleting the customer.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
	}



