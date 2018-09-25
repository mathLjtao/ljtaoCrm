package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class ListCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		CustomerService sc=new CustomerServiceImpl();
		List<Customer> list=null;
		String cust_name=req.getParameter("cust_name");
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		if(cust_name!=null && !"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
		}
		list=sc.getAll(dc);
		
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