package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
