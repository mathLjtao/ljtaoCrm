package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.LinkManService;
import com.service.impl.LinkManServiceImp;

public class DeleteLinkmanServlet extends HttpServlet {
	LinkManService ls=new LinkManServiceImp();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Long lkm_id=Long.parseLong(req.getParameter("lkm_id"));
		ls.deleteById(lkm_id);
		res.sendRedirect(req.getContextPath()+"/ListLinkmanServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}