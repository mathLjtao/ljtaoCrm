package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class DeleteCustomerServlet extends HttpServlet {
	private CustomerService customerService  = new CustomerServiceImpl();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Long cust_id=Long.parseLong(req.getParameter("custId"));	
		customerService.deleteById(cust_id);
		res.sendRedirect(req.getContextPath()+"/ListCustomerServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}