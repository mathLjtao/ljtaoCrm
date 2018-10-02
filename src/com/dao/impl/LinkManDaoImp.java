package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dao.LinkManDao;
import com.domain.LinkMan;
import com.utils.HibernateUtils;

public class LinkManDaoImp implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		session.save(lm);
	}

	@Override
	public List<LinkMan> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Criteria c=session.createCriteria(LinkMan.class);
		return c.list();
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		Criteria c=dc.getExecutableCriteria(session);
		return c.list();
	}

	@Override
	public void deleteById(Long lkm_id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		session.delete(session.get(LinkMan.class, lkm_id));
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		Session s=HibernateUtils.getCurrentSession();
		return s.get(LinkMan.class, lkm_id);
	}

	@Override
	public void update(LinkMan lm) {
		// TODO Auto-generated method stub
		Session s=HibernateUtils.getCurrentSession();
		s.update(lm);
	}

}
