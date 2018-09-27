package com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class UpdateCustomerServlet extends HttpServlet {
	private CustomerService cs  = new CustomerServiceImpl();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Customer c=new Customer();
		
		try {
			BeanUtils.populate(c, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("web"+c.toString());
		cs.update(c);
		res.sendRedirect(req.getContextPath()+"/ListCustomerServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}