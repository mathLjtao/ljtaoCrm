package com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.domain.LinkMan;
import com.service.LinkManService;
import com.service.impl.LinkManServiceImp;

public class UpdateLinkmanServlet extends HttpServlet {
	private LinkManService ls=new LinkManServiceImp() ;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		LinkMan lm=new LinkMan();
		try {
			BeanUtils.populate(lm, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ls.update(lm);
		res.sendRedirect(req.getContextPath()+"/ListLinkmanServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}