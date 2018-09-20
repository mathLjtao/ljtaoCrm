package com.service.impl;

import java.util.List;







import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dao.CustomerDao;
import com.dao.impl.CustomerDaoImpl;
import com.domain.Customer;
import com.domain.LinkMan;
import com.service.CustomerService;
import com.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	public void save(Customer c) {
		//调用Dao保存客户
		customerDao .save(c);
	}

	@Override
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction ts=session.beginTransaction();
		List<Customer>  list=null;
		list=customerDao.getListCustomer();
		ts.commit();
		return list;
	}
	//为客户增加联系人
	@Test
	public void fun1(){
		Session session=HibernateUtils.getCurrentSession();
		Transaction ts=session.beginTransaction();
		Customer c=session.get(Customer.class, 2l);
		LinkMan lm=new LinkMan();
		lm.setLkm_name("林一");
		c.getLinkMens().add(lm);
		lm.setCustomer(c);
		session.save(lm);
		ts.commit();
	}
	//为客户删除联系人
	@Test
	public void fun2(){
		Session session=HibernateUtils.getCurrentSession();
		Transaction ts=session.beginTransaction();
		//获取需要操作的对象
		Customer c=session.get(Customer.class, 2l);
		LinkMan lm=session.get(LinkMan.class,2l);
		c.getLinkMens().remove(lm);
		lm.setCustomer(null);
		ts.commit();
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return customerDao.getById(id);
	}

}
