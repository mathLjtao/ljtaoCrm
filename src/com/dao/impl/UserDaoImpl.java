package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.UserDao;
import com.domain.User;
import com.utils.HibernateUtils;

public class UserDaoImpl implements  UserDao {
	
	//根据用户输入的user信息，通过user_code查询数据库中的user
	public User login(User user) {
		Session session=HibernateUtils.getCurrentSession();
		
		/*
		String sql="select * from sys_user where user_code = '"+user.getUser_code()+"'";
		//一开始User中的id字段类型跟数据库的有错，所以一直执行下面的语句都报错。将id的Long类型改为Integer就好了
		Object uniqueResult = session.createSQLQuery(sql).uniqueResult();
		System.out.println(uniqueResult);
		User u1=(User)uniqueResult;
		System.out.println(u1);
		
		
		Criteria c=session.createCriteria(User.class);
		c.add(Restrictions.eq("user_code",user.getUser_code()));
		List list = c.list();
		*/
		
		
		
		//2 书写HQL
		String hql = "from User where user_code = ? ";
		//3 创建查询对象
		Query query = session.createQuery(hql);
		//4 设置参数
		query.setParameter(0, user.getUser_code());
		//5 执行查询
		User u = (User) query.uniqueResult();
		
		return u;
	}
}
