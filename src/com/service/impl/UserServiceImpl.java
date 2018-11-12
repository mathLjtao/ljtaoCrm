package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.service.UserService;
import com.utils.HibernateUtils;



public class UserServiceImpl implements  UserService {
	private UserDao ud=new UserDaoImpl();
	@Override
	public User login(User user) {
		//开启事务
		HibernateUtils.getCurrentSession().beginTransaction();
		User u=ud.login(user);
		//提交事务
		HibernateUtils.getCurrentSession().beginTransaction().commit();
		if(u==null){
			//throw new RuntimeException("the user no exits！");
			System.out.println("the user no exits！");
		}
		if(!u.getUser_password().equals(user.getUser_password())){
			//throw new RuntimeException("password false！");
			System.out.println("password false！");
		}
		
		return u;
	}
}
