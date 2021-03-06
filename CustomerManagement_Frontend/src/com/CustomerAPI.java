package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerAPI")
public class CustomerAPI extends HttpServlet {
	
	Customer customerObj = new Customer();
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = customerObj.insertCustomer(request.getParameter("firstName"),
		request.getParameter("lastName"),
		request.getParameter("accountNumber"),
		request.getParameter("email"),
		request.getParameter("nic"),
		request.getParameter("mobile"),
		request.getParameter("address"),
		request.getParameter("userName"),
		request.getParameter("password"));
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = customerObj.updateCustomer(paras.get("hidCustomerIDSave").toString(),
		paras.get("firstName").toString(),
		paras.get("lastName").toString(),
		paras.get("accountNumber").toString(),
		paras.get("email").toString(),
		paras.get("mobile").toString(),
		paras.get("address").toString(),
		paras.get("userName").toString(),
		paras.get("password").toString());
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = customerObj.deleteCustomer(paras.get("userID").toString());
		response.getWriter().write(output);
	}

}
