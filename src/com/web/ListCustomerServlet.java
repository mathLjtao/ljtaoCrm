package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class ListCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		CustomerService sc=new CustomerServiceImpl();
		List<Customer> list=null;
		list=sc.getListCustomer();
		
		req.setAttribute("listCustomer", list);
		
		req.getRequestDispatcher("/jsp/customer/list.jsp").forward(req, res);
		//res.getWriter().write("ListCustomerServlet");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}