package com.service.impl;

import java.util.List;








import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
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
		Session session=HibernateUtils.getCurrentSession();
		Transaction ts=session.beginTransaction();
		customerDao .save(c);
		ts.commit();
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
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer c = customerDao.getById(id);
		tx.commit();
		return c;
	}
	@Override
	//用于其他service中的一些方法中已经开启事务的，并引用这个方法的
	public Customer getByIdNoTransaction(Long id) {
		
		Customer c = customerDao.getById(id);
		return c;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction ts=session.beginTransaction();
		List<Customer>  list=null;
		list=customerDao.getAll(dc);
		ts.commit();
		return list;
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx=session.beginTransaction();
		customerDao.deleteById(id);
		tx.commit();
				
	}

	@Override
	//更新客户
	public void update(Customer c) {
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.update(c);
		tx.commit();
	}

}
