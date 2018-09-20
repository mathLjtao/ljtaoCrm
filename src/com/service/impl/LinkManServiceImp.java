package com.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.LinkManDao;
import com.dao.impl.LinkManDaoImp;
import com.domain.Customer;
import com.domain.LinkMan;
import com.service.CustomerService;
import com.service.LinkManService;
import com.utils.HibernateUtils;

public class LinkManServiceImp implements LinkManService {
	private LinkManDao lmd=new LinkManDaoImp();
	private CustomerService cs=new CustomerServiceImpl();
	@Override
	public void saveLinkMan(LinkMan lm) {
		//在这里对事务进行处理
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			Customer c=cs.getById(lm.getCust_id());
			lm.setCustomer(c);
			lmd.save(lm);
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}
	
}
