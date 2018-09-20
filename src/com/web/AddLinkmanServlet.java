package com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.Customer;
import com.domain.LinkMan;
import com.service.CustomerService;
import com.service.LinkManService;
import com.service.impl.CustomerServiceImpl;
import com.service.impl.LinkManServiceImp;

public class AddLinkmanServlet extends HttpServlet {
	private LinkManService lms=new LinkManServiceImp();
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		LinkMan lm=new LinkMan();
		try {
			BeanUtils.populate(lm, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(lm.toString());
		lms.saveLinkMan(lm);
		res.sendRedirect(req.getContextPath()+"/jsp/linkman/list.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}