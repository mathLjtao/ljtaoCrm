package com.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

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
			Customer c=cs.getByIdNoTransaction(lm.getCust_id());
			lm.setCustomer(c);
			lmd.save(lm);
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}
	public List<LinkMan> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<LinkMan> llm=lmd.getAll();
		tx.commit();
		return llm;
	}
	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<LinkMan> llm=lmd.getAll(dc);
		tx.commit();
		return llm;
	}
	@Override
	public void deleteById(Long lkm_id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		lmd.deleteById(lkm_id);
		tx.commit();
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		LinkMan lm=lmd.getById(lkm_id);
		tx.commit();
		return lm;
	}
	
}
