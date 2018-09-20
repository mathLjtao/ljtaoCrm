package com.web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.domain.Customer;
import com.utils.HibernateUtils;

public class Test {
	public static void main(String[] args){
		Test test=new Test();
		test.run1();
		
	}
	public void run1(){
		SessionFactory sf=HibernateUtils.getSessionFactory();
		Session session=sf.openSession();
		Customer cust=new Customer();
		cust.setCust_industry("hhh");
		cust.setCust_name("aa");
		session.save(cust);
		session.close();
		sf.close();
	}
	
}
