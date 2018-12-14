package com.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;
import com.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService sc=new CustomerServiceImpl();
	private Customer c=new Customer();
	private Integer currentPage;
	private Integer pageSize;
	//添加客户
	public String add() throws  Exception{
		System.out.println(c.getCust_name());
		sc.save(c);
		return "toListCustomer";
	}
	//显示客户列表
	public String  listCustomer () throws Exception{
		List<Customer> list=null;
		String cust_name=ServletActionContext.getRequest().getParameter("cust_name");
		System.out.println("查询客户列表");
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		if(cust_name!=null && !"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
		}
		list=sc.getAll(dc);
		ServletActionContext.getRequest().setAttribute("listCustomer", list);
		return "listCustomer";
	} 
	public String pageListCustomer() throws Exception{
		String cust_name=ServletActionContext.getRequest().getParameter("cust_name");
		
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		if(cust_name!=null && !"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
		}
		PageBean pb=sc.getPageBean(dc,currentPage,pageSize);
		//2将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		
		return "pageListCustomer";
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return c;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}