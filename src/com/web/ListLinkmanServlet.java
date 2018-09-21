package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.LinkMan;
import com.service.LinkManService;
import com.service.impl.LinkManServiceImp;

public class ListLinkmanServlet extends HttpServlet {
	LinkManService lls=new LinkManServiceImp();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		List<LinkMan> listLm=lls.getAll();
		req.setAttribute("list", listLm);
		req.getRequestDispatcher("/jsp/linkman/list.jsp").forward(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}