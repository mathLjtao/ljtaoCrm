package com.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService sc=new CustomerServiceImpl();
	
	
	private Customer c=new Customer();
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
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return c;
	}
}