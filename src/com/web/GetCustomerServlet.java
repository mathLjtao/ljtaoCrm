package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class GetCustomerServlet extends HttpServlet {
	private CustomerService sc=new CustomerServiceImpl();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Long cust_id=Long.parseLong(req.getParameter("custId"));
		Customer c = sc.getById(cust_id);
		req.setAttribute("customer", c);
		req.getRequestDispatcher("/jsp/customer/edit.jsp").forward(req, res);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}