package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.LinkMan;
import com.service.LinkManService;
import com.service.impl.LinkManServiceImp;

public class ListLinkmanServlet extends HttpServlet {
	private LinkManService lls=new LinkManServiceImp();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String lkm_name=req.getParameter("lkm_name");
		DetachedCriteria dc=DetachedCriteria.forClass(LinkMan.class);
		if(lkm_name!=null && !"".equals(lkm_name)){
			dc.add(Restrictions.like("lkm_name","%"+lkm_name+"%"));
		}
		
		List<LinkMan> listLm=lls.getAll(dc);
		req.setAttribute("list", listLm);
		req.getRequestDispatcher("/jsp/linkman/list.jsp").forward(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}