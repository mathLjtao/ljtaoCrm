package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dao.CustomerDao;
import com.domain.Customer;
import com.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	public void save(Customer c) {
		SessionFactory sf=HibernateUtils.getSessionFactory();
		//1 获得session
		Session session = sf.openSession();
		//2 打开事务
		Transaction tx = session.beginTransaction();
		//3 执行保存
		session.save(c);
		//4 提交事务
		tx.commit();
		//5 关闭资源
		session.close();
		sf.close();
		
	}

	@Override
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Criteria c = session.createCriteria(Customer.class);
		return c.list();
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Customer c=(Customer)session.get(Customer.class, id);
		return c;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
		
	}

}
